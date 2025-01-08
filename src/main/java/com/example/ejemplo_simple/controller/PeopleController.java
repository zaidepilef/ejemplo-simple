package com.example.ejemplo_simple.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo_simple.business.PeopleBusiness;
import com.example.ejemplo_simple.model.PeopleModel;
import com.example.ejemplo_simple.service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {

    private final PeopleBusiness peopleBusiness;

    public PeopleController(PeopleBusiness peopleBusiness) {
        this.peopleBusiness = peopleBusiness;
    }

    @GetMapping
    public List<PeopleModel> getAllPeople() {
        return peopleBusiness.getAllPeople();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleModel> getPersonById(@PathVariable String id) {
        return peopleBusiness.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public PeopleModel createPerson(@RequestBody PeopleModel person) {
        return peopleBusiness.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleModel> updatePerson(@PathVariable String id, @RequestBody PeopleModel updatedPerson) {
        try {
            return ResponseEntity.ok(peopleBusiness.updatePerson(id, updatedPerson));
        } catch (IllegalStateException | IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(null);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        peopleBusiness.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/status")
    public List<PeopleModel> searchByStatus(@RequestParam String status) {
        try {
            return peopleBusiness.getPeopleByStatus(status);
        } catch (IllegalArgumentException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

}
