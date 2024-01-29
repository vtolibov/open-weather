package uz.open.weather.model.location;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Getter
@Setter
@Entity
@Table(name = "location")
public class Location {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "location_name", length = 25)
    private String locationName;
    @Column(name = "latitude")
    private Double lat;
    @Column(name = "longitude")
    private Double lon;
    @Column(name = "is_available")
    private Boolean isAvailable;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("locationName", locationName)
                .append("lat", lat)
                .append("lon", lon)
                .append("isAvailable", isAvailable)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return new EqualsBuilder().append(id, location.id).append(locationName, location.locationName).append(lat, location.lat).append(lon, location.lon).append(isAvailable, location.isAvailable).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(locationName).append(lat).append(lon).append(isAvailable).toHashCode();
    }
}
