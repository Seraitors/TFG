package com.wanted.wanted.controladores;


import com.wanted.wanted.servicios.FiguraServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Slf4j
@Controller
public class RegistrarController {
    
    @GetMapping("/registrar")
    public  String registar(){

        return  "html/registarSesion/register";

    }


}
