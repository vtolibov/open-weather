package uz.open.weather.service.impl.user;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.auth.JwtAuthenticationResponse;
import uz.open.weather.model.user.WebUser;
import uz.open.weather.repository.WebUserRepository;
import uz.open.weather.service.AuthenticationService;
import uz.open.weather.service.JwtService;

@Service
@RequiredArgsConstructor
public class AuthenticationServiceImpl implements AuthenticationService {
    private final WebUserRepository webUserRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    public JwtAuthenticationResponse signUp(WebUser request) {
        WebUser user = new WebUser()
                .setUsername(request.getUsername())
                .setPassword(passwordEncoder.encode(request.getPassword()))
                .setRole(request.getRole());
        webUserRepository.save(user);

        AuthUser authUser = new AuthUser()
                .setUsername(request.getUsername())
                .setPassword(request.getPassword())
                .setRole(user.getRole());
        var jwt = jwtService.generateToken(authUser);
        return new JwtAuthenticationResponse(jwt);
    }

    @Override
    public JwtAuthenticationResponse signIn(AuthUser request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword()));
        var user = webUserRepository.findByUsername(request.getUsername())
                .orElseThrow(() -> new IllegalArgumentException("Invalid email or password"));
        AuthUser authUser = new AuthUser()
                .setUsername(request.getUsername())
                .setPassword(request.getPassword())
                .setRole(user.getRole());
        var jwt = jwtService.generateToken(authUser);
        return new JwtAuthenticationResponse(jwt);
    }
}
