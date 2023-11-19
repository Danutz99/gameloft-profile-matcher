package gameloft.interview.profilematcher.player;

import static org.assertj.core.api.Assertions.assertThat;

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
  void testSavePlayerProfile() {
    PlayerProfile playerProfile = PlayerProfileTestUtils.getPlayerProfile();
    PlayerProfile playerProfileUpdate = playerProfileService.save(playerProfile);
    assertThat(playerProfileUpdate).isNotNull();
  }

}
