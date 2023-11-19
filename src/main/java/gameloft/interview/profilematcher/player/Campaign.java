package gameloft.interview.profilematcher.player;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

public record Campaign(String game, String name, BigDecimal priority, Matchers matchers, OffsetDateTime startDate,
    OffsetDateTime endDate, boolean enabled, OffsetDateTime lastUpdated) {
}
