package com.example.microservicespro;

import com.example.microservicespro.model.Person;
import com.example.microservicespro.repository.PersonRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class MicroservicesProApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroservicesProApplication.class, args);
    }
    @Bean
    ApplicationRunner init(PersonRepository personRepository) {
        personRepository.save(new Person("taha", "ben"));
        personRepository.save(new Person("test", "ben"));
        return args -> {};
    };
}
