package uz.open.weather.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RestController;
import uz.open.weather.service.UserManagementService;


@RestController
@RequiredArgsConstructor
public class UserManagementController {
    private final UserManagementService userManagementService;

}
