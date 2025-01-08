package com.example.ejemplo_simple.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ejemplo_simple.model.UserModel;
import com.example.ejemplo_simple.service.JsonService;



@RestController
@RequestMapping("/api/user")
public class UserController {
    

    private final JsonService jsonService;

    public UserController(JsonService jsonService) {
        this.jsonService = jsonService;
    }

    // Endpoint para devolver el JSON como texto
    @GetMapping("/raw")
    public ResponseEntity<String> getJsonAsString() {
        String jsonContent = jsonService.getJsonAsString("data.json");
        return ResponseEntity.ok(jsonContent);
    }

    // Endpoint para devolver el JSON como objetos Java
    @GetMapping("/users")
    public ResponseEntity<List<UserModel>> getUsersFromJson() {
        List<UserModel> users = jsonService.getUsersFromJson("data.json");
        return ResponseEntity.ok(users);
    }
}
