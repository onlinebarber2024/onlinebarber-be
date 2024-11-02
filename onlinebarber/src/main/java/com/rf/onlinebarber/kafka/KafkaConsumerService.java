package com.rf.onlinebarber.kafka;

import com.rf.onlinebarber.dto.AppointmentDto;
import com.rf.onlinebarber.service.MailService;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumerService {
    private final MailService mailService;

    public KafkaConsumerService(MailService mailService) {
        this.mailService = mailService;
    }
    @KafkaListener(topics = "appointment-created")
    public void appointmentCreateInformation(ConsumerRecord<String, AppointmentDto> record){
        AppointmentDto dto=record.value();
        mailService.sendAppointmentCreateInformation(dto);
   }
    @KafkaListener(topics = "appointment-canceled")
    public void appointmentCanceledInformation(ConsumerRecord<String, AppointmentDto> record){
        AppointmentDto dto=record.value();
        mailService.sendAppointmentCanceledInformation(dto);
    }
}
