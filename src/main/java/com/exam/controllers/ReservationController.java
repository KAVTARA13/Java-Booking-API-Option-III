package com.exam.controllers;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.ReservationDto;
import com.exam.dtos.RoomDto;
import com.exam.services.IReservationService;
import com.exam.services.IRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/reservation")
public class ReservationController {
    private final IReservationService reservationService;
    @Autowired
    public ReservationController(IReservationService reservationService) {
        this.reservationService = reservationService;
    }
    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addReservation(@RequestBody ReservationDto dto){
        return this.reservationService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getReservations(){
        return this.reservationService.getAll();
    }
    @GetMapping(value = "/getBusyRooms")
    public ApiResponse getBusyRooms(@RequestBody DateDto dto){
        return this.reservationService.getBusyRooms(dto);
    }
    @GetMapping(value = "/getFreeRooms")
    public ApiResponse getFreeRooms(@RequestBody DateDto dto){
        return this.reservationService.getFreeRooms(dto);
    }
}
