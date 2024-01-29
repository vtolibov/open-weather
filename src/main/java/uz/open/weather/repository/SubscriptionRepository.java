package uz.open.weather.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import reactor.core.publisher.Flux;
import uz.open.weather.model.subscription.Subscription;

public interface SubscriptionRepository extends R2dbcRepository<Subscription, Long> {
    Flux<Subscription> findAllSubscriptionByUserId(Long userId);
}
