package com.example.demo.service;

import com.example.demo.dto.PetTypeDto;
import com.example.demo.mapper.PetTypeMapper;
import com.example.demo.model.PetType;
import com.example.demo.repository.PetTypeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetTypeService {

    private final PetTypeRepository petTypeRepository;

    private final PetTypeMapper petTypeMapper;

    public PetTypeDto getPetTypeById(Integer id){
        return petTypeMapper.petTypeEntityToDto(petTypeRepository.findById(id).orElse(null));
    }

    public PetTypeDto findByPetType(String petType){
        return petTypeMapper.petTypeEntityToDto(petTypeRepository.findByName(petType));
    }

    public List<PetTypeDto> getAllPetTypes(){
        return petTypeMapper.petTypeListEntityToDto(petTypeRepository.findAll());
    }

    public PetTypeDto createPetType(PetType petType){
        return petTypeMapper.petTypeEntityToDto(petTypeRepository.save(petType));
    }

    public PetTypeDto updatePetType(PetType petType){
        return petTypeMapper.petTypeEntityToDto(petTypeRepository.save(petType));
    }

    public void deletePetType(PetType petType){
        petTypeRepository.delete(petType);
    }

}
