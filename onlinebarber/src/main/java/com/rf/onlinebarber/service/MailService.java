package com.rf.onlinebarber.service;

import com.rf.onlinebarber.config.MailDependency;
import com.rf.onlinebarber.dto.AppointmentDto;
import lombok.RequiredArgsConstructor;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.time.format.DateTimeFormatter;

@Service
@RequiredArgsConstructor
public class MailService {
    private final JavaMailSender sender;

    // randevu oluşturuldu maili
    public void sendAppointmentCreateInformation(AppointmentDto appointment){
        SimpleMailMessage mailMessage= MailDependency.getInstance().getMailMessage();
        mailMessage.setTo(appointment.getCustomer().getEmail());
        mailMessage.setSubject("Randevunuz oluşturuldu");
        mailMessage.setText("Sayın " + appointment.getCustomer().getName() + " " +
                appointment.getDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " tarihindeki randevunuz  oluşmuştur");
        sender.send(mailMessage);
    }
    // randevu iptal maili
    public void sendAppointmentCanceledInformation(AppointmentDto appointment){
        SimpleMailMessage mailMessage= MailDependency.getInstance().getMailMessage();
        mailMessage.setTo(appointment.getCustomer().getEmail());
        mailMessage.setSubject("Randevunu İptali");
        mailMessage.setText("Sayın " + appointment.getCustomer().getName() +
                " " + appointment.getDateTime().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")) + " tarihindeki randevunuz iptal olmuştur.");
        sender.send(mailMessage);
    }
}
