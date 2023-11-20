package gameloft.interview.profilematcher.util;

import static org.assertj.core.api.Assertions.assertThat;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class MongoOffsetDateTimeConverterTest {

  @Test
  void testConvertFromDateToOffsetDateTime() throws ParseException {
    DateToOffsetDateTimeConverter mongoOffsetDateTimeReader = new DateToOffsetDateTimeConverter();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    Date databaseDate = simpleDateFormat.parse("2021-01-10T13:37:17.000+00:00");
    OffsetDateTime offsetDateTime = mongoOffsetDateTimeReader.convert(databaseDate);
    assertThat(offsetDateTime).hasToString("2021-01-10T13:37:17Z");
  }

  @Test
  void testConvertFromOffsetDateTimeToDate() throws ParseException {
    OffsetDateTime offsetDateTime = OffsetDateTime.parse("2021-01-10T13:37:17Z");
    OffsetDateTimeToDateConverter mongoOffsetDateTimeWriter = new OffsetDateTimeToDateConverter();
    Date databaseDate = mongoOffsetDateTimeWriter.convert(offsetDateTime);
    assertThat(databaseDate).hasToString("Sun Jan 10 15:37:17 EET 2021");
  }
}
