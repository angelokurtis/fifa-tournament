package com.sensedia.labs.infra.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateTimeConverter implements AttributeConverter<LocalDateTime, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(final LocalDateTime localDateTime) {
    return Optional.ofNullable(localDateTime)
        .map(Timestamp::valueOf)
        .orElse(null);
  }

  @Override
  public LocalDateTime convertToEntityAttribute(final Timestamp timestamp) {
    return Optional.ofNullable(timestamp)
        .map(Timestamp::toLocalDateTime)
        .orElse(null);
  }
}