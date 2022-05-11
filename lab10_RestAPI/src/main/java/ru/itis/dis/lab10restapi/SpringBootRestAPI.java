package ru.itis.dis.lab10restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.ApplicationPidFileWriter;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.itis.dis.lab10restapi.model.Bank;

@SpringBootApplication
public class SpringBootRestAPI {
    public static void main(String[] args) {
        //SpringApplication.run(SpringBootRestAPI.class, args);

        SpringApplicationBuilder app = new SpringApplicationBuilder(SpringBootRestAPI.class);
               // .web(WebApplicationType.SERVLET);
        app.build().addListeners(new ApplicationPidFileWriter("shutdown.pid"));
        app.run();
    }
}
