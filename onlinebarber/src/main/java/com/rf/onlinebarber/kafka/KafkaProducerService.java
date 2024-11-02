package com.rf.onlinebarber.kafka;

import com.rf.onlinebarber.dto.AppointmentDto;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaProducerService {

    private final KafkaTemplate<String, AppointmentDto> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String,AppointmentDto> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    // randevu oluşturuldu bildirimi
    public void sendAppointmentCreatedNotification(AppointmentDto dto){
        String topic="appointment-created";
        kafkaTemplate.send(topic,dto);
    }
    // randevu iptal edildi bildirimi
    public void sendAppointmentCanceledNotification(AppointmentDto dto){
        String topic="appointment-canceled";
        kafkaTemplate.send(topic,dto);
    }


}
