package com.tujuhsembilan.scheduler.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

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
