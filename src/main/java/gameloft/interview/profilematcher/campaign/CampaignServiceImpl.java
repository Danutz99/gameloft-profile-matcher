package gameloft.interview.profilematcher.campaign;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import gameloft.interview.profilematcher.util.JacksonJsonMapper;
import org.springframework.stereotype.Component;

@Component
public class CampaignServiceImpl implements CampaignService {

  private static final String currentCampaignJson = """
            {
       "game": "mygame",
       "name":"mycampaign",
       "priority": 10.5,
       "matchers": {
       "level": {
       "min": 1,
       "max": 3
       },
       "has": {
       "country": ["US","RO","CA"],
       "items": ["item_1"]
       },
       "does_not_have": {
       "items": ["item_4"]
       }
       },
       "start_date": "2022-01-25 00:00:00Z",
       "end_date": "2022-02-25 00:00:00Z",
       "enabled": true,
       "last_updated": "2021-07-13 11:46:58Z"
      }
            """;

  @Override
  public List<Campaign> getActiveCampaigns() {
    try {
      Campaign currentCampaign = JacksonJsonMapper.jsonMapper.readValue(currentCampaignJson, Campaign.class);
      return List.of(currentCampaign);
    } catch (JsonMappingException e) {
      throw new RuntimeException(e);
    } catch (JsonProcessingException e) {
      throw new RuntimeException(e);
    }
  }

}
