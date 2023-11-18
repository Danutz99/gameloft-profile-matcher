package gameloft.interview.profilematcher.player;

import java.util.Optional;

public interface PlayerService {

  public Optional<Player> findPlayerById(String playerId);
  
}
