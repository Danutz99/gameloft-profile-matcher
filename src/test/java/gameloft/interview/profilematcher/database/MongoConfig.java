package gameloft.interview.profilematcher.database;

import java.util.Arrays;

import com.mongodb.client.MongoClient;
import gameloft.interview.profilematcher.util.DateToOffsetDateTimeConverter;
import gameloft.interview.profilematcher.util.OffsetDateTimeToDateConverter;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.convert.MongoCustomConversions;

public class MongoConfig {

  private static final String DATABASE_NAME = "profile-matcher";
  private static final String CONNECTION_STRING = "mongodb://localhost:27017/profile-matcher";

  public static MongoTemplate createMongoTemplateFromDefaults() {
    MongoClient mongoClient = SimpleMongoConfig.createMongoClient(CONNECTION_STRING);
    MongoCustomConversions mongoCustomConversions = new MongoCustomConversions(
      Arrays.asList(new OffsetDateTimeToDateConverter(), new DateToOffsetDateTimeConverter()));
    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, DATABASE_NAME);
    MappingMongoConverter mongoConverter = (MappingMongoConverter) mongoTemplate.getConverter();
    mongoConverter.setCustomConversions(mongoCustomConversions);
    mongoConverter.afterPropertiesSet();
    return mongoTemplate;
  }

}
