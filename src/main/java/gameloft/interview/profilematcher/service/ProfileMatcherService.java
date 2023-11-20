package gameloft.interview.profilematcher.service;

import java.util.List;

import gameloft.interview.profilematcher.player.Campaign;
import gameloft.interview.profilematcher.player.PlayerProfile;

public interface ProfileMatcherService {

  public PlayerProfile matchPlayerProfileWithActiveCampaigns(PlayerProfile playerProfile,
      List<Campaign> activeCampaigns);

  public PlayerProfile getPlayerProfile(String playerId);

}
