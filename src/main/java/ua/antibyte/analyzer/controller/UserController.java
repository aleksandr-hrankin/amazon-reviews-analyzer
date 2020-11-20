package ua.antibyte.analyzer.controller;

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
    public List<UserResponseDto> getMostActive(
            @RequestParam(defaultValue = PAGE_SIZE) int quantity) {
        return userService.findMostActive(quantity);
    }
}
