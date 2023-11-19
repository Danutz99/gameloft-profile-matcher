package gameloft.interview.profilematcher.player;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import gameloft.interview.profilematcher.app.ProfileMatcherApplication;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = ProfileMatcherApplication.class)
@SpringBootTest
public class PlayerProfileRepositoryTest {

  @MockBean
  private PlayerProfileRepository playerProfileRepository;

  @Test
  void testFindById() throws JsonMappingException, JsonProcessingException {
    PlayerProfile playerProfile = PlayerProfileTestUtils.getPlayerProfile();

    Mockito.when(playerProfileRepository.findById(playerProfile.playerId()))
      .thenReturn(Optional.of(playerProfile));

    PlayerProfile playerProfile2 = playerProfileRepository.findById(playerProfile.playerId())
      .orElse(null);
    assertThat(playerProfile2).isNotNull();
  }
}
