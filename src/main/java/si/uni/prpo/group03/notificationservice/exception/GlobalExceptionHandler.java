package si.uni.prpo.group03.notificationservice.exception;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.MailException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MailException.class)
    @ApiResponses({
        @ApiResponse(responseCode = "500", description = "Failed to send email due to server error")
    })
    public ResponseEntity<String> handleMailException(MailException ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to send email: " + ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ApiResponses({
        @ApiResponse(responseCode = "500", description = "Unexpected internal server error")
    })
    public ResponseEntity<String> handleGeneralException(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred: " + ex.getMessage());
    }
}
