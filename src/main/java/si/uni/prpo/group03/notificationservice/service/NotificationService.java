package si.uni.prpo.group03.notificationservice.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;
import si.uni.prpo.group03.notificationservice.dto.NotificationDTO;

@Service
public class NotificationService {

    @Autowired
    private JavaMailSender mailSender;

    @Value("${spring.mail.sender.name}")
    private String senderName;
    @Value("${spring.mail.username}")
    private String senderMail;

    public void sendConfirmationMail(NotificationDTO notificationDTO) {
        sendMail(notificationDTO);
    }

    public void sendPasswordResetMail(NotificationDTO notificationDTO) {
        sendMail(notificationDTO);
    }

    private void sendMail(NotificationDTO notificationDTO) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom(senderName + "<" + senderMail + ">");
        message.setTo(notificationDTO.getEmail());
        message.setSubject(notificationDTO.getSubject());
        message.setText(notificationDTO.getMessage());

        try {
            mailSender.send(message);
        } catch (MailException ex) {
            throw ex;
        }
    }
}
