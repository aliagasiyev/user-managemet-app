package az.edu.turing.usermanagementapp.service.impl;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.domain.repository.UserRepository;
import az.edu.turing.usermanagementapp.mapper.UserMapper;
import az.edu.turing.usermanagementapp.model.request.UserRequest;
import az.edu.turing.usermanagementapp.model.response.UserResponse;
import az.edu.turing.usermanagementapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private static final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    private final UserRepository userRepository;

    @Override
    public List<UserResponse> getAllUsers() {
        List<UserEntity> userEntities = userRepository.findAll();
        List<UserResponse> userResponses = userEntities.stream()
                .map(UserMapper::toResponse)
                .collect(Collectors.toList());
        logger.info("Successfully loaded {} users", userResponses.size());
        return userResponses;
    }

    @Override
    public UserResponse getUserById(Long id) {
        Optional<UserEntity> userEntityOptional = userRepository.findById(id);
        if (userEntityOptional.isPresent()) {
            UserResponse userResponse = UserMapper.toResponse(userEntityOptional.get());
            logger.info("Successfully retrieved user with id: {}", id);
            return userResponse;
        } else {
            logger.error("User not found with id: {}", id);
            throw new RuntimeException("User not found with id: " + id); // Custom exception can be used here
        }
    }

    @Override
    public UserResponse createUser(UserRequest userRequest) {
        UserEntity userEntity = UserMapper.toEntity(userRequest);
        UserEntity savedUserEntity = userRepository.save(userEntity);
        logger.info("Successfully created user with id: {}", savedUserEntity.getId());
        return UserMapper.toResponse(savedUserEntity);
    }

    @Override
    public UserResponse updateUser(Long id, UserRequest userRequest) {
        if (userRepository.existsById(id)) {
            UserEntity userEntity = UserMapper.toEntity(userRequest);
            userEntity.setId(id); // Ensure ID is set for update
            UserEntity updatedUserEntity = userRepository.save(userEntity);
            logger.info("Successfully updated user with id: {}", id);
            return UserMapper.toResponse(updatedUserEntity);
        } else {
            logger.error("User not found for update with id: {}", id);
            throw new RuntimeException("User not found with id: " + id); // Custom exception can be used here
        }
    }

    @Override
    public void deleteUser(Long id) {
        if (userRepository.existsById(id)) {
            userRepository.deleteById(id);
            logger.info("Successfully deleted user with id: {}", id);
        } else {
            logger.error("User not found with id: {}", id);
            //throw new RuntimeException("User not found with id: " + id);
        }
    }

    @Override
    public void deleteAllUsers() {
        userRepository.deleteAll();
        logger.info("Successfully deleted all users");
    }

    @Override
    public long countUsers() {
        long count = userRepository.count();
        logger.info("Total users count: {}", count);
        return count;
    }
}
