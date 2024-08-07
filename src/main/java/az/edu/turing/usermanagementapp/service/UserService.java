package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.model.request.ImageRequest;
import az.edu.turing.usermanagementapp.model.request.UserRequest;
import az.edu.turing.usermanagementapp.model.response.UserResponse;

import java.util.List;

public interface UserService {
    List<UserResponse> getAllUsers();

    UserResponse getUserById(Long id);

    UserResponse createUser(UserRequest userRequest);

    UserResponse updateUser(Long id, UserRequest userRequest);

    void updateUserImage(Long id, ImageRequest imageRequest);

    void deleteUser(Long id);

    void deleteAllUsers();

    long countUsers();
}
