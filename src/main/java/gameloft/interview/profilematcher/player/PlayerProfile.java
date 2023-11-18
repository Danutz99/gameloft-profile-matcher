package gameloft.interview.profilematcher.player;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonAlias;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document
public record PlayerProfile(
    @Id
//    @Field(value = "player_id")
    String playerId, String credential, OffsetDateTime created, OffsetDateTime modified,
    @Field(value = "last_session") OffsetDateTime lastSession,
    @Field(value = "total_spent") BigDecimal totalSpent,
    @Field(value = "total_refund") BigDecimal totalRefund,
    @Field(value = "total_transactions") int totalTransactions,
    @Field(value = "last_purchase") OffsetDateTime lastPurchase,
    @Field(value = "active_campaigns") List<Campaign> activeCampaigns, List<Device> devices, int level, int xp,
    @Field(value = "total_playtime") int totalPlaytime, String country, String language, OffsetDateTime birthdate,
    String gender, Inventory inventory,
    Clan clan,
    @JsonAlias("_customfield") @Field(value = "_customfield") String customField) {
}
