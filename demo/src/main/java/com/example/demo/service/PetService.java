package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;

import java.util.List;

public interface PetService {

    PetDto getPetById(Integer id);

    Pet findPetByID(Integer id);

    Pet findPetByName(String name);

    List<PetDto> getAllPets();

    PetDto createPet(Pet pet);

    PetDto updatePet(Pet pet);

    void deletePet(Pet pet);
}
