package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import uz.open.weather.dto.user.WebUserDto;
import uz.open.weather.service.UserManagementService;

import java.util.List;


@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserManagementController {

    private final UserManagementService<WebUserDto, Long> userManagementService;

    @RequestMapping(value = "/get_all", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<WebUserDto>> getAllUsers() {
        return ResponseEntity.ok(userManagementService.getAllUsers());
    }

    @RequestMapping(value = "/create_user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebUserDto> createUser(@RequestBody WebUserDto userDto) {
        return ResponseEntity.ok(userManagementService.createUser(userDto));
    }

    @RequestMapping(value = "/update_user", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<WebUserDto> updateUser(@RequestBody WebUserDto webUserDto) {
        return ResponseEntity.ok(userManagementService.updateUser(webUserDto));
    }

    @RequestMapping(value = "/delete_user/{userId}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<Void> deleteUser(@PathVariable Long userId) {
        userManagementService.deleteUser(userId);
        return ResponseEntity.ok().build();
    }
}
