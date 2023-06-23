package com.exam.services;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.RoomDto;

public interface IRoomService {
    ApiResponse add(RoomDto dto);
    ApiResponse getAll();
}
