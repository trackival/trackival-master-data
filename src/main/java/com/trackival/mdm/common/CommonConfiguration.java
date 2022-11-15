package com.trackival.mdm.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;

import javax.servlet.Filter;
import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class CommonConfiguration {

    public @Bean Random random() {
        return new Random();
    }

    /**
     * Register the {@link OpenEntityManagerInViewFilter} so that the
     * GraphQL-Servlet can handle lazy loads during execution.
     */
    public @Bean Filter openFilter() {
        return new OpenEntityManagerInViewFilter();
    }
}
