package io.disc99.todo;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class BeanProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T provider(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        BeanProvider.context = context;
    }
}