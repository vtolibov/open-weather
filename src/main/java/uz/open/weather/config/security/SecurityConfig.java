package uz.open.weather.config.security;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import uz.open.weather.model.user.WebUserRole;
import uz.open.weather.service.WebUserService;


@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {
    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final WebUserService webUserService;

    private static final String LOCATION_CREATE = "/api/v1/locations/create";
    private static final String LOCATION_UPDATE = "/api/v1/locations/update";
    private static final String LOCATION_DELETE = "/api/v1/locations/delete/**";
    private static final String USER_CREATE = "/api/v1/users/create_user";
    private static final String USER_UPDATE = "/api/v1/users/update_user";
    private static final String USER_DELETE = "/api/v1/users/delete_user/**";
    private static final String USER_GET = "/api/v1/users/get_user/**";
    private static final String USER_GET_ALL = "/api/v1/users/get_all";


    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        return http.cors().configurationSource(request -> new CorsConfiguration().applyPermitDefaultValues())
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers(
                        LOCATION_CREATE,
                        LOCATION_UPDATE,
                        LOCATION_DELETE,
                        USER_CREATE,
                        USER_UPDATE,
                        USER_DELETE,
                        USER_GET,
                        USER_GET_ALL
                ).hasRole(WebUserRole.ADMINISTRATOR.name())
                .antMatchers("/subscription/create")
                .hasRole(WebUserRole.USER.name())
                .anyRequest().authenticated()
                .antMatchers("/api/v1/locations/get_all", "/api/v1/locations/get_location/**", "/swagger-ui.html").permitAll()
                .and()
                .sessionManagement(manager -> manager.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider()).addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(webUserService);
        authProvider.setPasswordEncoder(passwordEncoder());
        return authProvider;
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config)
            throws Exception {
        return config.getAuthenticationManager();
    }
}


