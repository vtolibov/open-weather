package uz.open.weather.model.location;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Accessors(chain = true)
@Table(name = "location")
public class Location {
    @Id
    @Column("id")
    private Long id;
    @Column("location_name")
    private String locationName;
    @Column("latitude")
    private Double lat;
    @Column("longitude")
    private Double lon;
    @Column("is_available")
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
