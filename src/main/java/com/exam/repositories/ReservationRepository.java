package com.exam.repositories;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.ReservationDto;
import com.exam.entities.Reservation;
import com.exam.entities.Room;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {

    @Query("SELECT u FROM Reservation u")
    List<Reservation> getAll();
    @Query("SELECT u.room.hotel.id FROM Reservation u")
    Set<Long> getAllHotelId();
    @Query("select count (*) from Reservation u where u.room.hotel.id = :#{#id}")
    int getCountReservationByHotelId(Long id);

    @Query("select sum (u.room.oneNightPrice) from Reservation u where u.room.hotel.id = :#{#id}")
    Long getOneNightPriceReservationByHotelId(Long id);

    @Query("SELECT SUM(DATEDIFF(u.to,u.from)) AS DateDiff FROM Reservation u WHERE u.room.hotel.id = :id")
    Long getDaysReservationByHotelId(@Param("id") Long id);

    @Query("select u.room from Reservation u where :#{#date.from} >= u.from AND :#{#date.to} <= u.to")
    List<Room> getBusyRooms(DateDto date);

}
