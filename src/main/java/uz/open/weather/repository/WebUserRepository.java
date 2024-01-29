package uz.open.weather.repository;

import org.springframework.data.r2dbc.repository.R2dbcRepository;
import uz.open.weather.model.user.WebUser;

import java.util.Optional;

public interface WebUserRepository extends R2dbcRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}
