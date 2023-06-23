package com.exam.entities;

import com.exam.dtos.HotelDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "HOTELS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Hotel extends AppEntity<Long>{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "hotelIdSeq", sequenceName = "HOTEL_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "hotelIdSeq")
    private Long id;

    @Column(name = "NAME", nullable = false)
    private String name;

    public Hotel(HotelDto dto){
        this.name = dto.getName();
    }
}
