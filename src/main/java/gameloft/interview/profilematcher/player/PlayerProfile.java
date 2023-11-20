package gameloft.interview.profilematcher.player;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public record PlayerProfile(
    @Id
    // MongoDB will always serialize the @Id field as "_id"
    // @Field(value = "player_id")
    // Keeping java standard camel case naming convention
    @JsonProperty("player_id") String playerId, String credential,
    OffsetDateTime created,
    OffsetDateTime modified,
    @JsonProperty("last_session") @Field(value = "last_session") OffsetDateTime lastSession,
    @JsonProperty("total_spent") @Field(value = "total_spent") BigDecimal totalSpent,
    @JsonProperty("total_refund") @Field(value = "total_refund") BigDecimal totalRefund,
    @JsonProperty("total_transactions") @Field(value = "total_transactions") int totalTransactions,
    @JsonProperty("last_purchase") @Field(value = "last_purchase") OffsetDateTime lastPurchase,
    @JsonProperty("active_campaigns") @Field(value = "active_campaigns") List<String> activeCampaigns,
    List<Device> devices, int level, int xp,
    @JsonProperty("total_playtime") @Field(value = "total_playtime") int totalPlaytime, String country, String language,
    OffsetDateTime birthdate,
    String gender, Inventory inventory,
    Clan clan,
    @JsonAlias("_customfield") @JsonProperty("_customfield") @Field(value = "_customfield") String customField) {
}
