package gameloft.interview.profilematcher.player;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceImpl implements PlayerService {

  @Autowired
  public PlayerJpaRepository playerRepository;
  
  @Override
  public Optional<Player> findPlayerById(String playerId) {
    return playerRepository.findById(playerId);
  }

}
