package uz.open.weather.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.UserService;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl implements UserService {

    private final WebUserRepository webUserRepository;

    @Override
    public UserDetailsService userDetailsService() {
        return username -> webUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
