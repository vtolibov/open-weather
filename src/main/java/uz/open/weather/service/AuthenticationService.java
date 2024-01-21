package uz.open.weather.service;

import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.auth.JwtAuthenticationResponse;
import uz.open.weather.dto.user.WebUser;

public interface AuthenticationService {
    JwtAuthenticationResponse signUp(WebUser request);

    JwtAuthenticationResponse signIn(AuthUser request);
}
