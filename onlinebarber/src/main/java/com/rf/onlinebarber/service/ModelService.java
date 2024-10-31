package com.rf.onlinebarber.service;

import com.rf.onlinebarber.dto.AddModelRequest;
import com.rf.onlinebarber.dto.ApiResponse;
import com.rf.onlinebarber.dto.ModelDto;
import com.rf.onlinebarber.dto.converter.DtoConverter;
import com.rf.onlinebarber.exception.ModelNotFoundException;
import com.rf.onlinebarber.exception.UserNotFoundException;
import com.rf.onlinebarber.model.Barber;
import com.rf.onlinebarber.model.ShavingModel;
import com.rf.onlinebarber.repository.ModelRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ModelService {
    private final ModelRepository repository;
    private final BarberService barberService;
    private final DtoConverter converter;
    public ApiResponse<Void> addModel(AddModelRequest request, Long barberId) {
        Barber barber=barberService.findById(barberId).orElseThrow(UserNotFoundException::new);
        ShavingModel model=ShavingModel.builder().name(request.getName()).price(request.getPrice()).image(request.getImage()).barber(barber).build();
        repository.save(model);
        return ApiResponse.ok("Model basari ile kayit edildi");
    }
    public ApiResponse<Void> delete(Long id) {
        repository.deleteById(id);
        return ApiResponse.ok("Model Silindi");
    }

    public List<ModelDto> getModelsByBarber(Long barberId) {
        List<ShavingModel> models=repository.findByBarberId(barberId);
        return models.stream().map(converter::convertModel).collect(Collectors.toList());
    }
    public List<ModelDto> getModels() {
        return repository.findAll().stream().map(converter::convertModel).collect(Collectors.toList());
    }
    protected ShavingModel findById(Long id){
        return repository.findById(id).orElseThrow(ModelNotFoundException::new);
    }
}
