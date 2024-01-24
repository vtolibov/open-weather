package uz.open.weather.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.util.UriComponentsBuilder;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.model.subscription.Subscription;
import uz.open.weather.repository.SubscriptionRepository;
import uz.open.weather.service.SubscriptionService;

import java.net.URI;

@Service
@RequiredArgsConstructor
public class SubscriptionServiceImpl implements SubscriptionService<Subscription, Long> {


    @Value("${open.weather.url}")
    private String openWeatherUrl;
    @Value("${open.weather.version}")
    private String openWeatherVersion;
    @Value("${open.weather.ext}")
    private String openWeatherExt;
    @Value("${open.weather.api-key}")
    private String openWeatherAppId;

    private final SubscriptionRepository subscriptionRepository;
    private final WebClient webClient;

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
        return subscriptionRepository.save(body);
    }

    @Override
    public Mono<String> getSubscriptionInfoFromLocation(Long subscriptionId) {
        return subscriptionRepository.findById(subscriptionId)
                .flatMap(subscription -> {
                    URI openWeatherUri = UriComponentsBuilder.fromHttpUrl(openWeatherUrl)
                            .path(openWeatherVersion + openWeatherExt)
                            .queryParam("lat", subscription.getLat())
                            .queryParam("lon", subscription.getLon())
                            .queryParam("appid", openWeatherAppId)
                            .build().toUri();
                    return webClient.get()
                            .uri(openWeatherUri)
                            .retrieve()
                            .bodyToMono(String.class)
                            .flatMap(Mono::just);
                });
    }
}
