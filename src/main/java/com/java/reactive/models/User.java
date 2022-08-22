package com.java.reactive.models;

import lombok.Data;

@Data
public class User {
    private String name;
    private String username;
    private String email;
    private String phone;
    private String website;
    private String address;

    public User() {
    }

    public User(String x, String s) {
    }

    // https://jsonplaceholder.typicode.com/todos
    // https://jsonplaceholder.typicode.com/posts
    // https://jsonplaceholder.typicode.com/posts/1
}
