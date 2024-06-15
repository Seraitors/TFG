package com.wanted.wanted.controladores;

import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.servicios.RolServices;
import com.wanted.wanted.servicios.UsuarioServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class InicioSesionController {




    private final UsuarioServices usuarioServices;



    private final RolServices rolServices;
    
    @GetMapping("/inicioSesion/login")
    public  String iniciarSesion( Model model){
        model.addAttribute("usuario", new Usuario());

        return "html/iniciarSesion/index";
    }

    @PostMapping("/inicioSesion/login/submit")
    public  String iniciarSesion1( Model model){
        return "redirect:/inicio";
    }

    @GetMapping("/usuario/logout")
    public String salir(){
        return "redirect:/inicio";
    }


}



