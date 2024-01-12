package com.example.demo.service;

import com.example.demo.dto.PetDto;
import com.example.demo.mapper.PetMapper;
import com.example.demo.model.Pet;
import com.example.demo.repository.PetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PetServiceImpl implements PetService{


    private final PetRepository petRepository;

    private final PetMapper petMapper;


    @Override
    public PetDto getPetById(Integer id) {
        return petMapper.petEntityToDto(petRepository.findById(id).orElse(null));
    }

    @Override
    public Pet findPetByID(Integer id) {
        return petRepository.findById(id).orElse(null);

    }

    @Override
    public List<PetDto> getAllPets() {
        return petMapper.petListEntityToDto(petRepository.findAll());
    }

    @Override
    public PetDto createPet(Pet pet) {
        return petMapper.petEntityToDto(petRepository.save(pet));    }

    @Override
    public PetDto updatePet(Pet pet) {
        return petMapper.petEntityToDto(petRepository.save(pet));
    }

    @Override
    public void deletePet(Pet pet) {
        if(pet != null) {
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!! " + pet.getName());
            petRepository.delete(pet);
        }
        else{
            System.out.println("!!!!!!!!!!!!!!!!!!!!!!! NULLL" );

        }
    }
}
