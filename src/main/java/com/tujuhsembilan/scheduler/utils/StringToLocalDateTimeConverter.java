package com.tujuhsembilan.scheduler.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.modelmapper.AbstractConverter;

public class StringToLocalDateTimeConverter extends AbstractConverter<String, LocalDateTime> {
    
    @Override
    protected LocalDateTime convert(String source) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
        
        return LocalDateTime.parse(source, formatter);
    }
}
