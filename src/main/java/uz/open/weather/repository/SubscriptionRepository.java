package uz.open.weather.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Flux;
import uz.open.weather.model.subscription.Subscription;

public interface SubscriptionRepository extends ReactiveCrudRepository<Subscription, Long> {
    Flux<Subscription> findAllSubscriptionByUserId(Long userId);
}
