package uz.open.weather.model.subscription;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Getter
@Setter
@Table(name = "subscription")
public class Subscription {

    @Id
    @Column("id")
    private Long id;
    @Column("user_id")
    private Long userId;
    @Column("location_id")
    private Long locationId;
    @Column("latitude")
    private Double lat;
    @Column("longitude")
    private Double lon;
    @Column("location_name")
    private String locationName;
    @Column("is_subscribed")
    private SubscriptionStatuses isSubscribed;

    @Override
    public String toString() {
        return new ToStringBuilder(this)
                .append("id", id)
                .append("userId", userId)
                .append("locationId", locationId)
                .append("lat", lat)
                .append("lon", lon)
                .append("locationName", locationName)
                .append("status", isSubscribed)
                .toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Subscription that = (Subscription) o;
        return new EqualsBuilder().append(id, that.id).append(userId, that.userId).append(locationId, that.locationId).append(lat, that.lat).append(lon, that.lon).append(locationName, that.locationName).append(isSubscribed, that.isSubscribed).isEquals();
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder(17, 37).append(id).append(userId).append(locationId).append(lat).append(lon).append(locationName).append(isSubscribed).toHashCode();
    }
}
