package az.edu.turing.usermanagementapp.service;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.UserDto;

import java.util.List;
import java.util.Optional;

public interface UserService {
    void save(UserDto userDto);

    List<UserDto> getAll();

    Optional<UserDto> getById(Long id);
}
