package com.exam.entities;

import com.exam.dtos.RoomDto;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "ROOMS")
@JsonIgnoreProperties({"hibernateLazyInitializer"})
public class Room extends AppEntity<Long>{
    @Id
    @Column(name = "ID")
    @SequenceGenerator(name = "roomIdSeq", sequenceName = "ROOM_ID_SEQ", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "roomIdSeq")
    private Long id;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "PRICE", nullable = false)
    private float oneNightPrice;

    @ManyToOne
    private Hotel hotel;

    public Room(RoomDto dto){
        this.number = dto.getNumber();
    }
}
