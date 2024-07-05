package com.shafig.springdata.controller;

import com.shafig.springdata.model.dto.request.LaptopRequestDto;
import com.shafig.springdata.model.entity.Laptop;
import com.shafig.springdata.repository.LaptopRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/laptops")
@RequiredArgsConstructor
public class LaptopController {

    private final LaptopRepository laptopRepository;

    @PostMapping
    public ResponseEntity<UUID> saveLaptop(@RequestBody LaptopRequestDto laptop) { {
        return ResponseEntity.ok(laptopRepository.save(new Laptop(laptop)).getId());
    }

    }
}
