package com.mattjohnson.teai9.repository;

import com.mattjohnson.teai9.model.MockObjectJpa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaRepo extends JpaRepository<MockObjectJpa, Long> {
}
