package uz.open.weather.dto.user;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;
import uz.open.weather.model.user.WebUserRole;

@Getter
@Setter
@Accessors(chain = true)
public class WebUserDto {
    @JsonProperty(value = "user_id")
    private Long userId;
    @JsonProperty(value = "username")
    private String username;
    @JsonProperty(value = "lastname")
    private String lastname;
    @JsonProperty(value = "firstname")
    private String firstname;
    @JsonProperty(value = "password")
    private String password;
    @JsonProperty(value = "role")
    private WebUserRole role;
    @JsonProperty(value = "is_active")
    private Boolean isActive;
}
