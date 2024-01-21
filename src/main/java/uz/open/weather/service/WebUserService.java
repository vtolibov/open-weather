package uz.open.weather.service;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface WebUserService {
    UserDetailsService userDetailsService();
}
