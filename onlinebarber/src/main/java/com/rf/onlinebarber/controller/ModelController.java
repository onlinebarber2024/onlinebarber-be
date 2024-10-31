package com.rf.onlinebarber.controller;

import com.rf.onlinebarber.config.ApiPaths;
import com.rf.onlinebarber.dto.AddModelRequest;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.ModelDto;
import com.rf.onlinebarber.service.ModelService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(ApiPaths.MODEL)
public class ModelController {
    private final ModelService service;

    public ModelController(ModelService service) {
        this.service = service;
    }
    // model ekle
    @PostMapping(ApiPaths.ADD_MODEL)
    ResponseEntity<ApiResponse<Void>> addModel(@Valid @RequestBody AddModelRequest request, @PathVariable Long barberId){
        return ResponseEntity.ok(service.addModel(request,barberId));
    }
    // model sil
    @DeleteMapping(ApiPaths.DELETE)
    ResponseEntity<ApiResponse<Void>> delete(@PathVariable Long id){
        return ResponseEntity.ok(service.delete(id));
    }
    // model güncelle
    // mağazaya ait modelleri listele
    @GetMapping(ApiPaths.MODEL_BY_BARBER)
    ApiResponse<List<ModelDto>> getModelsByBarber(@PathVariable Long barberId){
        return ApiResponse.ok(barberId+" numaralı berbere ait model listesi",service.getModelsByBarber(barberId));
    }
    // tüm modelleri listele
    @GetMapping(ApiPaths.LIST)
    ApiResponse<List<ModelDto>> getModels(){
        return ApiResponse.ok("model listesi",service.getModels());
    }
}
