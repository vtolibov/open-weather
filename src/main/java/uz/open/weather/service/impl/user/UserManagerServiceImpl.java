package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.open.weather.dto.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.UserManagementService;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserManagerServiceImpl implements UserManagementService<WebUser, Long> {

    private final WebUserRepository userRepository;

    @Override
    public List<WebUser> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public WebUser createUser(WebUser user) {
        return userRepository.save(user);
    }

    @Override
    public WebUser updateUser(WebUser user) {
        if (user.getWebUserId() == null)
            throw new UsernameNotFoundException("User not found");
        return userRepository.save(user);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public WebUser getUser(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found"));
    }
}
