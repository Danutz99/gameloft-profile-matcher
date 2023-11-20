package gameloft.interview.profilematcher.player;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.annotation.PropertySources;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)

@SpringBootApplication(scanBasePackages = { "gameloft.interview.profilematcher" })
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@PropertySources({
    @PropertySource("classpath:/application.properties")
})

@Tag("spring")
@Tag("integration")
public class ProfileMatcherControllerTest {

  @Autowired
  private ProfileMatcherController profileMatcherController;

  @Test
  void testGetPlayerProfile() {
    String playerId = "97983be2-98b7-11e7-90cf-082e5f28d836";
    PlayerProfile playerProfile = profileMatcherController.getPlayerProfile(playerId).getBody();
    assertThat(playerProfile.playerId()).isEqualTo(playerId);
    assertThat(playerProfile.activeCampaigns()).hasSize(1);
    assertThat(playerProfile.activeCampaigns().get(0).name()).isEqualTo("mycampaign");
  }

}
