package uz.open.weather.mapper.location;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.open.weather.dto.location.LocationDto;
import uz.open.weather.model.location.Location;

@Component
@Mapper(componentModel = "spring")
public interface LocationMapper {

    @Mapping(target = "id", source = "locationId", ignore = true)
    @Mapping(target = "locationName", source = "locationName")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    Location locationDtoToLocationEntity(LocationDto locationDto);

    @Mapping(target = "userId", source = "id", ignore = true)
    @Mapping(target = "locationName", source = "locationName")
    @Mapping(target = "latitude", source = "latitude")
    @Mapping(target = "longitude", source = "longitude")
    LocationDto locationEntityToLocationDto(Location locationEntity);
}
