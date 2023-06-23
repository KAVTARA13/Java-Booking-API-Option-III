package com.exam.services;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.HotelDto;

public interface IHotelService {
    ApiResponse add(HotelDto dto);
    ApiResponse getAll();

    ApiResponse getFreeRooms(Long id, DateDto dto);

    ApiResponse sales();
}
