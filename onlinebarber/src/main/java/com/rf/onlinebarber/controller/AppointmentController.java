package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.CreateAppointmentRequest;
import com.rf.onlinebarber.service.AppointmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    // mağazaya ait  randevuları listele
    // kullanıcıya ait randevuları listele
    // randevu bilgisi
}
