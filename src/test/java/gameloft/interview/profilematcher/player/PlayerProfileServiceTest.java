package gameloft.interview.profilematcher.player;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.mongodb.client.MongoClient;
import gameloft.interview.profilematcher.app.SimpleMongoConfig;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

public class PlayerProfileServiceTest {

  PlayerProfileService playerProfileService = setupPlayerProfileService();

  private PlayerProfileService setupPlayerProfileService() {
    MongoClient mongoClient = SimpleMongoConfig.createMongoClient("mongodb://localhost:27017/profile-matcher");
    MongoTemplate mongoTemplate = new MongoTemplate(mongoClient, "profile-matcher");
    PlayerProfileRepository playerProfileRepository = new PlayerProfileRepositoryImpl(mongoTemplate);

    return new PlayerServiceImpl(playerProfileRepository);
  }

  @Test
  void testFindPlayerProfile() {
    PlayerProfile playerProfile = playerProfileService.findById("97983be2-98b7-11e7-90cf-082e5f28d836").orElse(null);
    assertThat(playerProfile).isNotNull();
  }

  @Test
  void testSavePlayerProfile() throws JsonMappingException, JsonProcessingException {

    String playerProfileJson = """
                {
            "player_id": "97983be2-98b7-11e7-90cf-082e5f28d836",
            "credential": "apple_credential",
            "created": "2021-01-10T13:37:17Z",
            "modified": "2021-01-23T13:37:17Z",
            "last_session": "2021-01-23T13:37:17Z",
            "total_spent": 400,
            "total_refund": 0,
            "total_transactions": 5,
            "last_purchase": "2021-01-22T13:37:17Z",
            "active_campaigns": [],
            "devices": [{
                    "id": 1,
                    "model": "apple iphone 11",
                    "carrier": "vodafone",
                    "firmware": "123"
                }
            ],
            "level": 3,
            "xp": 1000,
            "total_playtime": 144,
            "country": "CA",
            "language": "fr",
            "birthdate": "2000-01-10T13:37:17Z",
            "gender": "male",
            "inventory": {
                "cash": 123,
                "coins": 123,
                "item_1": 1,
                "item_34": 3,
                "item_55": 2
            },
            "clan": {
                "id": "123456",
                "name": "Hello world clan"
            },
            "_customfield": "mycustom"
        }

                """;

    ObjectMapper mapper = new ObjectMapper();
    mapper.registerModule(new JavaTimeModule());
    mapper.setPropertyNamingStrategy(PropertyNamingStrategies.SNAKE_CASE);
    PlayerProfile playerProfile = mapper.readValue(playerProfileJson, PlayerProfile.class);
    PlayerProfile playerProfileUpdate = playerProfileService.save(playerProfile);
  }

}
