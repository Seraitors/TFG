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



    //registar son los usuarios
    private final UsuarioServices usuarioServices;


    //roles son los perfiles

    private final RolServices rolServices;
    
    @GetMapping("/inicioSesion/login")
    public  String iniciarSesion( Model model){
        model.addAttribute("usuario", new Usuario());

        return "html/iniciarSesion/index";
    }

    /**
     * Mirar por qu eno me redirige al informacion
     * Cambiar el post para ver si se queda guardado el perfil para la pagina cuando cargue 
     * EN le htmll cambiar para ver si carga y funciona
     * @return
     */
    @PostMapping("/iniciarSesion/entrar")
    public  String entar(){

        return "redirect:/inicio";
    }

    /*Crear un idex para cuando te salgas de la aplicacion*/
    @GetMapping("/usuario/logout")
    public String salir(){
        return "redirect:/inicio";
    }

/*    *//**
     * Esto es para cuando le des al login que se vay aa ets apagina
     * @return
     *//*
    @GetMapping("/despues/login")
    public  String despuesLogin(){

        return "html/inicarSesion/despuesLogin";

    }

    @PostMapping("/despues/login/entrar")
    public  String entar1(){

        return "redirect:/despues/login";
    }
    */



   /* @PostMapping("/inicioSesion/logout")
            public String logout () {
            return "redirect:html/encabezado/iniciarSesion";
        }
*/
}



