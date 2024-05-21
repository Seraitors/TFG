package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.OnePiece;
import com.wanted.wanted.servicios.OnePieceServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

//** CAMBIAR EL NOMBRE DLE TRABAJO A ONPIECE CONTROLLER */
@RequiredArgsConstructor
@Slf4j
@Controller

public class OnePieceController {

    private final OnePieceServices onePieceServices;


    @GetMapping("/OnePiece")
    public String inicioOnePiece(  Model model) {

        model.addAttribute("listaOnePiece", onePieceServices.findAll());

        return "html/onePiece/index";
    }



    @GetMapping("/detalle/onePiece/{id}")
    public String verDetallee(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<OnePiece> onePiece = onePieceServices.findById(id);

        if (onePiece.isPresent()) {
            OnePiece  onePiece2 = onePiece.get();
            model.addAttribute("figura", onePiece2);
            return "html/inspeccionar/inspeccionar"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }


    @GetMapping("/comprar/onePiece")
    public String comprarOnePiece(@RequestParam("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<OnePiece> onePiece = onePieceServices.findById(id);

        if (onePiece.isPresent()) {
            OnePiece  onePiece2 = onePiece.get();
            model.addAttribute("figura", onePiece2);
            return "html/comprar/comprar"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }

    @GetMapping("/figuras/onePiece/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("onePiece", new OnePiece()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarOnePiece";
    }

    @PostMapping("/figuras/onePiece/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmit(@ModelAttribute("onePiece") OnePiece nuevaPersona) {
        log.info(nuevaPersona.toString());
        onePieceServices.add(nuevaPersona);
        return "redirect:/inicio";
    }
    
}
