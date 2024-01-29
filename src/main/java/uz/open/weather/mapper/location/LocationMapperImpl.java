package uz.open.weather.mapper.location;

import org.springframework.stereotype.Component;
import uz.open.weather.dto.location.LocationDto;
import uz.open.weather.model.location.Location;

@Component
public class LocationMapperImpl implements LocationMapper {
    @Override
    public Location locationDtoToLocationEntity(LocationDto locationDto) {
        if (locationDto == null) {
            return null;
        }
        return new Location()
                .setId(locationDto.getLocationId())
                .setLocationName(locationDto.getLocationName())
                .setIsAvailable(locationDto.getIsAvailable())
                .setLon(locationDto.getLongitude())
                .setLat(locationDto.getLatitude());
    }

    @Override
    public LocationDto locationEntityToLocationDto(Location locationEntity) {
        if (locationEntity == null) {
            return null;
        }
        return new LocationDto()
                .setLocationId(locationEntity.getId())
                .setLocationName(locationEntity.getLocationName())
                .setLatitude(locationEntity.getLat())
                .setLongitude(locationEntity.getLon())
                .setIsAvailable(locationEntity.getIsAvailable());
    }
}
