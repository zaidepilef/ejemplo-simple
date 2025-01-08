package com.example.ejemplo_simple.service;

import com.example.ejemplo_simple.model.PeopleModel;
import com.example.ejemplo_simple.repository.PeopleRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<PeopleModel> getAllPeople() {
        return peopleRepository.findAll();
    }

    public Optional<PeopleModel> getPersonById(String id) {
        return peopleRepository.findById(id);
    }

    public PeopleModel createPerson(PeopleModel person) {
        return peopleRepository.save(person);
    }

    public PeopleModel updatePerson(String id, PeopleModel updatedPerson) {
        return peopleRepository.findById(id)
                .map(person -> {
                    person.setUser(updatedPerson.getUser());
                    person.setEmail(updatedPerson.getEmail());
                    person.setName(updatedPerson.getName());
                    person.setLastname(updatedPerson.getLastname());
                    person.setPhone(updatedPerson.getPhone());
                    person.setPassword(updatedPerson.getPassword());
                    person.setStatus(updatedPerson.getStatus());
                    return peopleRepository.save(person);
                })
                .orElseThrow(() -> new RuntimeException("Person not found with id " + id));
    }

   

    public List<PeopleModel> getPeopleByName(String name) {
        return peopleRepository.findByName(name);
    }

    public List<PeopleModel> getPeopleByAgeRange(int minAge, int maxAge) {
        return peopleRepository.findByAgeBetween(minAge, maxAge);
    }

    public List<PeopleModel> getPeopleByHobby(String hobby) {
        return peopleRepository.findByHobbiesContaining(hobby);
    }

    public void deletePerson(String id) {
        peopleRepository.deleteById(id);
    }
}
