package ru.itis.dis.s2lab7.service;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.util.ReflectionUtils;
import ru.itis.dis.s2lab7.controllers.EM;
import ru.itis.dis.s2lab7.controllers.TextInject;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.lang.reflect.Field;

public class EMAnnotationBeanPostProcessor implements BeanPostProcessor {

    private static EntityManagerFactory entityManagerFactory;

    static {
        entityManagerFactory =
                Persistence.createEntityManagerFactory("lab7");
    }

    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        Field[] fields = bean.getClass().getDeclaredFields();
        for (Field field : fields) {
            EM textInject = field.getAnnotation(EM.class);
            if (textInject != null) {
                field.setAccessible(true);
                ReflectionUtils.setField(field, bean, entityManagerFactory.createEntityManager());
            }
        }
        return bean;
    }

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        return null;
    }
}
