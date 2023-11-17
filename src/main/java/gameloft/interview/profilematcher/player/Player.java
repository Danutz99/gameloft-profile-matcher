package gameloft.interview.profilematcher.player;

import java.math.BigDecimal;
import java.time.OffsetDateTime;
import java.util.List;

public record Player(String playerId, String credential, OffsetDateTime created, OffsetDateTime modified,
    OffsetDateTime lastSession, BigDecimal totalSpent, BigDecimal totalRefund, int totalTransactions,
    OffsetDateTime lastPurchase, List<Campaign> activeCampaigns, List<Device> devices, int level, int xp,
    int total_playtime, String country, String language, OffsetDateTime birthdate, String gender, Inventory inventory,
    Clan clan, String customField) {
}
