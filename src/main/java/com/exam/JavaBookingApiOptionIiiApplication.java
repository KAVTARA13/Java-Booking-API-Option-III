package com.exam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class JavaBookingApiOptionIiiApplication {

    public static void main(String[] args) {
        SpringApplication.run(JavaBookingApiOptionIiiApplication.class, args);
    }

}
