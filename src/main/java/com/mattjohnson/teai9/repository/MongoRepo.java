package com.mattjohnson.teai9.repository;

import com.mattjohnson.teai9.model.MockObjectMongo;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoRepo extends MongoRepository<MockObjectMongo, String> {
}
