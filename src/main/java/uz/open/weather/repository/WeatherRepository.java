package uz.open.weather.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import uz.open.weather.model.weather.Weather;

public interface WeatherRepository extends R2dbcRepository<Weather, Long> {
}
