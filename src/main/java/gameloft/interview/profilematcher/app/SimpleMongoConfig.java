package gameloft.interview.profilematcher.app;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import gameloft.interview.profilematcher.util.OffsetDateTimeCodec;
import org.bson.codecs.DocumentCodec;
import org.bson.codecs.configuration.CodecRegistries;
import org.bson.codecs.configuration.CodecRegistry;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;

@Configuration
public class SimpleMongoConfig {

  @Value("${spring.data.mongodb.uri}")
  String connectionString;
  @Value("${mongodb.database.name}")
  String databaseName;

  @Bean
  public MongoClient mongo() {
    return createMongoClient(connectionString);
  }

  public static MongoClient createMongoClient(String connectionString) {
    ConnectionString connectionString1 = new ConnectionString(connectionString);
    CodecRegistry defaultCodecRegistry = MongoClientSettings.getDefaultCodecRegistry();
    CodecRegistry customCodecRegistry = CodecRegistries.fromCodecs(new OffsetDateTimeCodec(), new DocumentCodec());
    CodecRegistry combinedRegistry = CodecRegistries.fromRegistries(defaultCodecRegistry, customCodecRegistry);
    MongoClientSettings mongoClientSettings = MongoClientSettings.builder()
      .applyConnectionString(connectionString1)
      .codecRegistry(
        combinedRegistry)
      .build();
    return MongoClients.create(mongoClientSettings);
  }

  @Bean
  public MongoTemplate mongoTemplate() throws Exception {
    return new MongoTemplate(mongo(), databaseName);
  }
}