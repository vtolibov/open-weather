package uz.open.weather.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Weather {
    private Long weatherId;
    private String timezone;
    private String lat;
    private String lon;
    private String weatherDegree;
    private String description;
    private String timestamp;
}
