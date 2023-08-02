package com.cj.crud.employees;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.List;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository repository){
        return args -> {
          Employee Kenneth =  new Employee(
                    "Kenneth",
                    "Julianda",
                    "kennethjulianda1207@gmail.com",
                    LocalDate.of(2017,01,31),
                    "Senior OS Developer");

          Employee Alex =  new Employee(
                    "Alex",
                    "Sangcal",
                    "alex@gmail.com",
                    LocalDate.of(2019,01,31),
                    "Senior Front-End Developer");

          repository.saveAll(List.of(Kenneth,Alex));
        };
        };


    }

