package com.tujuhsembilan.scheduler.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.dto.SummaryDto;
import com.tujuhsembilan.scheduler.repository.LokomotifJpaRepository;
import com.tujuhsembilan.scheduler.service.SummaryService;
import com.tujuhsembilan.scheduler.utils.LocalDateTimeToStringConverter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/summary")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SummaryController {
    
    private final ModelMapper modelMapper;

    private final LokomotifJpaRepository lokomotifJpaRepository;

    private final SummaryService summaryService;

    @ResponseBody
    @PostMapping("/")
    public  ResponseEntity<SummaryDto> createSummary() {
        
        LocalDateTime yesterday = LocalDateTime.now().minusDays(3);
        LocalDateTime today = LocalDateTime.now();
        
        List<Lokomotif> lokomotifs = lokomotifJpaRepository.findAllByCreatedDateBetween(yesterday, today);

        var savedSummary = summaryService.createSummary(lokomotifs);

        var dto = modelMapper.map(savedSummary, SummaryDto.class);

        return ResponseEntity.status(HttpStatus.CREATED).body(dto);
    }

}
