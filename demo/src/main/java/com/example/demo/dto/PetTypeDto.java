package com.example.demo.dto;

import com.example.demo.model.Pet;
import lombok.Builder;

import java.util.List;

@Builder
public record PetTypeDto (String name, List<PetDto> pets){}
