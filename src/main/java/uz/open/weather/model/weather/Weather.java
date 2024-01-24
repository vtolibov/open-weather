package uz.open.weather.model.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Getter
@Setter
@Table(name = "weather")
@Accessors(chain = true)
public class Weather {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "timezone", length = 20)
    private String timezone;
    @Column(name = "latitude", length = 20)
    private Double lat;
    @Column(name = "longitude", length = 20)
    private Double lon;
    @Column(name = "weather_degree", length = 20)
    private Double weatherDegree;
    @Column(name = "description", length = 30)
    private String description;
    @Column(name = "date_time", length = 30)
    private Long timestamp;

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Weather{");
        sb.append("id=").append(id);
        sb.append(", timezone='").append(timezone).append('\'');
        sb.append(", lat=").append(lat);
        sb.append(", lon=").append(lon);
        sb.append(", weatherDegree=").append(weatherDegree);
        sb.append(", description='").append(description).append('\'');
        sb.append(", timestamp=").append(timestamp);
        sb.append('}');
        return sb.toString();
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        uz.open.weather.model.weather.Weather weather = (uz.open.weather.model.weather.Weather) o;
        return java.util.Objects.equals(id, weather.id) && java.util.Objects.equals(timezone, weather.timezone) && java.util.Objects.equals(lat, weather.lat) && java.util.Objects.equals(lon, weather.lon) && java.util.Objects.equals(weatherDegree, weather.weatherDegree) && java.util.Objects.equals(description, weather.description) && java.util.Objects.equals(timestamp, weather.timestamp);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, timezone, lat, lon, weatherDegree, description, timestamp);
    }

}
