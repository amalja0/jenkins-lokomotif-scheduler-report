package com.tujuhsembilan.scheduler.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.dto.LokomotifDto;
import com.tujuhsembilan.scheduler.repository.LokomotifJpaRepository;
import com.tujuhsembilan.scheduler.service.LokomotifService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/lokomotifs")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LokomotifController {
    
    private final ModelMapper modelMapper;

    private final LokomotifService lokomotifService;

    private final LokomotifJpaRepository lokomotifJpaRepository;

    @GetMapping("/")
    public ResponseEntity<List<LokomotifDto>> getAllLokomotif(@RequestParam int page) {

        LocalDateTime yesterday = LocalDateTime.now().minusDays(3);
        LocalDateTime today = LocalDateTime.now();

        Pageable pageRequest = PageRequest.of(page, Integer.MAX_VALUE);
        
        List<Lokomotif> data = lokomotifJpaRepository.findAllByCreatedDateBetween(yesterday, today, pageRequest);

        List<LokomotifDto> dtos = data
            .stream()
            .map(element -> modelMapper.map(element, LokomotifDto.class))
            .collect(Collectors.toList());
        
        return ResponseEntity.status(HttpStatus.OK).body(dtos);
    }

    @PostMapping("/")
    @Scheduled(fixedRate = 3600000)
    public ResponseEntity<List<LokomotifDto>> saveLokomotifCreatedYesterday() {

        List<Lokomotif> data = lokomotifService.getLokomotifCreatedYesterday();

        List<Lokomotif> savedData = lokomotifJpaRepository.saveAll(data);

        List<LokomotifDto> dtos = savedData
            .stream()
            .map(element -> modelMapper.map(element, LokomotifDto.class))
            .collect(Collectors.toList());
        
        return ResponseEntity.status(HttpStatus.CREATED).body(dtos);

    }

}
