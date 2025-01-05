package si.uni.prpo.group03.notificationservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import si.uni.prpo.group03.notificationservice.dto.NotificationDTO;
import si.uni.prpo.group03.notificationservice.service.NotificationService;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {

    @Autowired
    private NotificationService notificationService;

    @PostMapping("/confirmation")
    public ResponseEntity<String> sendConfirmationMail(@RequestBody NotificationDTO notification) {
        notificationService.sendConfirmationMail(notification);
        return ResponseEntity.status(HttpStatus.OK).body("Confirmation mail sent");
    }

    @PostMapping("/password-reset")
    public ResponseEntity<String> sendPasswordResetMail(@RequestBody NotificationDTO notification) {
        notificationService.sendPasswordResetMail(notification);
        return ResponseEntity.status(HttpStatus.OK).body("Password reset mail sent");
    }
}
