package uz.open.weather.service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface LocationService {

    <T> Flux<T> getAllLocations();

    <T, S> Mono<T> createLocation(S locationDto);

    <ID> void deleteLocation(ID id);

    <T> Mono<T> updateLocation(T locationDto);

    <T, ID>Mono<T> getLocation(ID locationId);
}
