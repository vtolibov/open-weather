package uz.open.weather.model.weather;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "weather")
@Accessors(chain = true)
public class Weather {
    @Id
    @Column("id")
    private Long id;
    @Column("timezone")
    private String timezone;
    @Column("latitude")
    private Double lat;
    @Column("longitude")
    private Double lon;
    @Column("weather_degree")
    private Double weatherDegree;
    @Column("description")
    private String description;
    @Column("date_time")
    private Long timestamp;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("timezone", timezone)
                .append("lat", lat)
                .append("lon", lon)
                .append("weatherDegree", weatherDegree)
                .append("description", description)
                .append("timestamp", timestamp)
                .toString();
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
