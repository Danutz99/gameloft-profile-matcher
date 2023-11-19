package gameloft.interview.profilematcher.util;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeParseException;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

public class OffsetDateTimeDeserializer extends StdDeserializer<OffsetDateTime> {

  public OffsetDateTimeDeserializer() {
      super(OffsetDateTime.class);
  }

  @Override
  public OffsetDateTime deserialize(JsonParser parser, DeserializationContext context) throws IOException {
      String dateStr = parser.getValueAsString();
      try {
          return OffsetDateTime.parse(dateStr);
      } catch (DateTimeParseException e) {
        // Handle the exception or log it
          return null;
      }
  }
}
