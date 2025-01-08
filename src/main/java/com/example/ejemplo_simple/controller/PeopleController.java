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

import com.example.ejemplo_simple.model.PeopleModel;
import com.example.ejemplo_simple.service.PeopleService;

@RestController
@RequestMapping("/api/people")
public class PeopleController {


    private final PeopleService peopleService;

    public PeopleController(PeopleService peopleService) {
        this.peopleService = peopleService;
 
 
    }
    @GetMapping("/all")
    public List<PeopleModel> getAllPeople() {
        return peopleService.getAllPeople();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PeopleModel> getPersonById(@PathVariable String id) {
        return peopleService.getPersonById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }


    @PostMapping
    public PeopleModel createPerson(@RequestBody PeopleModel person) {
        return peopleService.createPerson(person);
    }

    @PutMapping("/{id}")
    public ResponseEntity<PeopleModel> updatePerson(@PathVariable String id, @RequestBody PeopleModel updatedPerson) {
        try {
            return ResponseEntity.ok(peopleService.updatePerson(id, updatedPerson));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePerson(@PathVariable String id) {
        peopleService.deletePerson(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/name")
    public List<PeopleModel> searchByName(@RequestParam String name) {
        return peopleService.getPeopleByName(name);
    }

    @GetMapping("/search/age")
    public List<PeopleModel> searchByAgeRange(@RequestParam int minAge, @RequestParam int maxAge) {
        return peopleService.getPeopleByAgeRange(minAge, maxAge);
    }

    @GetMapping("/search/hobby")
    public List<PeopleModel> searchByHobby(@RequestParam String hobby) {
        return peopleService.getPeopleByHobby(hobby);
    }
   

}
