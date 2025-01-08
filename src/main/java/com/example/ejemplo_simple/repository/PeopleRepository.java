package com.example.ejemplo_simple.repository;

import com.example.ejemplo_simple.model.PeopleModel;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

@Repository
public interface PeopleRepository extends MongoRepository<PeopleModel, String> {

    // Consulta personalizada para buscar personas por nombre
    List<PeopleModel> findByName(String name);

    // Consulta personalizada para buscar personas por rango de edad
    List<PeopleModel> findByAgeBetween(int minAge, int maxAge);

    // Consulta personalizada para buscar personas por hobbies
    List<PeopleModel> findByHobbiesContaining(String hobby);
}
