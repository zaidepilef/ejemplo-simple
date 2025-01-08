package com.example.ejemplo_simple.business;

import com.example.ejemplo_simple.model.PeopleModel;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class PeopleBusiness {

    public void validatePerson(PeopleModel person) {
        // Agrega aquí la lógica de validación de negocio
        
        // Otras validaciones de negocio...
    }

    public void processPeopleList(List<PeopleModel> people) {
        // Agrega aquí la lógica de procesamiento de negocio
        // Por ejemplo, filtrar, ordenar, etc.
    }
}