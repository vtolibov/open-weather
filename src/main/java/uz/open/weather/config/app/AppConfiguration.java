package uz.open.weather.config.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@Configuration
public class AppConfiguration {

    @Bean("webClient")
    public WebClient webClient() {
        return WebClient.create();
    }
}
