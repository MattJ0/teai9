package com.mattjohnson.teai9.service;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import com.mattjohnson.teai9.aspect.LogExecutionTime;
import com.mattjohnson.teai9.model.MockObjectJpa;
import com.mattjohnson.teai9.model.MockObjectMongo;
import com.mattjohnson.teai9.model.MockObjectRedis;
import com.mattjohnson.teai9.repository.JpaRepo;
import com.mattjohnson.teai9.repository.MongoRepo;
import com.mattjohnson.teai9.repository.RedisRepo;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Service
@Getter
@Slf4j
public class DbService {

    private static final String MOCK_DATA_URI = "/home/matt/Java/java_as/teai9/src/main/resources/MOCK_DATA.csv";
    private static final String MOCK_DATA_URI2 = "/home/matt/Java/java_as/teai9/src/main/resources/MOCK_DATA2.csv";

    private JpaRepo jpaRepo;
    private MongoRepo mongoRepo;
    private RedisRepo redisRepo;

    private List<MockObjectJpa> mockObjectsJpa;
    private List<MockObjectMongo> mockObjectsMongo;
    private List<MockObjectRedis> mockObjectsRedis;

    @Autowired
    public DbService(JpaRepo jpaRepo, MongoRepo mongoRepo, RedisRepo redisRepo) {
        this.jpaRepo = jpaRepo;
        this.mongoRepo = mongoRepo;
        this.redisRepo = redisRepo;

    }

    @LogExecutionTime
    public void readCsvJpa() throws IOException {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(MockObjectJpa.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();
        try (MappingIterator<MockObjectJpa> userIter = new CsvMapper().readerFor(MockObjectJpa.class)
                .with(schema).readValues(new File(MOCK_DATA_URI))) {

            mockObjectsJpa = userIter.readAll();
        }
    }

    @LogExecutionTime
    public void readCsvMongo() throws IOException {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(MockObjectMongo.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();
        try (MappingIterator<MockObjectMongo> userIter = new CsvMapper().readerFor(MockObjectMongo.class)
                .with(schema).readValues(new File(MOCK_DATA_URI))) {

            mockObjectsMongo = userIter.readAll();
        }
    }

    @LogExecutionTime
    public void readCsvRedis() throws IOException {

        CsvMapper mapper = new CsvMapper();
        CsvSchema schema = mapper.schemaFor(MockObjectRedis.class)
                .withSkipFirstDataRow(true)
                .withColumnSeparator(',').withoutQuoteChar();
        try (MappingIterator<MockObjectRedis> userIter = new CsvMapper().readerFor(MockObjectRedis.class)
                .with(schema).readValues(new File(MOCK_DATA_URI))) {

            mockObjectsRedis = userIter.readAll();
        }
    }


    @LogExecutionTime
    public void saveJpa() {
        jpaRepo.saveAll(mockObjectsJpa);
    }

    @LogExecutionTime
    public void findJpa() {
        jpaRepo.findAll();
    }

    @LogExecutionTime
    public void deleteJpa() {
        jpaRepo.deleteAll();
    }

    @LogExecutionTime
    public void saveMongo() {
        mongoRepo.saveAll(mockObjectsMongo);
    }

    @LogExecutionTime
    public void findMongo() {
        mongoRepo.findAll();
    }

    @LogExecutionTime
    public void deleteMongo() {
        mongoRepo.deleteAll();
    }

    @LogExecutionTime
    public void saveRedis() {
        redisRepo.saveAll(mockObjectsRedis);
    }

    @LogExecutionTime
    public void findRedis() {
        redisRepo.findAll();
    }

    @LogExecutionTime
    public void deleteRedis() {
        redisRepo.deleteAll();
    }

}
