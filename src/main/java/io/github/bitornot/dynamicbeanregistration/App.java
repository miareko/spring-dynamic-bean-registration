package io.github.bitornot.dynamicbeanregistration;

import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.GenericBeanDefinition;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dddew on 2016/12/16.
 */
@Configuration
public class App {

    private ApplicationContext applicationContext;

    public static void main(String[] args) {
        new App().run(args);
    }

    public void run(String[] args) {
        applicationContext = new AnnotationConfigApplicationContext(App.class);

        ConfigurableApplicationContext configurableApplicationContext = (ConfigurableApplicationContext) applicationContext;
        DefaultListableBeanFactory beanFactory = (DefaultListableBeanFactory) configurableApplicationContext.getBeanFactory();

        GenericBeanDefinition beanDefinition = new GenericBeanDefinition();
        beanDefinition.setBeanClass(Bean.class);
        MutablePropertyValues values = new MutablePropertyValues();
        values.add("beanName", "dynamicBean");
        beanDefinition.setPropertyValues(values);
        beanDefinition.setLazyInit(false);
        beanFactory.registerBeanDefinition("dynamicBean", beanDefinition);

        /*BeanDefinitionBuilder beanDefinitionBuilder = BeanDefinitionBuilder.genericBeanDefinition(Bean.class);
        beanDefinitionBuilder.addPropertyValue("beanName", "dynamicBean");
        beanFactory.registerBeanDefinition("dynamicBean", beanDefinitionBuilder.getRawBeanDefinition());*/

        Bean bean = (Bean) applicationContext.getBean("dynamicBean");
        bean.func();
    }
}
