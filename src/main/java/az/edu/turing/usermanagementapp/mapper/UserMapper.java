package az.edu.turing.usermanagementapp.mapper;

import az.edu.turing.usermanagementapp.domain.entity.UserEntity;
import az.edu.turing.usermanagementapp.model.request.UserRequest;
import az.edu.turing.usermanagementapp.model.response.UserResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UserMapper {


    UserEntity toEntity(UserRequest userRequest);

    UserResponse toResponse(UserEntity userEntity);

    List<UserResponse> toResponseList(List<UserEntity> userEntityList);
}
