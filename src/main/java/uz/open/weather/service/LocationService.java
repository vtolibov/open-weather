package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationService {

    <T> Flux<T> getAllLocations();

    <T, S> Mono<T> saveLocation(S location);

    <ID> void deleteLocation(ID id);

    <T, S> Mono<T> changeLocation(S location);
}
