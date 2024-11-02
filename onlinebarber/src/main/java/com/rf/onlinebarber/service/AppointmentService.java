package com.rf.onlinebarber.service;

import com.rf.onlinebarber.dto.*;

import com.rf.onlinebarber.dto.converter.*;
import com.rf.onlinebarber.exception.*;

import com.rf.onlinebarber.kafka.KafkaProducerService;
import com.rf.onlinebarber.model.*;

import com.rf.onlinebarber.repository.AppointmentRepository;
import lombok.*;


import org.springframework.stereotype.Service;
import java.time.*;

import java.util.*;

import java.util.stream.*;

@Service
@RequiredArgsConstructor

public class AppointmentService {
    private final AppointmentRepository repository;
    private final ModelService modelService;
    private final CustomerService customerService;
    private final DtoConverter converter;
    private final KafkaProducerService kafkaProducerService;
    // randevu oluştur
    public ApiResponse<Void> createAppointment(Long customerId, Long modelId, CreateAppointmentRequest request) {
        ShavingModel model=modelService.findById(modelId);
        Customer customer=customerService.findById(customerId);
        // berber musaitmi
        if(!isAvailable(request.getDateTime(),model.getBarber().getId())) throw new NotAvailableException();
        if(!AnotherAppointmentValid(request.getDateTime(),customer)) throw new AppointmentConflictException();
        Appointment appointment=Appointment.builder().model(model).customer(customer).dateTime(request.getDateTime()).build();
        repository.save(appointment);
        // kafka üzerinden randevu oluşturuldu bildirimin gönderilmesi
        kafkaProducerService.sendAppointmentCreatedNotification(converter.convertAppointment(appointment));
        return ApiResponse.ok("Randevu oluşturuldu");
    }
    // berber musait mi kontrolü
    private boolean isAvailable(LocalDateTime dateTime,Long barberId){
        // seçilen tarih şu andan eski ,günlerden pazar ve saat 9 ile 22 arasinda değilse randevu oluşturmayacak
        if (dateTime.isBefore(LocalDateTime.now()) || dateTime.getDayOfWeek() == DayOfWeek.SUNDAY || dateTime.getHour() < 9 || dateTime.getHour() >= 22) {
            return false;
        }
        for (AppointmentDto appointment : appointmentList(barberId)) {
            if (appointment.getDateTime().isEqual(dateTime)) {
                return false;
            }
        }
        return true;
    }

    private boolean AnotherAppointmentValid(LocalDateTime dateTime, Customer customer) {
        List<Appointment> appointments = repository.findByCustomerId(customer.getId());

        for (Appointment appointment : appointments) {

            if (isSameDay(appointment.getDateTime(), dateTime) && appointment.getDateTime().getHour() == dateTime.getHour()) {
                return false;
            }
        }
        return true;
    }

    private boolean isSameDay(LocalDateTime date1, LocalDateTime date2) {
        return date1.toLocalDate().isEqual(date2.toLocalDate());
    }

    // mağazaya ait randevular listesi
    private List<AppointmentDto> appointmentList(Long barberId){
        return repository.findAll().stream().filter(x-> x.getModel().getBarber().getId().equals(barberId)).map(converter::convertAppointment).collect(Collectors.toList());
    }

    // kullanıcıya ait
    private List<AppointmentDto> listByCustomer(Long customerId){
        List<Appointment> appointments=repository.findByCustomerId(customerId);
        return appointments.stream().map(converter::convertAppointment).collect(Collectors.toList());
    }
    public ApiResponse<Void> cancelledAppointment(Long id) {
        Appointment appointment=repository.findById(id).orElseThrow(AppointmentNotFoundException::new);
        repository.delete(appointment);
        kafkaProducerService.sendAppointmentCanceledNotification(converter.convertAppointment(appointment));
        return ApiResponse.ok("Randevu iptal oldu");
    }

    public ApiResponse<List<AppointmentDto>> appointmentsByBarber(Long id) {
        return ApiResponse.ok("randevu listesi",appointmentList(id));
    }

    public ApiResponse<List<AppointmentDto>> appointmentsByCustomer(Long id) {
        return ApiResponse.ok("randevu listesi",listByCustomer(id));
    }


    public ApiResponse<AppointmentDto> getModel(Long id) {
        Appointment appointment=repository.findById(id).orElseThrow(AppointmentNotFoundException::new);
        return ApiResponse.ok("Randevu",converter.convertAppointment(appointment));
    }
}
