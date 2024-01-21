package uz.open.weather.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.open.weather.dto.subscription.Subscription;

public interface SubscriptionRepository extends ReactiveCrudRepository<Subscription, Long> {
}
