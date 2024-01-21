package uz.open.weather.service;

import org.springframework.security.core.userdetails.UserDetails;
import uz.open.weather.dto.auth.AuthUser;

public interface JwtService {
    String extractUserName(String token);

    String generateToken(AuthUser userDetails);

    boolean isTokenValid(String token, UserDetails userDetails);
}
