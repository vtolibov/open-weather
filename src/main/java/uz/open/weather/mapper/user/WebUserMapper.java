package uz.open.weather.mapper.user;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.model.user.WebUser;

@Mapper
@Component
public interface WebUserMapper {

    @Mapping(target = "id", source = "userId", ignore = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "isActive", source = "isActive")
    WebUser webUserDtoToEntity(WebUserDto webUser);

    @Mapping(target = "userId", source = "id", ignore = true)
    @Mapping(target = "username", source = "username")
    @Mapping(target = "lastname", source = "lastname")
    @Mapping(target = "firstname", source = "firstname")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "role", source = "role")
    @Mapping(target = "isActive", source = "isActive")
    WebUserDto webUserEntityToDto(WebUser webUserDto);
}
