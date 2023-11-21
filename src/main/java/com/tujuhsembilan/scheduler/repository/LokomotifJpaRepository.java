package com.tujuhsembilan.scheduler.repository;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tujuhsembilan.scheduler.model.Lokomotif;

@Repository
public interface LokomotifJpaRepository extends JpaRepository<Lokomotif, String> {
    List<Lokomotif> findAllByCreatedDateBetween(LocalDateTime yesterday, LocalDateTime today, Pageable page);
    
}
