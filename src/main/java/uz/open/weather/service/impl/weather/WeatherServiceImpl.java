package uz.open.weather.service.impl.weather;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.repository.WeatherRepository;
import uz.open.weather.service.WeatherService;

@Service
@RequiredArgsConstructor
public class WeatherServiceImpl implements WeatherService {

    private final WeatherRepository repository;

    @Override
    public <T, S> Flux<T> getCurrentWeatherInfoByLocation(S body) {
        return null;
    }

    @Override
    public <T> Flux<T> getCitiesList() {

        return (Flux<T>) repository.findAll();
    }


    @Override
    public <T, ID> Mono<T> subscribeToCity(ID locationId) {
        return null;
    }
}
