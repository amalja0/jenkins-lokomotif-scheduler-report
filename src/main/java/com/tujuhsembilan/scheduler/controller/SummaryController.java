package com.tujuhsembilan.scheduler.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.dto.LokomotifDto;
import com.tujuhsembilan.scheduler.model.dto.SummaryDto;
import com.tujuhsembilan.scheduler.service.LokomotifService;
import com.tujuhsembilan.scheduler.service.SummaryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/summary")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SummaryController {
    
    private final ModelMapper modelMapper;

    private final LokomotifService lokomotifService;

    private final SummaryService summaryService;

    // @ResponseBody
    // @PostMapping("/")
    // public SummaryDto createSummary() {
        
    //     List<Lokomotif> lokomotifDtos = lokomotifService.getAllLokomotif();

    //     List<Lokomotif> lokomotifs = lokomotifDtos
    //         .stream()
    //         .map(element -> modelMapper.map(element, Lokomotif.class))
    //         .collect(Collectors.toList());
        
    //     var savedSummary = summaryService.createSummary(lokomotifs);

    //     var

    // }

}
