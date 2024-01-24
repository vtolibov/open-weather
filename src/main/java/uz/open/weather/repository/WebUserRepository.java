package uz.open.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import uz.open.weather.dto.user.WebUser;

import java.util.Optional;

public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}
