package uz.open.weather.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import uz.open.weather.model.location.Location;

public interface LocationRepository extends R2dbcRepository<Location, Long> {
}
