package com.exam.controllers;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.HotelDto;
import com.exam.dtos.RoomDto;
import com.exam.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/room")
public class RoomController {
    private final IRoomService roomService;
    @Autowired
    public RoomController(IRoomService roomService) {
        this.roomService = roomService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addRoom(@RequestBody RoomDto dto){
        return this.roomService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getRooms(){
        return this.roomService.getAll();
    }

}
