package uz.open.weather.service.impl.location;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.dto.location.LocationDto;
import uz.open.weather.mapper.location.LocationMapper;
import uz.open.weather.model.location.Location;
import uz.open.weather.repository.LocationRepository;
import uz.open.weather.service.LocationService;


@Service
@RequiredArgsConstructor
public class LocationServiceImpl implements LocationService {

    private final LocationRepository locationRepository;

    private final LocationMapper locationMapper;

    @Override
    public <T> Flux<T> getAllLocations() {
        return locationRepository.findAll()
                .map(locationMapper::locationEntityToLocationDto)
                .flatMap(locationDto -> Flux.just((T) locationDto));
    }

    @Override
    public <T, S> Mono<T> createLocation(S locationDto) {
        Location location = locationMapper.locationDtoToLocationEntity((LocationDto) locationDto);
        return locationRepository.save(location)
                .map(locationMapper::locationEntityToLocationDto)
                .map(dto -> (T) dto);
    }

    @Override
    public <ID> void deleteLocation(ID id) {
        locationRepository.deleteById((Long) id);
    }

    @Override
    public <T> Mono<T> updateLocation(T locationDto) {
        Location location = locationMapper.locationDtoToLocationEntity((LocationDto) locationDto);
        return locationRepository.save(location)
                .map(locationMapper::locationEntityToLocationDto)
                .map(dto -> (T) dto);
    }

    @Override
    public <T, ID> Mono<T> getLocation(ID locationId) {
        Mono<Location> location = locationRepository.findById((Long) locationId);
        return location.map(locationMapper::locationEntityToLocationDto)
                .map(locationDto -> (T) locationDto);
    }
}
