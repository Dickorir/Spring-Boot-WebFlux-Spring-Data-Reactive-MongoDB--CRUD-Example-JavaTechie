package com.java.reactive.models;

import java.util.List;

public class AbilitiesResponse {
    private List<Ability>  abilities;

    public AbilitiesResponse(List<Ability> abilities) {
        this.abilities = abilities;
    }

    public List<Ability> getAbilities() {
        return abilities;
    }

    public void setAbilities(List<Ability> abilities) {
        this.abilities = abilities;
    }
}
