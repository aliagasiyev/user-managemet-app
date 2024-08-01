package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.request.UserRequest;
import az.edu.turing.usermanagementapp.model.response.UserResponse;

public class UserMapper {

    // Convert UserEntity to UserResponse
    public static UserResponse toResponse(UserEntity userEntity) {
        if (userEntity == null) {
            return null;
        }
        return UserResponse.builder()
                .id(userEntity.getId())
                .name(userEntity.getUsername())
                .age(userEntity.getAge())
                .image(userEntity.getProfilePhoto())
                .build();
    }

    // Convert UserRequest to UserEntity
    public static UserEntity toEntity(UserRequest userRequest) {
        if (userRequest == null) {
            return null;
        }
        UserEntity userEntity = new UserEntity();
        userEntity.setUsername(userRequest.name());
        userEntity.setAge(userRequest.age());
        userEntity.setProfilePhoto(userRequest.image());
        return userEntity;
    }
}
