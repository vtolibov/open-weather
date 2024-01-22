package uz.open.weather.config.app;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.web.reactive.function.client.WebClient;

import java.net.URI;
import java.time.Duration;

@Configuration
@RequiredArgsConstructor
public class RequestProcessor {
    private final WebClient webClient;

    public <RES, REQ> RES doGet(
            URI uri,
            HttpHeaders httpHeaders,
            REQ requestBody,
            ParameterizedTypeReference<RES> responseClass,
            Duration timeout
    ) {
        return webClient
                .method(HttpMethod.GET)
                .uri(uri)
                .headers(headers -> headers.addAll(httpHeaders))
                .bodyValue(requestBody)
                .retrieve()
                .bodyToMono(responseClass)
                .timeout(timeout)
                .block();
    }
}
