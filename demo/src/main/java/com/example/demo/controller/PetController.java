package com.example.demo.controller;

import com.example.demo.dto.PetDto;
import com.example.demo.dto.PetDto;
import com.example.demo.model.Pet;
import com.example.demo.model.User;
import com.example.demo.service.PetService;
import com.example.demo.service.PetService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class PetController {

    private final PetService petService;


    //todo add Pet type to create operation
    // CREATE
    @GetMapping({"/pets/create"})
    public String displayCreatePetForm(Model model) {

        model.addAttribute("title", "Register");
        model.addAttribute("pet", new Pet());

        return "/pet/create";
    }

    @PostMapping({"/pets/create"})
    public String processCreatePetsForm(@ModelAttribute("pet") Pet pet, RedirectAttributes redirectAttributes ) {

        PetDto petDto = petService.createPet(pet);

        redirectAttributes.addAttribute("registrationSuccess", "Success");

        return "redirect:/pets";

    }


    // RETRIEVE

    @GetMapping("/pets")
    public String getPets(Model model){
        List<PetDto> petDtos = petService.getAllPets();
        model.addAttribute("title", "Pets");
        model.addAttribute("pets", petDtos);
        return "pets";
    }

    @GetMapping("/pets/{id}")
    public PetDto getPetById(@PathVariable Integer id){
        return petService.getPetById(id);
    }



    // DELETE
    @GetMapping("/pets/delete")
    public String displayDeleteUserForm(Model model) {
        model.addAttribute("title", "Delete Pet");
        model.addAttribute("pets", this.petService.getAllPets());
        System.out.println("~~~~~~~~~~~~~~");
        return "pet/delete";
    }

    @PostMapping("/pets/delete")
    public String processDeleteUserForm(@ModelAttribute("id") Integer[] petIds) {
        System.out.println("~~~~~~~~~!!!!!!!!~~~~~~");

        if (petIds != null) {

            for(Integer id : petIds){

                Pet petOpt = petService.findPetByID(id);

                if(petOpt != null) {
                    this.petService.deletePet(petOpt);
                }
            }
        }

        return "redirect:/users";
    }

}
