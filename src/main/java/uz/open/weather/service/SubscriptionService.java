package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubscriptionService<T, ID> {

    Flux<T> getSubscriptionList(ID userId);

    void deleteSubscription(Long subscriptionId);

    Mono<T> subscribe(T body);
}
