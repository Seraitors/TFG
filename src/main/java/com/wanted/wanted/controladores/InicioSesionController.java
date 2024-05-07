package com.wanted.wanted.controladores;

import com.wanted.wanted.servicios.RolServices;
import com.wanted.wanted.servicios.UsuarioServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
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

    /**
     * Mirar por qu eno me redirige al informacion
     * Cambiar el post para ver si se queda guardado el perfil para la pagina cuando cargue 
     * EN le htmll cambiar para ver si carga y funciona
     * @return
     */
    @PostMapping("/inicioSesion/entrar")
    public  String entrar(Model model){
    Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
    String username = authentication.getName();
    model.addAttribute("username", username);
        return "redirect:/inicio";
    }

    @GetMapping("/inicioSesion/logout")
    public String logout(){
        return "redirect:html/encabezado/iniciarSesion";
    }

}
