package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.AppointmentDto;
import com.rf.onlinebarber.dto.CreateAppointmentRequest;
import com.rf.onlinebarber.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.APPOINTMENT)
public class AppointmentController {
    private final AppointmentService service;

    public AppointmentController(AppointmentService service) {
        this.service = service;
    }
    // randevu oluştur
    @PostMapping(ApiPaths.CREATE_APPOINTMENT)
    ResponseEntity<ApiResponse<Void>> createAppointment(@PathVariable Long customerId,@PathVariable Long modelId,@RequestBody CreateAppointmentRequest request){
        return ResponseEntity.ok(service.createAppointment(customerId,modelId,request));
    }
    // randevu güncelle

    // randevu iptal
    @DeleteMapping(ApiPaths.DELETE)
    ResponseEntity<ApiResponse<Void>> cancelledAppointment(@PathVariable Long id){
        return ResponseEntity.ok(service.cancelledAppointment(id));
    }
    // mağazaya ait  randevuları listele
    @GetMapping(ApiPaths.APPOINTMENT_BY_BARBER)
    ResponseEntity<ApiResponse<List<AppointmentDto>>> AppointmentsByBarber(@PathVariable Long id){
        return ResponseEntity.ok(service.appointmentsByBarber(id));
    }
    // kullanıcıya ait randevuları listele
    @GetMapping(ApiPaths.APPOINTMENT_BY_CUSTOMER)
    ResponseEntity<ApiResponse<List<AppointmentDto>>> AppointmentsByCustomer(@PathVariable Long id){
        return ResponseEntity.ok(service.appointmentsByCustomer(id));
    }
    // randevu bilgisi
    @GetMapping(ApiPaths.GET)
    ResponseEntity<ApiResponse<AppointmentDto>> getAppointment(@PathVariable Long id){
        return ResponseEntity.ok(service.getModel(id));
    }
}
