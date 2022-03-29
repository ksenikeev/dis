package ru.itis.dis.s2lab7.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import ru.itis.dis.s2lab7.controllers.TextInject;

import java.lang.reflect.Field;

public class TextInjectAnnotationBeanPostProcessor implements BeanPostProcessor {
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            TextInject textInject = field.getAnnotation(TextInject.class);
            if (textInject != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, "Hello from TextInject!");
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
