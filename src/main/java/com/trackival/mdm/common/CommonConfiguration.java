package com.trackival.mdm.common;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Random;

@Configuration
@RequiredArgsConstructor
public class CommonConfiguration {

    public @Bean Random random() {
        return new Random();
    }
}
