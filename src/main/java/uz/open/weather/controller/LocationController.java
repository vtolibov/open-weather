package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.open.weather.service.LocationService;

@RestController
@RequiredArgsConstructor
public class LocationController {
    private final LocationService locationService;

}
