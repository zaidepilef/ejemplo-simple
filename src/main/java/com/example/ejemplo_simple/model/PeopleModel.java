package com.example.ejemplo_simple.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "People") // Map to MongoDB collection
public class PeopleModel {

    @Id // Identificador principal
    private String id;
    private String user;
    private String email;
    private String name;
    private String lastname;
    private String phone;
    private String password;
    private String status;

    // Constructores
    public PeopleModel() {
    }

    public PeopleModel(String id, String user, String email, String name, String lastname, String phone,
            String password, String status) {
        this.id = id;
        this.user = user;
        this.email = email;
        this.name = name;
        this.lastname = lastname;
        this.phone = phone;
        this.password = password;
        this.status = status;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "People{" +
                "id='" + id + '\'' +
                ", user='" + user + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", status='" + status + '\'' +
                '}';
    }

}
