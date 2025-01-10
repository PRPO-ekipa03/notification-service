package si.uni.prpo.group03.notificationservice.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import si.uni.prpo.group03.notificationservice.dto.NotificationDTO;
import si.uni.prpo.group03.notificationservice.service.NotificationService;

@Tag(name = "Notifications", description = "Controller for sending notification emails.")
@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @Operation(summary = "Send confirmation mail", 
               description = "Sends a confirmation email to the specified recipient using details from NotificationDTO.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Confirmation mail sent successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid notification request data"),
        @ApiResponse(responseCode = "500", description = "Failed to send email")
    })
    @PostMapping("/confirmation")
    public ResponseEntity<String> sendConfirmationMail(@RequestBody NotificationDTO notification) {
        notificationService.sendConfirmationMail(notification);
        return ResponseEntity.status(HttpStatus.OK).body("Confirmation mail sent");
    }

    @Operation(summary = "Send password reset mail", 
               description = "Sends a password reset email to the specified recipient using details from NotificationDTO.")
    @ApiResponses({
        @ApiResponse(responseCode = "200", description = "Password reset mail sent successfully"),
        @ApiResponse(responseCode = "400", description = "Invalid notification request data"),
        @ApiResponse(responseCode = "500", description = "Failed to send email")
    })
    @PostMapping("/password-reset")
    public ResponseEntity<String> sendPasswordResetMail(@RequestBody NotificationDTO notification) {
        notificationService.sendPasswordResetMail(notification);
        return ResponseEntity.status(HttpStatus.OK).body("Password reset mail sent");
    }
}
