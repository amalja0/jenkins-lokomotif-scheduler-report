package com.tujuhsembilan.scheduler.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.tujuhsembilan.scheduler.model.LokomotifDocument;
import java.util.List;


@EnableMongoRepositories
public interface LokomotifMongoRepository extends MongoRepository<LokomotifDocument, String> {
    List<LokomotifDocument> findByCreatedDateBetween(String createdDate, String today);
}
