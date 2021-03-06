package ru.itis.dis.s2lab7.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.itis.dis.s2lab7.service.ProfilingAnnotationBeanPostProcess;
import ru.itis.dis.s2lab7.service.TextInjectAnnotationBeanPostProcessor;

@Configuration
public class Config {

    @Bean
    ProfilingAnnotationBeanPostProcess getProfilingAnnotationBeanPostProcess() {
        return new ProfilingAnnotationBeanPostProcess();
    }

    @Bean
    TextInjectAnnotationBeanPostProcessor injectAnnotationBeanPostProcessor() {
        return new TextInjectAnnotationBeanPostProcessor();
    }
}
