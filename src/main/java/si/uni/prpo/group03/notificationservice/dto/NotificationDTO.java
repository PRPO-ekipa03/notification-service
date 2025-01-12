package si.uni.prpo.group03.notificationservice.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

@Schema(description = "Data Transfer Object for sending notifications")
public class NotificationDTO {

    @Schema(description = "Recipient email address", example = "user@example.com")
    @NotBlank(message = "Email is required")
    @Email(message = "Email should be valid")
    private String email;

    @Schema(description = "Content of the notification message", example = "Your account has been successfully created.")
    @NotBlank(message = "Message should not be empty")
    private String message;

    @Schema(description = "Subject of the notification", example = "Account Confirmation")
    private String subject;

    // Getters
    public String getEmail() {
        return email;
    }

    public String getMessage() {
        return message;
    }

    public String getSubject() {
        return subject;
    }
}
