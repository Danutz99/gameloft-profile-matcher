package gameloft.interview.profilematcher.service;

import java.util.List;
import java.util.Optional;

import gameloft.interview.profilematcher.campaign.CampaignService;
import gameloft.interview.profilematcher.player.Campaign;
import gameloft.interview.profilematcher.player.Inventory;
import gameloft.interview.profilematcher.player.Matcher;
import gameloft.interview.profilematcher.player.PlayerProfile;
import gameloft.interview.profilematcher.player.PlayerProfileService;
import org.springframework.stereotype.Component;

@Component
public class ProfileMatcherServiceImpl implements ProfileMatcherService {

  private PlayerProfileService playerProfileService;

  private CampaignService campaignService;

  public ProfileMatcherServiceImpl(PlayerProfileService playerProfileService, CampaignService campaignService) {
    this.playerProfileService = playerProfileService;
    this.campaignService = campaignService;
  }

  @Override
  public PlayerProfile getPlayerProfile(String playerId) {
    Optional<PlayerProfile> playerProfileOptional = playerProfileService.findById(playerId);
    if (playerProfileOptional.isEmpty()) {
      return null;
    }
    PlayerProfile playerProfile = playerProfileOptional.get();
    List<Campaign> activeCampaigns = campaignService.getActiveCampaigns();
    playerProfile = matchPlayerProfileWithActiveCampaigns(playerProfile, activeCampaigns);
    return playerProfile;
  }

  @Override
  public PlayerProfile matchPlayerProfileWithActiveCampaigns(PlayerProfile playerProfile,
      List<Campaign> activeCampaigns) {
    activeCampaigns.forEach(c -> {
      if (playerMatchesCampaignConditions(playerProfile, c)) {
        playerProfile.activeCampaigns().add(c);
      }
    });
    return playerProfile;
  }

  private boolean playerMatchesCampaignConditions(PlayerProfile playerProfile, Campaign campaign) {
    if (isLevelInRange(playerProfile.level(), campaign.matchers().level().min(), campaign.matchers().level().max())) {
      return true;
    }
    Matcher hasMatcher = campaign.matchers().has();
    if (matchesCountry(playerProfile.country(), hasMatcher.country())
        && matchesItems(playerProfile.inventory(), hasMatcher.items())) {
      return true;
    }
    Matcher doesNotHaveMatcher = campaign.matchers().doesNotHave();
    return !(matchesCountry(playerProfile.country(), doesNotHaveMatcher.country())
        && matchesItems(playerProfile.inventory(), doesNotHaveMatcher.items()));
  }

  private boolean isLevelInRange(int level, int min, int max) {
    return level >= min && level <= max;
  }

  private boolean matchesCountry(String playerCountry, List<String> countryList) {
    return countryList == null || countryList.isEmpty() || countryList.contains(playerCountry);
  }

  private boolean matchesItems(Inventory inventory, List<String> itemList) {
    return itemList == null || itemList.isEmpty() || itemList.stream().allMatch(inventory::hasItem);
  }
}
