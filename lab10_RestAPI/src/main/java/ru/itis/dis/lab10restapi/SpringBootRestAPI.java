package ru.itis.dis.lab10restapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import ru.itis.dis.lab10restapi.model.Bank;

@SpringBootApplication
public class SpringBootRestAPI {
    public static void main(String[] args) {

        ApplicationContext context = SpringApplication.run(SpringBootRestAPI.class, args);

        Bank bank = new Bank();
        bank.setName("bank1");
        RestTemplate client = new RestTemplate();
        HttpEntity<Bank> bankRequest = new HttpEntity<>(bank);
        Bank response = client.postForObject("http://localhost:8080/addbank", bankRequest, Bank.class);
        System.out.println(response.getName() + ", " + response.getInnerId());

        WebClient webClient;

    }
}
