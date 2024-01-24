package uz.open.weather.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.open.weather.model.weather.Weather;

public interface WeatherRepository extends ReactiveCrudRepository<Weather, Long> {
}
