package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface SubscriptionService {
    <T> Flux<T> getSubscriptionList();

    <ID> void deleteSubscription(ID subscriptionId);

    <T> Mono<T> subscribe(T body);
}
