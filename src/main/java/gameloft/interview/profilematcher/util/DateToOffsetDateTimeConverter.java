package gameloft.interview.profilematcher.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.databind.util.Converter;

public class DateToOffsetDateTimeConverter implements Converter<Date, OffsetDateTime> {

  @Override
  public OffsetDateTime convert(Date source)

  {
    if (source == null) {
      return null;
    }
    return OffsetDateTime.ofInstant(source.toInstant(), ZoneOffset.UTC);
  }

  @Override
  public JavaType getInputType(TypeFactory typeFactory) {
    throw new RuntimeException("Not implemented yet!!!");
  }

  @Override
  public JavaType getOutputType(TypeFactory typeFactory) {
    throw new RuntimeException("Not implemented yet!!!");
  }
}
