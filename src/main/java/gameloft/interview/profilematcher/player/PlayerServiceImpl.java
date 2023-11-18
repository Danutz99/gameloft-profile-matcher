package gameloft.interview.profilematcher.player;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  public PlayerJpaRepository playerRepository;
  
  @Override
  public Player findPlayerById(String playerId) {
    return null;
  }

}
