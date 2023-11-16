package com.tujuhsembilan.scheduler.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.LokomotifDocument;
import com.tujuhsembilan.scheduler.repository.LokomotifJpaRepository;
import com.tujuhsembilan.scheduler.repository.LokomotifMongoRepository;
import com.tujuhsembilan.scheduler.utils.LocalDateTimeToStringConverter;
import com.tujuhsembilan.scheduler.utils.StringToLocalDateTimeConverter;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class LokomotifService {
    
    private final ModelMapper modelMapper;
    
    private final LokomotifMongoRepository lokomotifMongoRepository;

    private final LokomotifJpaRepository lokomotifJpaRepository;

    public List<Lokomotif> getAllLokomotif() {

        modelMapper.addConverter(new StringToLocalDateTimeConverter());

        List<LokomotifDocument> data = lokomotifMongoRepository.findAll();

        List<Lokomotif> lokomotifs = data
            .stream()
            .map(element -> modelMapper.map(element, Lokomotif.class))
            .collect(Collectors.toList());
        
        return lokomotifs;

    }

    public List<Lokomotif> getLokomotifCreatedYesterday() {

        LocalDateTimeToStringConverter converter = new LocalDateTimeToStringConverter();

        modelMapper.addConverter(new StringToLocalDateTimeConverter());

        LocalDateTime yesterday = LocalDateTime.now().minusDays(2);
        LocalDateTime today = LocalDateTime.now();
        String yesterdayDate = converter.convert(yesterday);
        String todayDate = converter.convert(today);

        List<LokomotifDocument> data = lokomotifMongoRepository.findByCreatedDateBetween(yesterdayDate, todayDate);

        List<Lokomotif> lokomotifs = data
            .stream()
            .map(element -> modelMapper.map(element, Lokomotif.class))
            .collect(Collectors.toList());
        
        return lokomotifs;

    }

}
