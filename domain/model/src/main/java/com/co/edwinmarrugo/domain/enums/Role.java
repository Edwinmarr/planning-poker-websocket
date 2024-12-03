package com.co.edwinmarrugo.domain.enums;

public enum Role {
    PLAYER("Player"),
    SPECTATOR("Spectator");

    private final String description;

    // Constructor
    Role(String description) {
        this.description = description;
    }

    // Getter para obtener el valor asociado
    public String getDescription() {
        return description;
    }
}
