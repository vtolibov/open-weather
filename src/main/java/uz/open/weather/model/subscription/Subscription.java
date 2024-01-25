package uz.open.weather.model.subscription;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.ToStringBuilder;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;

@Getter
@Setter
@Entity
@Table(name = "subscription")
public class Subscription {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "user_id")
    private Long userId;
    @Column(name = "location_id")
    private Long locationId;
    @Column(name = "latitude")
    private Double lat;
    @Column(name = "longitude")
    private Double lon;
    @Column(name = "location_name", length = 25)
    private String locationName;
    @Column(name = "status", length = 10)
    private SubscriptionStatuses status;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("locationId", locationId)
                .append("lat", lat)
                .append("lon", lon)
                .append("locationName", locationName)
                .append("status", status)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return Objects.equals(id, that.id) && Objects.equals(userId, that.userId) && Objects.equals(locationId, that.locationId) && Objects.equals(lat, that.lat) && Objects.equals(lon, that.lon) && Objects.equals(locationName, that.locationName) && status == that.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, userId, locationId, lat, lon, locationName, status);
    }
}
