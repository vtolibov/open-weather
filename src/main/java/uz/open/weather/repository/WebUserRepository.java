package uz.open.weather.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.user.WebUser;

import java.util.Optional;

@Repository
public interface WebUserRepository extends JpaRepository<WebUser, Long> {
    Optional<WebUser> findByUsername(String username);
}
