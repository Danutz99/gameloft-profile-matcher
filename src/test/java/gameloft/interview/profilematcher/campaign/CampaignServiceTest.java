package gameloft.interview.profilematcher.campaign;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import gameloft.interview.profilematcher.player.Campaign;
import org.junit.jupiter.api.Test;

public class CampaignServiceTest {

  @Test
  void testGetActiveCampaign() {
    CampaignService campaignService = new CampaignServiceImpl();
    List<Campaign> activeCampaigns = campaignService.getActiveCampaigns();
    assertThat(activeCampaigns).hasSize(1);
    assertThat(activeCampaigns.get(0).name()).isEqualTo("mycampaign");
  }

}
