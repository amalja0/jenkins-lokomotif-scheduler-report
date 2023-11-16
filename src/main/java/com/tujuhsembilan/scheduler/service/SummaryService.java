package com.tujuhsembilan.scheduler.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tujuhsembilan.scheduler.model.Lokomotif;
import com.tujuhsembilan.scheduler.model.Summary;
import com.tujuhsembilan.scheduler.repository.SummaryRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class SummaryService {

    private final SummaryRepository summaryRepository;

    public Summary createSummary(List<Lokomotif> lokomotifs) {
        var dailySummary = Summary
            .builder()
            .lokomotifs(lokomotifs)
            .build();
        
            return summaryRepository.save(dailySummary);
    }
}
