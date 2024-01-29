package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.stereotype.Service;
import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.auth.JwtAuthenticationResponse;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.mapper.user.WebUserMapper;
import uz.open.weather.model.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.AuthenticationService;
import uz.open.weather.service.JwtService;

@RequiredArgsConstructor
@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final JwtService jwtService;
    private final WebUserMapper webUserMapper;
    private final WebUserRepository webUserRepository;
//    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signUp(WebUserDto request) {
        WebUser webUser = webUserMapper.webUserDtoToEntity(request);

        webUserRepository.save(webUser);
        AuthUser authUser = new AuthUser()
                .setUsername(request.getUsername())
                .setPassword(request.getPassword())
                .setRole(webUser.getRole());
        var jwt = jwtService.generateToken(authUser);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signIn(AuthUser request) {
//        authenticationManager.authenticate(
//                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = webUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid username or password"));
        AuthUser authUser = new AuthUser()
                .setUsername(request.getUsername())
                .setPassword(request.getPassword())
                .setRole(user.getRole());
        var jwt = jwtService.generateToken(authUser);
        return new JwtAuthenticationResponse(jwt);
    }
}
