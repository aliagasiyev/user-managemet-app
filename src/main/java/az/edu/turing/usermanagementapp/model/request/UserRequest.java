package az.edu.turing.usermanagementapp.model.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record UserRequest(
        @NotBlank
        String name,
        @NotNull
        Integer age,
        @NotBlank
        String image
) {
}
