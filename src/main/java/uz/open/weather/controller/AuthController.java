package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.open.weather.dto.auth.AuthUser;
import uz.open.weather.dto.auth.JwtAuthenticationResponse;
import uz.open.weather.dto.user.WebUser;
import uz.open.weather.service.AuthenticationService;


@RestController
@RequiredArgsConstructor
public class AuthController {
    private final AuthenticationService authenticationService;

    @RequestMapping(value = "/signup", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtAuthenticationResponse> signUp(@RequestBody WebUser request) {
        return ResponseEntity.ok(authenticationService.signUp(request));
    }

    @RequestMapping(value = "/signin", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<JwtAuthenticationResponse> signIn(@RequestBody AuthUser request) {
        return ResponseEntity.ok(authenticationService.signIn(request));
    }
}
