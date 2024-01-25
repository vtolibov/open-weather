package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.mapper.user.WebUserMapper;
import uz.open.weather.model.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.UserManagementService;


@Service
@RequiredArgsConstructor
public class UserManagerServiceImpl implements UserManagementService<WebUserDto, Long> {

    private final WebUserRepository userRepository;
    private final WebUserMapper userMapper;

    @Override
    public Flux<WebUserDto> getAllUsers() {
        return userRepository.findAll()
                .map(userMapper::webUserEntityToDto)
                .flatMap(Flux::just);
    }

    @Override
    public Mono<WebUserDto> createUser(WebUserDto user) {
        WebUser webUser = userMapper.webUserDtoToEntity(user);
        return userRepository.save(webUser)
                .map(userMapper::webUserEntityToDto);
    }

    @Override
    public Mono<WebUserDto> updateUser(WebUserDto user) {
        if (user.getUserId() == null)
            throw new UsernameNotFoundException("User not found");
        WebUser webUser = userMapper.webUserDtoToEntity(user);
        return userRepository.save(webUser).map(userMapper::webUserEntityToDto);
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public Mono<WebUserDto> getUser(Long id) {
        return userRepository.findById(id).map(userMapper::webUserEntityToDto);
    }
}
