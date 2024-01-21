package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface WeatherService {

    <T, S> Flux<T> getCurrentWeatherInfoByLocation(S body);

    <T> Flux<T> getCitiesList();

    <T, ID> Mono<T> subscribeToCity(ID locationId);
}
