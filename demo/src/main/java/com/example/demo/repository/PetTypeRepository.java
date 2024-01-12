package com.example.demo.repository;

import com.example.demo.model.PetType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetTypeRepository extends JpaRepository<PetType, Integer> {
    PetType findByName(String name);
}
