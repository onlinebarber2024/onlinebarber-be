package com.rf.onlinebarber.service;

import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.CreateBarberRequest;
import com.rf.onlinebarber.model.Barber;
import com.rf.onlinebarber.model.Role;
import com.rf.onlinebarber.repository.BarberRepository;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.rf.onlinebarber.dto.ApiResponse.*;

@Service
@RequiredArgsConstructor
public class BarberService {
    private final BarberRepository barberRepository;


    // kayıt
    public ApiResponse<Void> createBarber(CreateBarberRequest request) {
        Barber barber= Barber.builder().email(request.getEmail()).name(request.getName()).password(request.getPassword()).phoneNumber(request.getPhoneNumber()).role(Role.ROLE_BARBER).build();
        barberRepository.save(barber);
        return ApiResponse.ok("Berber kaydı başarılı");
    }
    // sil
    public ApiResponse<Void> delete(Long id){
        barberRepository.deleteById(id);
        return ApiResponse.ok("Berber kaydi silindi");
    }
    // güncelle
}
