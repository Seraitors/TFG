package com.wanted.wanted.controladores;


import com.wanted.wanted.servicios.OnePieceServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
    


    
    
}
