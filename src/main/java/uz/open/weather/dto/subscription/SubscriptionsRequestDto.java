package uz.open.weather.dto.subscription;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;


@Getter
@Setter
public class SubscriptionsRequestDto {
    @JsonProperty(value = "user_id")
    private Long userId;
    @JsonProperty(value = "subscribe")
    private int subscribe;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("subscribe", subscribe)
                .toString();
    }
}
