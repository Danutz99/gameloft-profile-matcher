package gameloft.interview.profilematcher.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gameloft.interview.profilematcher.campaign.CampaignService;
import gameloft.interview.profilematcher.campaign.CampaignServiceImpl;
import gameloft.interview.profilematcher.player.Campaign;
import gameloft.interview.profilematcher.player.PlayerProfile;
import gameloft.interview.profilematcher.player.PlayerProfileService;
import gameloft.interview.profilematcher.player.PlayerProfileServiceImpl;
import gameloft.interview.profilematcher.player.PlayerProfileServiceTest;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

public class ProfileMatcherServiceTest {

  @Test
  void testMatchPlayerProfileWithActiveCampaigns() {
    PlayerProfile playerProfile = PlayerProfileServiceImpl.getPlayerProfile();
    CampaignService campaignService = new CampaignServiceImpl();
    List<Campaign> activeCampaigns = campaignService.getActiveCampaigns();
    ProfileMatcherService profileMatcherService = new ProfileMatcherServiceImpl(null, null);
    PlayerProfile updatedPlayerProfile = profileMatcherService.matchPlayerProfileWithActiveCampaigns(playerProfile,
      activeCampaigns);
    assertThat(updatedPlayerProfile.activeCampaigns()).hasSize(1);
    assertThat(updatedPlayerProfile.activeCampaigns().get(0)).isEqualTo("mycampaign");
  }

  @Tag("integration")
  @Test
  void testGetPlayerProfile() {
    ProfileMatcherService profileMatcherService = setupProfileMatcherService();
    PlayerProfile playerProfile = profileMatcherService.getPlayerProfile("97983be2-98b7-11e7-90cf-082e5f28d836");
    assertThat(playerProfile.activeCampaigns()).hasSize(1);
    assertThat(playerProfile.activeCampaigns().get(0)).isEqualTo("mycampaign");
  }

  private static ProfileMatcherService setupProfileMatcherService() {
    PlayerProfileService playerProfileService = PlayerProfileServiceTest.setupPlayerProfileService();
    CampaignService campaignService = new CampaignServiceImpl();
    return new ProfileMatcherServiceImpl(playerProfileService, campaignService);
  }
}
