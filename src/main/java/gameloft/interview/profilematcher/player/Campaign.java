package gameloft.interview.profilematcher.player;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import org.springframework.data.mongodb.core.mapping.Field;

public record Campaign(String game, String name, BigDecimal priority, Matchers matchers,
    @Field(value = "start_date")
    OffsetDateTime startDate,
    @Field(value = "end_date")
    OffsetDateTime endDate, boolean enabled,
    @Field(value = "last_updated")
    OffsetDateTime lastUpdated) {
}
