package com.trackival.service.common;

import graphql.scalars.ExtendedScalars;
import graphql.schema.GraphQLScalarType;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GraphQlConfig {
    @Bean
    public GraphQLScalarType dateScalar() {
        return ExtendedScalars.Date;
    }

    @Bean
    public GraphQLScalarType dateTimeScalar() {
        return ExtendedScalars.DateTime;
    }
}
