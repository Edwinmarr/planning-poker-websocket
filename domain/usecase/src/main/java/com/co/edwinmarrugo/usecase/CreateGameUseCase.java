package com.co.edwinmarrugo.usecase;

import com.co.edwinmarrugo.domain.entities.Admin;
import com.co.edwinmarrugo.domain.entities.Room;
import com.co.edwinmarrugo.ports.RoomRepository;

import java.util.UUID;

public class CreateGameUseCase {
    private final RoomRepository roomRepository;

    public CreateGameUseCase(RoomRepository roomRepository) {
        this.roomRepository = roomRepository;
    }

    public Room execute(String roomName, Admin admin) {
        // Validaciones básicas
        if (roomName == null || roomName.isBlank()) {
            throw new IllegalArgumentException("El nombre de la sala no puede estar vacío.");
        }
        if (admin == null) {
            throw new IllegalArgumentException("El administrador no puede ser nulo.");
        }

        // Crear la sala
        Room room = new Room(
                UUID.randomUUID().toString(), // Generar ID único
                roomName,
                admin
        );

        // Persistir la sala
        roomRepository.save(room);

        return room;
    }
}