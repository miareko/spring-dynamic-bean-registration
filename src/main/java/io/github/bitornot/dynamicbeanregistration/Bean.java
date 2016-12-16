package io.github.bitornot.dynamicbeanregistration;

/**
 * Created by dddew on 2016/12/16.
 */
public class Bean {

    private String beanName;

    public void setBeanName(String beanName) {
        this.beanName = beanName;
    }

    public String getBeanName() {
        return beanName;
    }

    public void func() {
        System.out.println("I'm a " + getBeanName());
    }
}
