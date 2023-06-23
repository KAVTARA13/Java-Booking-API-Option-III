package com.exam.services;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.ReservationDto;

import java.util.Date;

public interface IReservationService {
    ApiResponse add(ReservationDto dto);
    ApiResponse getAll();

    ApiResponse getFreeRooms(DateDto dto);

    ApiResponse getBusyRooms(DateDto date);
}
