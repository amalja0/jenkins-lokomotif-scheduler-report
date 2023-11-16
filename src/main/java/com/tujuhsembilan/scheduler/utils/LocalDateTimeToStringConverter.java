package com.tujuhsembilan.scheduler.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;

public class LocalDateTimeToStringConverter extends AbstractConverter<LocalDateTime, String> {
    
    @Override
    public String convert(LocalDateTime source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
        
        return source.format(formatter);
    }

}
