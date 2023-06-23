package com.exam.controllers;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.HotelDto;
import com.exam.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/hotel")
public class HotelController {
    private final IHotelService hotelService;

    @Autowired
    public HotelController(IHotelService hotelService) {
        this.hotelService = hotelService;
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ApiResponse addHotel(@RequestBody HotelDto dto){
        return this.hotelService.add(dto);
    }
    @GetMapping(value = "/getAll")
    public ApiResponse getHotel(){
        return this.hotelService.getAll();
    }
    @GetMapping(value = "/getSales")
    public ApiResponse getSales(){
        return this.hotelService.sales();
    }
    @GetMapping(value = "/getFreeRooms/{id}")
    public ApiResponse getFreeRooms(@PathVariable Long id,@RequestBody DateDto dto){
        return this.hotelService.getFreeRooms(id,dto);
    }

}
