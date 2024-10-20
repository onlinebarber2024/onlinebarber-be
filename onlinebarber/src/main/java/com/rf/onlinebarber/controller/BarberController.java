package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.CreateBarberRequest;
import com.rf.onlinebarber.service.BarberService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ApiPaths.BARBER)

public class BarberController {
    private final BarberService barberService;

    public BarberController(BarberService barberService) {
        this.barberService = barberService;
    }
    // kayıt
    @PostMapping(ApiPaths.SAVE)
    public ResponseEntity<ApiResponse<Void>> createBarber(@Valid @RequestBody CreateBarberRequest request){
        return ResponseEntity.ok(barberService.createBarber(request));
    }
    // güncelle
    // sil
    @DeleteMapping(ApiPaths.DELETE)
    public ResponseEntity<ApiResponse<Void>> deleteBarber(@PathVariable Long id){
        return ResponseEntity.ok(barberService.delete(id));
    }
    // berber listesini getir
}
