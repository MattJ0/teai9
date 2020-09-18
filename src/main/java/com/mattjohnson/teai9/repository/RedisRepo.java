package com.mattjohnson.teai9.repository;

import com.mattjohnson.teai9.model.MockObjectRedis;
import org.springframework.data.keyvalue.repository.KeyValueRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RedisRepo extends KeyValueRepository<MockObjectRedis, String> {
}

