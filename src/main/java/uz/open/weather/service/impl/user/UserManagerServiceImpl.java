package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.dto.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.UserManagementService;

@Service
@RequiredArgsConstructor
public class UserManagerServiceImpl implements UserManagementService<WebUser, Long> {

    private final WebUserRepository userRepository;

    @Override
    public Flux<WebUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Mono<WebUser> createUser(WebUser user) {
        return userRepository.save(user);
    }

    @Override
    public Mono<WebUser> updateUser(WebUser user) {
        if (user.getWebUserId() == null)
            throw new UsernameNotFoundException("User not found");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Mono<WebUser> getUser(Long id) {
        return userRepository.findById(id);
    }
}
