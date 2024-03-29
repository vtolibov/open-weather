package uz.open.weather.service;


import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

public interface WebUserService extends UserDetailsService {
    UserDetails loadUserByUsername(String username);
}
