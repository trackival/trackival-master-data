package com.trackival.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;

@SpringBootApplication
public class TrackivalServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(TrackivalServiceApplication.class, args);
    }

    /**
     * Register the {@link OpenEntityManagerInViewFilter} so that the
     * GraphQL-Servlet can handle lazy loads during execution.
     */
    @Bean
    public Filter OpenFilter() {
        return new OpenEntityManagerInViewFilter();
    }
}
