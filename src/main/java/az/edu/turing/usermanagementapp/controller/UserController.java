package az.edu.turing.usermanagementapp.controller;

import az.edu.turing.usermanagementapp.model.UserDto;
import az.edu.turing.usermanagementapp.service.impl.UserServiceImpl;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);
    private final UserServiceImpl userService;

    @PostMapping()
    public void createUser(@RequestBody UserDto userDto) {
        userService.save(userDto);
        logger.info("User created: {}", userDto);
    }

    @GetMapping("/all")
    public List<UserDto> getAllUsers() {
        logger.info("Get all users request received");
        return userService.getAll();
    }


}
