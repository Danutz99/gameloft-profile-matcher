package gameloft.interview.profilematcher.util;

import java.time.OffsetDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.bson.codecs.Codec;
import org.bson.codecs.configuration.CodecProvider;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.core.convert.converter.Converter;

public class OffsetDateTimeToDateConverter implements Converter<OffsetDateTime, Date> {

  @Override
  public Date convert(final OffsetDateTime source) {
    return source != null ? Date.from(formatOffsetDateTime(source).toInstant().atZone(ZoneOffset.UTC).toInstant())
        : null;
  }

  public static OffsetDateTime formatOffsetDateTime(OffsetDateTime source) {
    if (!source.toString().contains(OffsetDateTimeDeserializer.ISO_OFFSET_DATE_TIME_SEPARATOR)) {
      return OffsetDateTime.parse(source.toString(), OffsetDateTimeDeserializer.ISO_OFFSET_DATE_TIME_WITHOUT_T);
    } else
      return source;
  }
}
