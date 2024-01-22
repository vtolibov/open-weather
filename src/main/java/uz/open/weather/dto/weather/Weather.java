package uz.open.weather.dto.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Getter
@Setter
@ToString
@Entity
public class Weather {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long weatherId;
    private String timezone;
    private Double lat;
    private Double lon;
    private Double weatherDegree;
    private String description;
    private Long timestamp;
}
