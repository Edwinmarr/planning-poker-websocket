package com.co.edwinmarrugo.ports;

import com.co.edwinmarrugo.domain.entities.Room;

public interface RoomRepository {
    void save(Room room);

    Room findById(String roomId);
}
