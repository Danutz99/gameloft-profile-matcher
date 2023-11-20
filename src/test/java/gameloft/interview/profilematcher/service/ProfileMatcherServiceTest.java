package gameloft.interview.profilematcher.service;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gameloft.interview.profilematcher.campaign.CampaignService;
import gameloft.interview.profilematcher.campaign.CampaignServiceImpl;
import gameloft.interview.profilematcher.player.Campaign;
import gameloft.interview.profilematcher.player.PlayerProfile;
import gameloft.interview.profilematcher.player.PlayerProfileTestUtils;
import org.junit.jupiter.api.Test;

public class ProfileMatcherServiceTest {

  @Test
  void testMatchPlayerProfileWithActiveCampaigns() {
    PlayerProfile playerProfile = PlayerProfileTestUtils.getPlayerProfile();
    CampaignService campaignService = new CampaignServiceImpl();
    List<Campaign> activeCampaigns = campaignService.getActiveCampaigns();
    ProfileMatcherService profileMatcherService = new ProfileMatcherServiceImpl();
    PlayerProfile updatedPlayerProfile =  profileMatcherService.matchPlayerProfileWithActiveCampaigns(playerProfile, activeCampaigns);
    assertThat(updatedPlayerProfile.activeCampaigns()).hasSize(1);
    assertThat(updatedPlayerProfile.activeCampaigns().get(0).name()).isEqualTo("mycampaign");
  }
}
