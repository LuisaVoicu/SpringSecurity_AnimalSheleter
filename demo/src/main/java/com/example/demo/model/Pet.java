package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "PET")
public class Pet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Builder.Default
    private Boolean enabled = true;

    @NonNull
    @Column(unique = true)
    private String name;

    private Integer age;

    private Float weight;

    @ManyToOne()
    private PetType petType;

}
