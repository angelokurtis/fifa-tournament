package com.sensedia.labs.infra.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDate;

public class LocalDateSerializer extends JsonSerializer<LocalDate> {

  @Override
  public void serialize(final LocalDate value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException, JsonProcessingException {
    gen.writeString(value.toString());
  }
}
