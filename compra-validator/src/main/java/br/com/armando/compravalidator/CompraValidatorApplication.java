package br.com.armando.compravalidator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableReactiveMongoRepositories;

@SpringBootApplication
@EnableReactiveMongoRepositories
public class CompraValidatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompraValidatorApplication.class, args);
    }

}
