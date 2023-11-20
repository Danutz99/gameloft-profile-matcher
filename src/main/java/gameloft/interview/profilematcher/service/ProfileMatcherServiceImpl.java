package gameloft.interview.profilematcher.service;

import java.util.List;
import java.util.Optional;

import gameloft.interview.profilematcher.campaign.CampaignService;
import gameloft.interview.profilematcher.player.Campaign;
import gameloft.interview.profilematcher.player.Matcher;
import gameloft.interview.profilematcher.player.PlayerProfile;
import gameloft.interview.profilematcher.player.PlayerProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProfileMatcherServiceImpl implements ProfileMatcherService {

  @Autowired
  private PlayerProfileService playerProfileService;

  @Autowired
  private CampaignService campaignService;

  @Override
  public PlayerProfile getPlayerProfile(String playerId) {
    Optional<PlayerProfile> playerProfileOptional = playerProfileService.findById(playerId);
    if (playerProfileOptional.isEmpty()) {
      return null;
    }
    PlayerProfile playerProfile = playerProfileOptional.get();
    List<Campaign> activeCampaigns = campaignService.getActiveCampaigns();
    activeCampaigns.forEach(c -> {
      if (playerMatchesCampaignConditions(playerProfile, c)) {
        playerProfile.activeCampaigns().add(c);
      }
    });
    return playerProfile;
  }

  private boolean playerMatchesCampaignConditions(PlayerProfile playerProfile, Campaign campaign) {
    if (playerProfile.level() >= campaign.matchers().level().min()
        && playerProfile.level() <= campaign.matchers().level().max()) {
      return true;
    }
    Matcher hasMatcher = campaign.matchers().has();
    if (hasMatcher.country().indexOf(playerProfile.country()) != -1
    //        && hasMatcher.items().indexOf(playerProfile.inventory())
        ) {
      return true;
    }
    
    return false;
  }

}
