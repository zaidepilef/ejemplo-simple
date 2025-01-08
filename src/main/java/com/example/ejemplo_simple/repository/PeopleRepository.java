package com.example.ejemplo_simple.repository;

import com.example.ejemplo_simple.model.PeopleModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

@Repository
public interface PeopleRepository extends MongoRepository<PeopleModel, String> {
    List<PeopleModel> findByUser(String user);

    List<PeopleModel> findByStatus(String status);

    List<PeopleModel> findByEmail(String email);
}
