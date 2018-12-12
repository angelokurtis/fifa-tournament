package com.sensedia.labs.infra.database;

import javax.persistence.AttributeConverter;
import javax.persistence.Converter;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Optional;

@Converter(autoApply = true)
public class LocalDateConverter implements AttributeConverter<LocalDate, Timestamp> {

  @Override
  public Timestamp convertToDatabaseColumn(final LocalDate localDate) {
    return Optional.ofNullable(localDate)
        .map(LocalDate::atStartOfDay)
        .map(Timestamp::valueOf)
        .orElse(null);
  }

  @Override
  public LocalDate convertToEntityAttribute(final Timestamp timestamp) {
    return Optional.ofNullable(timestamp)
        .map(Timestamp::toLocalDateTime)
        .map(LocalDateTime::toLocalDate)
        .orElse(null);
  }
}