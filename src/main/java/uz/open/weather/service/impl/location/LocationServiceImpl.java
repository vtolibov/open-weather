package uz.open.weather.service.impl.location;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.service.LocationService;

public class LocationServiceImpl implements LocationService {
    @Override
    public <T> Flux<T> getAllLocations() {
        return null;
    }

    @Override
    public <T, S> Mono<T> saveLocation(S location) {
        return null;
    }

    @Override
    public <ID> void deleteLocation(ID id) {

    }

    @Override
    public <T, S> Mono<T> changeLocation(S location) {
        return null;
    }
}
