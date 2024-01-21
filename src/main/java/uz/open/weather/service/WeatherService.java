package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WeatherService {

    <T> Flux<T> getCurrentWeatherInfoByLocation();

    <T> Flux<T> getCitiesList();

    <T> Flux<T> getSubscriptions();

    <T, ID> Mono<T> subscribeToCity(ID locationId);
}
