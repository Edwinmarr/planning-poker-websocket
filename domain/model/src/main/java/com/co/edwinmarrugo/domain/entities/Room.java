package com.co.edwinmarrugo.domain.entities;

import com.co.edwinmarrugo.domain.enums.GameStatus;

import java.util.List;

public class Room {
    private String id;
    private String name;
    private Admin admin;
    private List<User> participants;
    private GameStatus status;

    public Room(String id, String name, Admin admin) {
        this.id = id;
        this.name = name;
        this.admin = admin;
        this.status = GameStatus.CREATED;
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

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<User> getParticipants() {
        return participants;
    }

    public void setParticipants(List<User> participants) {
        this.participants = participants;
    }

    public GameStatus getStatus() {
        return status;
    }

    public void setStatus(GameStatus status) {
        this.status = status;
    }

}
