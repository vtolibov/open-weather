package uz.open.weather.dto.subscription.subscribe;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
public class SubscribeRequestDto {
    private Long userId;
    private Long locationId;
    private Double lat;
    private Double lon;
    private String name;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("userId", userId)
                .append("locationId", locationId)
                .append("lat", lat)
                .append("lon", lon)
                .append("name", name)
                .toString();
    }
}
