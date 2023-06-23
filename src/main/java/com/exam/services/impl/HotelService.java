package com.exam.services.impl;

import com.exam.dtos.ApiResponse;
import com.exam.dtos.DateDto;
import com.exam.dtos.HotelDto;
import com.exam.entities.Hotel;
import com.exam.entities.RecordState;
import com.exam.entities.Room;
import com.exam.models.HotelSalesModel;
import com.exam.repositories.HotelRepository;
import com.exam.repositories.ReservationRepository;
import com.exam.repositories.RoomRepository;
import com.exam.services.IHotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service
public class HotelService implements IHotelService {
    private final HotelRepository hotelRepository;
    private final ReservationRepository reservationRepository;
    private final RoomRepository roomRepository;
    @Autowired
    public HotelService(HotelRepository hotelRepository, ReservationRepository reservationRepository, RoomRepository roomRepository) {
        this.hotelRepository = hotelRepository;
        this.reservationRepository = reservationRepository;
        this.roomRepository = roomRepository;
    }

    @Override
    public ApiResponse add(HotelDto dto) {
        Hotel hotel = new Hotel();
        hotel.setName(dto.getName());
        hotel.setRecordState(RecordState.ACTIVE);
        return new ApiResponse("status",hotelRepository.save(hotel));
    }

    @Override
    public ApiResponse getAll() {
        return new ApiResponse("hotels",hotelRepository.getAll());
    }

    @Override
    public ApiResponse getFreeRooms(Long id, DateDto dto) {
        List<Room> busyRooms = reservationRepository.getBusyRooms(dto);
        List<Long> ids = busyRooms.stream()
                .map(Room::getId)
                .collect(Collectors.toList());
        return new ApiResponse("reservation",roomRepository.getRoomsByHotelIdAndIdNotIn(id,ids));
    }

    @Override
    public ApiResponse sales() {
        List<HotelSalesModel> sales = new ArrayList<>();
        Set<Long> hotelIds = reservationRepository.getAllHotelId();
        for (Long i : hotelIds){
            HotelSalesModel model = new HotelSalesModel();
            model.setHotelName(hotelRepository.getHotelNameById(i));
            model.setRentRoom(reservationRepository.getCountReservationByHotelId(i));
            long oneNightPrice = reservationRepository.getOneNightPriceReservationByHotelId(i);
            long days = reservationRepository.getDaysReservationByHotelId(i);
            model.setTotalAmount(oneNightPrice*days);
            sales.add(model);
        }
        return new ApiResponse("sales", sales);
    }
}
