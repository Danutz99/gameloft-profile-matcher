package gameloft.interview.profilematcher.player;

import static org.assertj.core.api.Assertions.assertThat;

import gameloft.interview.profilematcher.database.MongoConfig;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.springframework.data.mongodb.core.MongoTemplate;

@Tag("integration")
public class PlayerProfileServiceTest {

  private static final PlayerProfileService playerProfileService = setupPlayerProfileService();

  public static PlayerProfileService setupPlayerProfileService() {
    MongoTemplate mongoTemplate = MongoConfig.createMongoTemplateFromDefaults();
    PlayerProfileRepository playerProfileRepository = new PlayerProfileRepositoryImpl(mongoTemplate);
    return new PlayerProfileServiceImpl(playerProfileRepository);
  }

  @Test
  void testFindPlayerProfile() {
    PlayerProfile playerProfile = playerProfileService.findById("97983be2-98b7-11e7-90cf-082e5f28d836").orElse(null);
    assertThat(playerProfile).isNotNull();
  }

  @Test
  void testSavePlayerProfile() {
    PlayerProfile playerProfile = PlayerProfileServiceImpl.getPlayerProfile();
    PlayerProfile playerProfileUpdate = playerProfileService.save(playerProfile);
    assertThat(playerProfileUpdate).isNotNull();
  }

}
