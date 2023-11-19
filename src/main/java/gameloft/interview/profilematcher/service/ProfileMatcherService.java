package gameloft.interview.profilematcher.service;

import gameloft.interview.profilematcher.player.PlayerProfile;

public interface ProfileMatcherService {

  public PlayerProfile getPlayerProfile(String playerId);

}
