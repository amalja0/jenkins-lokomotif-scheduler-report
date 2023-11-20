package com.tujuhsembilan.scheduler.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EntityListeners;
import jakarta.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import org.springframework.data.mongodb.core.mapping.Document;

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
@Document(collection = "lokomotifs")
@EntityListeners(AuditingEntityListener.class)
public class LokomotifDocument {
    
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

    @Column
    private String createdDate;

}
