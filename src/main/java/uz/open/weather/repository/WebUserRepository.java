package uz.open.weather.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import uz.open.weather.model.user.WebUser;

import java.util.Optional;

public interface WebUserRepository extends ReactiveCrudRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}
