package gameloft.interview.profilematcher.player;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PlayerServiceImpl implements PlayerProfileService {

  PlayerProfileRepository playerProfileRepository;

  public PlayerServiceImpl(@Autowired PlayerProfileRepository playerProfileRepository) {
    this.playerProfileRepository = playerProfileRepository;
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
