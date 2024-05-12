package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.UsuarioServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;


@RequiredArgsConstructor
@Slf4j
@Controller
public class RegistrarController {

    private final UsuarioServices usuarioServices;

    @GetMapping("/registro")
    public String registrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "Registro";
    }
    @PostMapping("/registro/submit")
    public String registroSubmit(@ModelAttribute("usuario" ) @Valid Usuario usuario, BindingResult bindingResult){

        if (bindingResult.hasErrors()) {
            return "Registro";
        }else {
            usuarioServices.registrarUsuario(usuario);
            System.out.println("Se ha registrado");
            return "redirect:/InicioSesion";
        }
    }
}


