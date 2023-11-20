package gameloft.interview.profilematcher.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.jupiter.api.Test;

public class MongoOffsetDateTimeConverterTest {

  @Test
  void testConvertFromDateToOffsetDateTime() throws ParseException {
    DateToOffsetDateTimeConverter mongoOffsetDateTimeReader = new DateToOffsetDateTimeConverter();
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSX");
    Date databaseDate = simpleDateFormat.parse("2021-01-10T13:37:17.000+00:00");
    mongoOffsetDateTimeReader.convert(databaseDate);
  }
}
