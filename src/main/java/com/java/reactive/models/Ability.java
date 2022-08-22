package com.java.reactive.models;

import lombok.Data;

@Data
public class Ability {

    private String ability;
    private String is_hidden;
    private String slot;

    public Ability() {
    }
}
