package com.certicamara.certicamaraprueba1.web.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/")
    public String saludar(){
        return "Bienvenido a mi API para Certicamara";
    }
}
