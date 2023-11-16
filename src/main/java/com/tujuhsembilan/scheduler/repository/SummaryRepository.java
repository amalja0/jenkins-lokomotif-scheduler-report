package com.tujuhsembilan.scheduler.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tujuhsembilan.scheduler.model.Summary;

@Repository
public interface SummaryRepository extends JpaRepository<Summary, Integer> {
    
}
