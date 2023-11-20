package gameloft.interview.profilematcher.player;

import java.util.Optional;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import gameloft.interview.profilematcher.util.JacksonJsonMapper;
import org.springframework.stereotype.Component;

@Component
public class PlayerProfileServiceImpl implements PlayerProfileService {

  private static String playerProfileJson = """
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

  private static PlayerProfile deserializePlayerProfile(String playerProfileJson) {
    PlayerProfile playerProfile;
    try {
      playerProfile = JacksonJsonMapper.jsonMapper.readValue(playerProfileJson, PlayerProfile.class);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
    return playerProfile;
  }

  public static PlayerProfile getPlayerProfile() {
    return deserializePlayerProfile(playerProfileJson);
  }

  PlayerProfileRepository playerProfileRepository;

  public PlayerProfileServiceImpl(PlayerProfileRepository playerProfileRepository) {
    this.playerProfileRepository = playerProfileRepository;
    savePlayerProfileIfNeeded();
  }

  private void savePlayerProfileIfNeeded() {
    PlayerProfile defaultPlayerProfile = getPlayerProfile();
    Optional<PlayerProfile> existingPlayerProfile = playerProfileRepository.findById(defaultPlayerProfile.playerId());
    if (existingPlayerProfile.isEmpty()) {
      playerProfileRepository.save(defaultPlayerProfile);
    }
  }

  @Override
  public Optional<PlayerProfile> findById(String playerId) {
    return playerProfileRepository.findById(playerId);
  }

  @Override
  public PlayerProfile save(PlayerProfile playerProfile) {
    return playerProfileRepository.save(playerProfile);
  }

}
