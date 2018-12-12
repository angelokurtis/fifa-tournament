package com.sensedia.labs.infra.rest;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateDeserializer extends JsonDeserializer<LocalDate> {

  @Override
  public LocalDate deserialize(final JsonParser p, final DeserializationContext ctxt) throws IOException, JsonProcessingException {
    return LocalDate.parse(p.getText());
  }
}
