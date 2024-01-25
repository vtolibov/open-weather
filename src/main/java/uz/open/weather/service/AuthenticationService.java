package uz.open.weather.service;

import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.auth.JwtAuthenticationResponse;
import uz.open.weather.dto.user.WebUserDto;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(WebUserDto request);

    JwtAuthenticationResponse signIn(AuthUser request);
}
