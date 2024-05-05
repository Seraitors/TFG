package com.wanted.wanted.controladores;

import com.wanted.wanted.servicios.RolServices;
import com.wanted.wanted.servicios.UsuarioServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class InicioSesionController {



    //registar son los usuarios
    private final UsuarioServices usuarioServices;


    //roles son los perfiles

    private final RolServices rolServices;
    @GetMapping("/inicioSesion/login")
    public  String iniciarSesion(){


        return "html/iniciarSesion/index";
    }


    @PostMapping("/inicioSesion/entrar")
    public  String entrar(){

        return "redirect:/inicio";
    }

    @GetMapping("/inicioSesion/logout")
    public String logout(){
        return "redirect:html/encabezado/iniciarSesion";
    }

}
