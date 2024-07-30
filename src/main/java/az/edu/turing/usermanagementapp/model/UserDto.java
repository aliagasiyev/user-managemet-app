package az.edu.turing.usermanagementapp.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDto {

    private long id;
    private String username;
    private int age;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private String profilePhoto;
}
