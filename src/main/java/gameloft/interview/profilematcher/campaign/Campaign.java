package gameloft.interview.profilematcher.campaign;

import java.math.BigDecimal;
import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Field;

public record Campaign(String game, String name, BigDecimal priority, Matchers matchers,
    @JsonProperty("start_date") @Field(value = "start_date") OffsetDateTime startDate,
    @JsonProperty("end_date") @Field(value = "end_date") OffsetDateTime endDate, boolean enabled,
    @JsonProperty("last_updated") @Field(value = "last_updated") OffsetDateTime lastUpdated) {
}
