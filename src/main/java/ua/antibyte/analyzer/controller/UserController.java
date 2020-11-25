package ua.antibyte.analyzer.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ua.antibyte.analyzer.entity.dto.response.UserResponseDto;
import ua.antibyte.analyzer.service.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
    private static final String PAGE_SIZE = "1000";
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/most-active")
    @ApiOperation(value = "Get a list of the most active users")
    public List<UserResponseDto> getMostActive(
            @ApiParam(name = "You can enter the number of users to return")
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return userService.findMostActive(quantity);
    }
}
