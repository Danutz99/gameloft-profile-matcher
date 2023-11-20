package gameloft.interview.profilematcher.player;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.data.mongodb.core.mapping.Field;

public record Inventory(int cash, int coins,
    @Field(value = "item_1") @JsonAlias("item_1") int item1,
    @Field(value = "item_34") @JsonAlias("item_34") int item34,
    @Field(value = "item_55") @JsonAlias("item_55") int item55) {

  public boolean hasItem(String itemName) {
    try {
      java.lang.reflect.Field itemField = Inventory.class.getDeclaredField(itemName);
      int value = (int) itemField.get(this);
      return value > 0;
    } catch (NoSuchFieldException | IllegalAccessException e) {
      return false;
    }
  }

}
