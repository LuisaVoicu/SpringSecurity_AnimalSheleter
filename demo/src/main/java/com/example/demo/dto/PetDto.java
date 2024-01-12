package com.example.demo.dto;

import com.example.demo.model.PetType;
import lombok.Builder;

@Builder
public record PetDto (String name, Integer age, Float weight, PetType petType){}
