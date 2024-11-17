package org.ngm;

import org.ngm.hello.GreetingClient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class App {
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(App.class, args);

        GreetingClient client = context.getBean(GreetingClient.class);

        System.out.println(">> message = " + client.getMessage().block());
    }
}
