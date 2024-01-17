package com.example.demo.repository;

import com.example.demo.model.Pet;
import com.example.demo.model.User;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface PetRepository extends JpaRepository<Pet, Integer> {

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"name"})
    Optional<Pet> findByName(String name);

    @EntityGraph(type = EntityGraph.EntityGraphType.FETCH,
            attributePaths = {"id"})
    List<Pet> findAll();

}