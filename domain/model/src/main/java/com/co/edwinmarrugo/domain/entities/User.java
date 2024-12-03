package com.co.edwinmarrugo.domain.entities;

import com.co.edwinmarrugo.domain.enums.Role;

public class User {
    private String id;
    private String name;
    private Role role;
    public User(String id, String name, Role role) {
        this.id = id;
        this.name = name;
        this.role = role;
    }

    // Getters y Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}
