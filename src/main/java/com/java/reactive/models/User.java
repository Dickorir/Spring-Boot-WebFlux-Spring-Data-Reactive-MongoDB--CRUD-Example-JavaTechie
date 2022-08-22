package com.java.reactive.models;

import lombok.Data;

@Data
public class User {
    private String id;
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private Address address;
    private Company company;

    public User() {
    }

    public User(String x, String s) {
    }

}
