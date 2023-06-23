package com.exam.dtos;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
public class ReservationDto {
    private Long roomId;
    private Date from;
    private Date to;


}
