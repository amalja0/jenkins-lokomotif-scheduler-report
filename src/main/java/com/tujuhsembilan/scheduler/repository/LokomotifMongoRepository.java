package com.tujuhsembilan.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tujuhsembilan.scheduler.model.Lokomotif;

@EnableMongoRepositories
public interface LokomotifMongoRepository extends MongoRepository<Lokomotif, String> {
    
}
