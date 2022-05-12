package com.example.src.model;

import org.springframework.context.annotation.ComponentScan;

public class User {
    public User() {
    }

    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }

    public User(String name, String email, int id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public User(String name, String email, Dog dog) {
        this.name = name;
        this.email = email;
        this.dog = dog;
    }

    private String name;
    private String email;
    private  int id;

    private  Dog dog;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(String name) {
        this.name = name;
    }
}
