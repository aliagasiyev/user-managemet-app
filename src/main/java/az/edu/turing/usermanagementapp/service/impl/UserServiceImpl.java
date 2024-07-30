package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.model.UserDto;
import az.edu.turing.usermanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public void save(UserDto userDto) {
        UserEntity userEntity =UserEntity.builder().
                username(userDto.getUsername()).
                age(userDto.getAge()).
                createdAt(userDto.getCreatedAt()).
                updatedAt(userDto.getUpdatedAt()).profilePhoto(userDto.getProfilePhoto()).build();
        userRepository.save(userEntity);
        logger.info("User successfully saved");
    }

    @Override
    public List<UserDto> getAll() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserDto> userDto = new ArrayList<>();
        for (UserEntity userEntity : userEntities) {
            userDto.add(mapToUserDto(userEntity));
            logger.info("User successfully loaded");
        }
        return userDto;
    }

    @Override
    public Optional<UserDto> getById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            return Optional.of(mapToUserDto(userEntityOptional.get()));
        } else {
            throw new RuntimeException("User not found with id: " + id); // burada oz yaratdigimiz exceptionu vermeliyik
        }
    }


    public UserDto mapToUserDto(UserEntity userEntity) {
        return UserDto.builder()
                .id(userEntity.getId())
                .username(userEntity.getUsername())
                .age(userEntity.getAge())
                .createdAt(userEntity.getCreatedAt())
                .updatedAt(userEntity.getUpdatedAt())
                .profilePhoto(userEntity.getProfilePhoto() != null ? Base64.getEncoder().encodeToString(userEntity.getProfilePhoto().getBytes()) : null)
                .build();
    }

}
