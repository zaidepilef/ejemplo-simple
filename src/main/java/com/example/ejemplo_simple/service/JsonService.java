package com.example.ejemplo_simple.service;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.example.ejemplo_simple.model.UserModel;
import com.fasterxml.jackson.core.type.TypeReference;

@Service
public class JsonService {

    // Método para leer el JSON como una cadena de texto
    public String getJsonAsString(String fileName) {
        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Archivo JSON no encontrado: " + fileName);
            }
            return new String(inputStream.readAllBytes());
        } catch (IOException e) {
            throw new RuntimeException("Error al leer el archivo JSON.", e);
        }
    }

    // Método para convertir el JSON en una lista de objetos User
    public List<UserModel> getUsersFromJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();
        try (InputStream inputStream = getClass().getResourceAsStream("/" + fileName)) {
            if (inputStream == null) {
                throw new RuntimeException("Archivo JSON no encontrado: " + fileName);
            }
            return objectMapper.readValue(inputStream, new TypeReference<List<UserModel>>() {});
        } catch (IOException e) {
            throw new RuntimeException("Error al convertir el archivo JSON en objetos.", e);
        }
    }

}
