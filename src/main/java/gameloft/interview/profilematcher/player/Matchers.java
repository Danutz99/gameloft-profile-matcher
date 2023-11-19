package gameloft.interview.profilematcher.player;

import org.springframework.data.mongodb.core.mapping.Field;

public record Matchers(Level level, Matcher has, 
    @Field(value = "does_not_have")
    Matcher doesNotHave) {

}
