package com.co.edwinmarrugo.usecase;

import com.co.edwinmarrugo.domain.entities.Admin;
import com.co.edwinmarrugo.domain.entities.Room;
import com.co.edwinmarrugo.domain.enums.Role;
import com.co.edwinmarrugo.ports.RoomRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class CreateGameUseCaseTest {

    @Mock
    private RoomRepository roomRepository;
    @InjectMocks
    private CreateGameUseCase createGameUseCase;


    @Test
    void itShouldCreateRoomSuccessfullyWhenValidDataIsProvided() {
        // Given
        String roomName = "Planning Poker";
        Admin admin = new Admin("123", "Admin User", Role.PLAYER);

        // When
        Room result = createGameUseCase.execute(roomName, admin);

        // Then
        assertNotNull(result.getId());
        assertEquals(roomName, result.getName());
        assertEquals(admin, result.getAdmin());
        assertNull(result.getParticipants());
        verify(roomRepository, times(1)).save(result);
    }

    @Test
    void itShouldThrowExceptionWhenRoomNameIsNull() {
        // Given
        Admin admin = new Admin("123", "Admin User", Role.PLAYER);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> createGameUseCase.execute(null, admin)
        );
        assertEquals("El nombre de la sala no puede estar vacío.", exception.getMessage());
    }

    @Test
    void itShouldThrowExceptionWhenRoomNameIsEmpty() {
        // Given
        Admin admin = new Admin("123", "Admin User", Role.PLAYER);

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> createGameUseCase.execute("   ", admin)
        );
        assertEquals("El nombre de la sala no puede estar vacío.", exception.getMessage());
    }

    @Test
    void itShouldThrowExceptionWhenAdminIsNull() {
        // Given
        String roomName = "Planning Poker";

        // When / Then
        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class,
                () -> createGameUseCase.execute(roomName, null)
        );
        assertEquals("El administrador no puede ser nulo.", exception.getMessage());
    }

    @Test
    void itShouldSaveRoomInRepository() {
        // Given
        String roomName = "Planning Poker";
        Admin admin = new Admin("123", "Admin User", Role.PLAYER);

        // When
        createGameUseCase.execute(roomName, admin);

        // Then
        ArgumentCaptor<Room> roomCaptor = ArgumentCaptor.forClass(Room.class);
        verify(roomRepository).save(roomCaptor.capture());

        Room capturedRoom = roomCaptor.getValue();
        assertEquals(roomName, capturedRoom.getName());
        assertEquals(admin, capturedRoom.getAdmin());
    }


}