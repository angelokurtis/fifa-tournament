package com.sensedia.labs.infra.rest;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurerAdapter;

@Configuration
public class ApiRestConfiguration extends RepositoryRestConfigurerAdapter {

  @Override
  public void configureRepositoryRestConfiguration(final RepositoryRestConfiguration config) {
    config.getMetadataConfiguration().setAlpsEnabled(false);
  }
}
