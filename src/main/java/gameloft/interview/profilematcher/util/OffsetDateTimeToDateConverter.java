package gameloft.interview.profilematcher.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.util.Date;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.core.convert.converter.Converter;

public class OffsetDateTimeToDateConverter implements Converter<OffsetDateTime, Date>, CodecProvider {

  @Override
  public Date convert(final OffsetDateTime source) {
    return source != null ? Date.from(source.toInstant().atZone(ZoneOffset.UTC).toInstant()) : null;
  }

  @Override
  public <T> Codec<T> get(Class<T> clazz, CodecRegistry registry) {
    throw new RuntimeException("Not implemented yet!!!");
  }
}
