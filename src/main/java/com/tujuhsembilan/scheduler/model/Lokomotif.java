package com.tujuhsembilan.scheduler.model;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "lokomotif")
@EntityListeners(AuditingEntityListener.class)
public class Lokomotif {
    
    @Id
    private String _id;

    @Column
    private String kodeLoko;

    @Column
    private String namaLoko;

    @Column
    private String dimensiLoko;

    @Column
    private String status;

    @Column(columnDefinition = "TIMESTAMP")
    private LocalDateTime createdDate;

    @ManyToOne
    @JoinColumn(name = "summary_id", nullable = true)
    private Summary summary;

}
