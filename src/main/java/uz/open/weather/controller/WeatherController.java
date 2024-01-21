package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import uz.open.weather.dto.weather.Weather;
import uz.open.weather.service.WeatherService;


@RestController
@RequiredArgsConstructor
public class WeatherController {

    private final WeatherService weatherService;

    @RequestMapping(value = "/get_all_available_locations", method = RequestMethod.GET)
    public Flux<Weather> getAvailableLocation() {
        return weatherService.getCitiesList();
    }
}
