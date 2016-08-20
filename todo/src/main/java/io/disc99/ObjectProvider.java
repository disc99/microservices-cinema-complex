package io.disc99;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class ObjectProvider implements ApplicationContextAware {

    private static ApplicationContext context;

    public static <T> T provide(Class<T> clazz) {
        return context.getBean(clazz);
    }

    @Override
    public void setApplicationContext(ApplicationContext context) throws BeansException {
        ObjectProvider.context = context;
    }
}