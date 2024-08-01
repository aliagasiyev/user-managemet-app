package az.edu.turing.usermanagementapp.model.response;

import lombok.Builder;

@Builder
public record UserResponse(
        Long id,
        String name,
        Integer age,
        String image
) {
}
