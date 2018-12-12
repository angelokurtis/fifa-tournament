package com.sensedia.labs.infra.rest;

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.SerializerProvider;

import java.io.IOException;
import java.time.LocalDateTime;

public class LocalDateTimeSerializer extends JsonSerializer<LocalDateTime> {

  @Override
  public void serialize(final LocalDateTime value, final JsonGenerator gen, final SerializerProvider serializers) throws IOException, JsonProcessingException {
    gen.writeString(value.toString());
  }
}
