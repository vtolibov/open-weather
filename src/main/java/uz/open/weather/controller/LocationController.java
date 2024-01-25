package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import uz.open.weather.dto.location.LocationDto;
import uz.open.weather.service.LocationService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/locations")
public class LocationController {
    private final LocationService locationService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Flux<LocationDto>> getAllLocations() {
        Flux<LocationDto> allLocations = locationService.getAllLocations();
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(allLocations);
    }

    @RequestMapping(value = "/create", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<LocationDto>> createLocation(@RequestBody LocationDto locationDto) {
        Mono<LocationDto> location = locationService.createLocation(locationDto);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(location);
    }

    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<LocationDto>> updateLocation(@RequestBody LocationDto locationDto) {
        Mono<LocationDto> location = locationService.updateLocation(locationDto);
        return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(location);
    }

    @RequestMapping(value = "/delete/{locationId}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Mono<LocationDto>> deleteLocation(@PathVariable Long locationId) {
        locationService.deleteLocation(locationId);
        return ResponseEntity.ok().build();
    }
}
