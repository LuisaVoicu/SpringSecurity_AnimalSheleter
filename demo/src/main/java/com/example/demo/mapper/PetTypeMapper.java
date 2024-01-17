package com.example.demo.mapper;

import com.example.demo.dto.PetDto;
import com.example.demo.dto.PetTypeDto;
import com.example.demo.dto.RoleDto;
import com.example.demo.model.PetType;
import com.example.demo.model.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@RequiredArgsConstructor
@Component
public class PetTypeMapper {

    private final PetMapper petMapper;

    public PetTypeDto petTypeEntityToDto(PetType petType){
        return PetTypeDto
                .builder()
                .name(petType.getName())
                .pets(petMapper.petListEntityToDto(petType.getPets()))
                .build();
    }

    public List<PetTypeDto> petTypeListEntityToDto(List<PetType> petTypes){
        return petTypes.stream()
                .map(petType -> petTypeEntityToDto(petType))
                .toList();
    }

    public PetType petTypeDtoToEntity(PetTypeDto petTypeDto){
        return PetType
                .builder()
                .name(petTypeDto.name())
                .pets(petMapper.petListDtoToEntity(petTypeDto.pets()))
                .build();
    }

    public List<PetType> petTypeListDtoToEntity(List<PetTypeDto> petTypeDtos){
        return petTypeDtos.stream()
                .map(petTypeDto -> petTypeDtoToEntity(petTypeDto))
                .toList();
    }
}
