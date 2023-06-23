package com.exam.repositories;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.RoomDto;
import com.exam.entities.Reservation;
import com.exam.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RoomRepository extends JpaRepository<Room, Long> {

    @Query("SELECT u FROM Room u")
    List<Room> getAll();

    List<Room> getRoomsByIdNotIn(List<Long> id);
    List<Room> getRoomsByHotelIdAndIdNotIn(Long hotelId,List<Long> id);

}
