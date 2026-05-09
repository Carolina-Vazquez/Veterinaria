package com.clinica.veterinaria.controller;

import com.clinica.veterinaria.model.Mascota;
import com.clinica.veterinaria.model.Propietario;
import com.clinica.veterinaria.repository.MascotaRepository;
import com.clinica.veterinaria.repository.PropietarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class VeterinariaController {

    @Autowired
    private PropietarioRepository propietarioRepo;

    @Autowired
    private MascotaRepository mascotaRepo;

    @GetMapping("/inicio")
    public String inicio() {
        return "inicio";
    }

    @GetMapping("/listadoPropietario")
    public String listadoPropietario(Model model) {
        model.addAttribute("propietarios", propietarioRepo.findAll());
        return "listadoPropietario";
    }

    @GetMapping("/listadoMascota")
    public String listadoMascota(Model model) {
        model.addAttribute("mascotas", mascotaRepo.findAll());
        return "listadoMascota";
    }

    @GetMapping("/altaPropietario")
    public String altaPropietarioForm(Model model) {
        model.addAttribute("propietario", new Propietario());
        return "altaPropietario";
    }

    @PostMapping("/altaPropietario")
    public String altaPropietarioSubmit(@ModelAttribute Propietario propietario) {
        propietarioRepo.save(propietario);
        return "redirect:/listadoPropietario";
    }

    @GetMapping("/altaMascota")
    public String altaMascotaForm(Model model) {
        model.addAttribute("mascota", new Mascota());
        model.addAttribute("propietarios", propietarioRepo.findAll());
        return "altaMascota";
    }

    @PostMapping("/altaMascota")
    public String altaMascotaSubmit(@ModelAttribute Mascota mascota) {
        mascotaRepo.save(mascota);
        return "redirect:/listadoMascota";
    }
}