package com.iesrafaelalberti.hlc_10_springboot_javier_clavijogarcia.controllers;

import com.iesrafaelalberti.hlc_10_springboot_javier_clavijogarcia.services.DNIService;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Objects;

@org.springframework.stereotype.Controller
@RequestMapping(value = "/")

public class MainController {
    /**
     * Controlador principal
     *
     * @param nombre    Nombre del usuario
     * @param apellidos Apellidos del usuario
     * @param dni       DNI del usuario
     * @param ciudad    Ciudad del usuario
     * @param model     Objeto Model con el que se pasarán los parámetros a la plantilla
     * @return Plantilla HTML generada por Thymeleaf
     */
    @GetMapping({"/"})
    public String controlador(
            @RequestParam(name = "nombre", required = false, defaultValue = "Antonio") String nombre,
            @RequestParam(name = "apellidos", required = false, defaultValue = "Pérez") String apellidos,
            @RequestParam(name = "dni", required = false, defaultValue = "77666555") String dni,
            @RequestParam(name = "ciudad", required = false, defaultValue = "Cádiz") String ciudad,
            Model model) {
        model.addAttribute("nombre", nombre);
        model.addAttribute("apellidos", apellidos);
        model.addAttribute("dni", dni);
        model.addAttribute("ciudad", ciudad);

        String letraDNI = DNIService.letraDNI(dni);
        String nif;

        if (letraDNI.equals("Error: DNI incorrecto")) {
            //  Si el servicio de DNI devuelve error, establecemos el NIF como la cadena "Error"
            nif = "Error: DNI incorrecto";
        } else {
            nif = dni + letraDNI;
        }

        model.addAttribute("nif", nif);

        return "index";
    }

}
