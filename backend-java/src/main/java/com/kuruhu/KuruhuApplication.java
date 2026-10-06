package com.kuruhu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.scheduling.annotation.EnableAsync;

/**
 * Kuruhu Application Backend Architecture Scaffold.
 * Criminal Investigation & Police Intelligence Platform for Karnataka State Police.
 */
@SpringBootApplication
@EnableJpaAuditing
@EnableAsync
public class KuruhuApplication {

    public static void main(String[] args) {
        SpringApplication.run(KuruhuApplication.class, args);
    }
}
