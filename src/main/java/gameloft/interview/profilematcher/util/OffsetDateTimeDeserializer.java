package gameloft.interview.profilematcher.util;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OffsetDateTimeDeserializer extends StdDeserializer<OffsetDateTime> {

  public static final DateTimeFormatter ISO_OFFSET_DATE_TIME_WITHOUT_T = DateTimeFormatter
    .ofPattern("yyyy-MM-dd HH:mm:ssX");

  public static final String ISO_OFFSET_DATE_TIME_SEPARATOR = "T";

  public OffsetDateTimeDeserializer() {
    super(OffsetDateTime.class);
  }

  @Override
  public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
    String dateStr = parser.getValueAsString();
    try {
      return OffsetDateTime.parse(dateStr, getFormatter(dateStr));
    } catch (DateTimeParseException e) {
      throw new RuntimeException(e);
    }
  }

  private DateTimeFormatter getFormatter(String dateStr) {
    return dateStr.contains(ISO_OFFSET_DATE_TIME_SEPARATOR) ? DateTimeFormatter.ISO_OFFSET_DATE_TIME
        : ISO_OFFSET_DATE_TIME_WITHOUT_T;
  }
}
