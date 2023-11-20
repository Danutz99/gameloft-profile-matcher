package gameloft.interview.profilematcher.campaign;

import com.fasterxml.jackson.annotation.JsonProperty;
import gameloft.interview.profilematcher.player.Level;
import org.springframework.data.mongodb.core.mapping.Field;

public record Matchers(Level level, Matcher has,
    @JsonProperty("does_not_have") @Field(value = "does_not_have") Matcher doesNotHave) {

}
