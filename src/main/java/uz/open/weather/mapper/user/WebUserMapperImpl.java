package uz.open.weather.mapper.user;

import org.springframework.stereotype.Component;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.model.user.WebUser;

@Component
public class WebUserMapperImpl implements WebUserMapper {

    @Override
    public WebUser webUserDtoToEntity(WebUserDto webUserDto) {
        if (webUserDto == null) {
            return null;
        }
        return new WebUser()
                .setFirstname(webUserDto.getFirstname())
                .setLastname(webUserDto.getLastname())
                .setUsername(webUserDto.getUsername())
                .setPassword(webUserDto.getPassword())
                .setRole(webUserDto.getRole())
                .setIsActive(webUserDto.getIsActive())
                .setId(webUserDto.getUserId());
    }

    @Override
    public WebUserDto webUserEntityToDto(WebUser webUserEntity) {
        if (webUserEntity == null) {
            return null;
        }
        return new WebUserDto()
                .setFirstname(webUserEntity.getFirstname())
                .setLastname(webUserEntity.getLastname())
                .setUsername(webUserEntity.getUsername())
                .setPassword(webUserEntity.getPassword())
                .setRole(webUserEntity.getRole())
                .setUserId(webUserEntity.getId())
                .setIsActive(webUserEntity.getIsActive());
    }
}
