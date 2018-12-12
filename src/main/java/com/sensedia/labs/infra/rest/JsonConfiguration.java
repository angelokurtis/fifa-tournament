package com.sensedia.labs.infra.rest;

import org.springframework.boot.autoconfigure.jackson.Jackson2ObjectMapperBuilderCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import static com.fasterxml.jackson.databind.DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES;
import static com.fasterxml.jackson.databind.PropertyNamingStrategy.SNAKE_CASE;

@Configuration
public class JsonConfiguration {

  @Bean
  public Jackson2ObjectMapperBuilderCustomizer addCustomBigDecimalDeserialization() {
    return builder -> {
      builder.propertyNamingStrategy(SNAKE_CASE);
      builder.featuresToDisable(FAIL_ON_UNKNOWN_PROPERTIES);
    };
  }
}
