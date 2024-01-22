package uz.open.weather.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.config.app.RequestProcessor;
import uz.open.weather.dto.subscription.Subscription;
import uz.open.weather.repository.SubscriptionRepository;
import uz.open.weather.service.SubscriptionService;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService<Subscription, Long> {


    private final RequestProcessor requestProcessor;
    private final SubscriptionRepository subscriptionRepository;

    @Override
    public Flux<Subscription> getSubscriptionList(Long userId) {
        return subscriptionRepository.findAllSubscriptionByUserId(userId);
    }

    @Override
    public void deleteSubscription(Long subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
    }

    @Override
    public Mono<Subscription> subscribe(Subscription body) {
        return null;
    }
}
