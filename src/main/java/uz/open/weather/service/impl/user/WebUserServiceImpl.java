package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.WebUserService;

@Service
@RequiredArgsConstructor
public class WebUserServiceImpl implements WebUserService {

    private final WebUserRepository webUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) {

        WebUser webUser = webUserRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
        return AuthUser.builder()
                .username(webUser.getUsername())
                .password(webUser.getPassword())
                .role(webUser.getRole())
                .build();
    }
}

