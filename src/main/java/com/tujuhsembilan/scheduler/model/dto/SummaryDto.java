package com.tujuhsembilan.scheduler.model.dto;

import java.time.LocalDateTime;
import java.util.List;

import com.tujuhsembilan.scheduler.model.Lokomotif;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SummaryDto {
    
    private Integer id;
    private Integer totalLokomotif;
    private LocalDateTime createdDate;
    private List<Lokomotif> lokomotifs;

    @Override
    public String toString() {
        return "Report created at " + createdDate.toLocalDate().toString() + "\r\n" + "Total of lokomotifs generated into database are: " + totalLokomotif.toString();
    }

}
