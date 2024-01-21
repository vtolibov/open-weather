package uz.open.weather.dto.location;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Location {
    private Long locationId;
    private String locationName;
    private String lat;
    private String lon;
}
