package ru.itis.dis.s2lab4.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import ru.itis.dis.s2lab4.orm.DbWork;

@Configuration
@ComponentScan({"ru.itis.dis.s2lab4"})
public class Config {


    @Bean(destroyMethod = "destroy")
    @Scope("singleton")
    public DbWork getDbWork(CharSequence url) {
        return new DbWork(url);
    }

    @Bean
    public CharSequence getUrl () {
        return "url";
    }

}