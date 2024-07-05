package com.shafig.springdata.repository;

import com.shafig.springdata.model.entity.Laptop;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface LaptopRepository extends JpaRepository<Laptop, UUID> {
}
