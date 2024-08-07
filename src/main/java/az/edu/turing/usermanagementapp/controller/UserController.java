package az.edu.turing.usermanagementapp.controller;

import az.edu.turing.usermanagementapp.model.request.ImageRequest;
import az.edu.turing.usermanagementapp.model.request.UserRequest;
import az.edu.turing.usermanagementapp.model.response.UserResponse;
import az.edu.turing.usermanagementapp.service.UserService;
import jakarta.validation.Valid;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/users")
public class UserController {

    private final UserService userService;
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAllUsers() {
        List<UserResponse> users = userService.getAllUsers();
        logger.info("Retrieved all users. Total count: {}", users.size());
        return ResponseEntity.ok(users);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable @NonNull Long id) {
        UserResponse user = userService.getUserById(id);
        logger.info("Retrieved user with id: {}", id);
        return ResponseEntity.ok(user);
    }

    @PostMapping
    public ResponseEntity<UserResponse> createUser(@RequestBody @Valid UserRequest userRequest) {
        UserResponse createdUser = userService.createUser(userRequest);
        logger.info("Created new user with id: {}", createdUser.id());
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> updateUser(@PathVariable @NonNull Long id, @RequestBody @Valid UserRequest userRequest) {
        UserResponse updatedUser = userService.updateUser(id, userRequest);
        logger.info("Updated user with id: {}", id);
        return ResponseEntity.ok(updatedUser);
    }

    @PatchMapping("/{id}/image")
    public ResponseEntity<Void> updateUserImage(@PathVariable @NonNull Long id, @RequestBody @Valid ImageRequest imageRequest) {
        userService.updateUserImage(id, imageRequest);
        logger.info("Updated image for user with id: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable @NonNull Long id) {
        userService.deleteUser(id);
        logger.info("Deleted user with id: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/all")
    public ResponseEntity<Void> deleteAllUsers() {
        userService.deleteAllUsers();
        logger.info("Deleted all users.");
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/count")
    public ResponseEntity<Long> countUsers() {
        long count = userService.countUsers();
        logger.info("Total user count: {}", count);
        return ResponseEntity.ok(count);
    }
}
