package gameloft.interview.profilematcher.player;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.data.mongodb.core.mapping.Field;

public record Inventory(int cash, int coins,
    @Field(value = "item_1") @JsonAlias("item_1") int item1,
    @Field(value = "item_34") @JsonAlias("item_34") int item34,
    @Field(value = "item_55") @JsonAlias("item_55") int item55) {

}
