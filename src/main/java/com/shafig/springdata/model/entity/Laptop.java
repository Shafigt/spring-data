package com.shafig.springdata.model.entity;

import com.shafig.springdata.model.dto.request.LaptopRequestDto;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Data
@NoArgsConstructor
public class Laptop {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String name;



    public Laptop(LaptopRequestDto laptopRequestDto) {
        this.id = laptopRequestDto.getId();
        this.name = laptopRequestDto.getName();
    }

    public Laptop(String name) {
        this.name = name;
    }

}
