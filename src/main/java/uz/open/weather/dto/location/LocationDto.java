package uz.open.weather.dto.location;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;

@Getter
@Setter
@Accessors(chain = true)
public class LocationDto {
    @JsonProperty(value = "location_id")
    private Long locationId;
    @JsonProperty(value = "location_name")
    private String locationName;
    @JsonProperty(value = "latitude")
    private Double latitude;
    @JsonProperty(value = "longitude")
    private Double longitude;
    @JsonProperty(value = "is_available")
    private Boolean isAvailable;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("locationId", locationId)
                .append("locationName", locationName)
                .append("latitude", latitude)
                .append("longitude", longitude)
                .append("isAvailable", isAvailable)
                .toString();
    }
}
