package gameloft.interview.profilematcher.player;

import org.springframework.data.mongodb.core.mapping.Field;

public record Inventory(int cash, int coins,
    @Field(value = "item_1") int item1,
    @Field(value = "item_34") int item34,
    @Field(value = "item_55") int item55) {

}
