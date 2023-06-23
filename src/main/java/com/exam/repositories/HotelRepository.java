package com.exam.repositories;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.HotelDto;
import com.exam.entities.Hotel;
import com.exam.entities.Reservation;
import com.exam.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface HotelRepository extends JpaRepository<Hotel, Long>  {

    @Query("SELECT u FROM Hotel u")
    List<Hotel> getAll();
    @Query("SELECT u.name FROM Hotel u where u.id=:#{#id}")
    String getHotelNameById(Long id);


}
