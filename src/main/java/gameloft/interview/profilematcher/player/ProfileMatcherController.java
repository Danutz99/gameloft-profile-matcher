package gameloft.interview.profilematcher.player;

import gameloft.interview.profilematcher.service.ProfileMatcherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping({
    "api/profilematcher" })
public class ProfileMatcherController {
  
  @Autowired
  private ProfileMatcherService profileMatcherService;

  @GetMapping(path = "/get_client_config/{player_id}")
  public ResponseEntity<PlayerProfile> getPlayerProfile(@PathVariable String player_id) {
    return ResponseEntity.ofNullable(profileMatcherService.getPlayerProfile(player_id));
  }

}
