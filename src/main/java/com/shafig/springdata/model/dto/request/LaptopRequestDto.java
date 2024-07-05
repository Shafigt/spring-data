package com.shafig.springdata.model.dto.request;

import lombok.Data;

import java.util.UUID;

@Data
public class LaptopRequestDto {
    private UUID id;
    private String name;
}
