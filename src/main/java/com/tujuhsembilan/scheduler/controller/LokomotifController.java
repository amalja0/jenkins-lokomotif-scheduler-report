package com.tujuhsembilan.scheduler.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.RepresentationModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.dto.LokomotifDto;
import com.tujuhsembilan.scheduler.repository.LokomotifMongoRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lokomotifs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LokomotifController {
    
    private final ModelMapper modelMapper;

    private final LokomotifMongoRepository lokomotifRepository;

    @ResponseBody
    @GetMapping("/")
    public ResponseEntity<List<LokomotifDto>> getAllLokomotif() {
        
        List<Lokomotif> data = lokomotifRepository.findAll();

        List<LokomotifDto> dtos = data
            .stream()
            .map(element -> modelMapper.map(element, LokomotifDto.class))
            .collect(Collectors.toList());
        
        return ResponseEntity.status(HttpStatus.OK).body(dtos);

    }
}
