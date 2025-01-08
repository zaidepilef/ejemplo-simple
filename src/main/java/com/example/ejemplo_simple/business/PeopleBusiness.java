package com.example.ejemplo_simple.business;

import com.example.ejemplo_simple.model.PeopleModel;
import com.example.ejemplo_simple.service.PeopleService;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;

@Component
public class PeopleBusiness {

    private final PeopleService peopleService;

    public PeopleBusiness(PeopleService peopleService) {
        this.peopleService = peopleService;
    }

     // Obtener todas las personas
     public List<PeopleModel> getAllPeople() {
        return peopleService.getAllPeople();
    }

    // Obtener una persona por su ID con validación
    public Optional<PeopleModel> getPersonById(String id) {
        if (id == null || id.isEmpty()) {
            throw new IllegalArgumentException("El ID no puede ser nulo o vacío");
        }
        return peopleService.getPersonById(id);
    }

    // Crear una nueva persona con validaciones
    public PeopleModel createPerson(PeopleModel person) {
        if (person.getEmail() == null || !person.getEmail().contains("@")) {
            throw new IllegalArgumentException("El correo electrónico no es válido");
        }
        if (person.getPassword().length() < 8) {
            throw new IllegalArgumentException("La contraseña debe tener al menos 8 caracteres");
        }
        return peopleService.createPerson(person);
    }

    // Actualizar una persona con reglas de negocio adicionales
    public PeopleModel updatePerson(String id, PeopleModel updatedPerson) {
        if (updatedPerson.getStatus().equalsIgnoreCase("banned")) {
            throw new IllegalStateException("No se puede actualizar un usuario con estado 'banned'");
        }
        return peopleService.updatePerson(id, updatedPerson);
    }

    // Eliminar una persona
    public void deletePerson(String id) {
        peopleService.deletePerson(id);
    }

    // Buscar personas por estado con lógica adicional
    public List<PeopleModel> getPeopleByStatus(String status) {
        if (status.equalsIgnoreCase("inactive")) {
            throw new IllegalArgumentException("No se permite buscar usuarios inactivos");
        }
        return peopleService.getPeopleByStatus(status);
    }
    
  
}