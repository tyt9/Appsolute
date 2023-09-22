package com.solution.appsolute.repository;

import com.solution.appsolute.dto.approval.Data;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Repository
public class DataEntityManager {

    @PersistenceContext
    EntityManager entityManager;

    @Transactional
    public Data findById(Long id) {
        Data data = entityManager.find(Data.class, id);
        return data;
    }

    @Transactional
    public void insert(Data data) {
        entityManager.persist(data);
    }

}
