package gameloft.interview.profilematcher.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.springframework.core.convert.converter.Converter;

public class DateToOffsetDateTimeConverter implements Converter<Date, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(final Date source) {
    return source != null
        ? OffsetDateTimeToDateConverter.formatOffsetDateTime(source.toInstant().atOffset(ZoneOffset.UTC))
        : null;
  }
}
