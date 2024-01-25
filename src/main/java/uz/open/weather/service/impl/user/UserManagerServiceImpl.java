package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.mapper.user.WebUserMapper;
import uz.open.weather.model.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.UserManagementService;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserManagerServiceImpl implements UserManagementService<WebUserDto, Long> {

    private final WebUserRepository userRepository;
    private final WebUserMapper userMapper;

    @Override
    public List<WebUserDto> getAllUsers() {
        return userRepository.findAll().stream().map(userMapper::webUserEntityToDto).collect(Collectors.toList());
    }

    @Override
    public WebUserDto createUser(WebUserDto user) {
        WebUser webUser = userMapper.webUserDtoToEntity(user);
        return userMapper.webUserEntityToDto(userRepository.save(webUser));
    }

    @Override
    public WebUserDto updateUser(WebUserDto user) {
        if (user.getUserId() == null)
            throw new UsernameNotFoundException("User not found");
        WebUser webUser = userMapper.webUserDtoToEntity(user);
        return userMapper.webUserEntityToDto(userRepository.save(webUser));
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    @Override
    public WebUserDto getUser(Long id) {
        return userMapper.webUserEntityToDto(userRepository.findById(id)
                .orElseThrow(() -> new UsernameNotFoundException("User not found")));
    }
}
