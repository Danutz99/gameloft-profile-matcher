package gameloft.interview.profilematcher.player;

import java.util.Optional;

public interface PlayerProfileService {

  public Optional<PlayerProfile> findById(String playerId);

  public PlayerProfile save(PlayerProfile playerProfile);

}
