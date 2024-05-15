package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.OnePiece;
import com.wanted.wanted.servicios.OnePieceServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

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
    
}
