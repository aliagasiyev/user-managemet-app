package az.edu.turing.usermanagementapp.model.request;

import jakarta.validation.constraints.NotBlank;

public record ImageRequest(
        @NotBlank
        String userImage
) {
}
