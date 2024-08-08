package az.edu.turing.usermanagementapp.exception;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse {
    private String errorMessage;
    private int errorCode;
}
