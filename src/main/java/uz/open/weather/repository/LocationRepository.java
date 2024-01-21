package uz.open.weather.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.open.weather.dto.location.Location;

public interface LocationRepository extends ReactiveCrudRepository<Location, Long> {
}
