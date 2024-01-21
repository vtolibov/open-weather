package uz.open.weather.dto.subscription;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Subscription {
    private Long subscriptionId;
    private Long userId;
    private Long locationId;
    private String name;
    private boolean status;
}
