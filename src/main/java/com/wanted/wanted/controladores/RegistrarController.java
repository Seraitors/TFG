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

    @GetMapping("/usuario/signup")
    public String signup(Model model) {
        model.addAttribute("usuarioDto", new Usuario());
        return "html/registrarSesion/signup"; // Ruta correcta para el formulario de registro
    }

    @PostMapping("/usuario/signup/entrar")
    public String signupSubmit(@Valid @ModelAttribute("usuarioDto") Usuario dto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("Hay errores en el formulario");
            bindingResult.getFieldErrors().forEach(e -> log.info("field: " + e.getField() + ", rejected value: " + e.getRejectedValue()));
            return "html/registrarSesion/signup"; // Ruta correcta para mostrar errores
        } else {
            Usuario usuario = usuarioServices.findByUsernameOrEmail(dto.getUsername(), dto.getEmail());
            if (usuario != null) { // El usuario ya existe
                bindingResult.rejectValue("username", "username.existente", "Ya existe un usuario con ese username");
                return "html/registrarSesion/signup";
            }
            usuarioServices.save(dto);
            return "redirect:/inicioSesion/login";
        }
    }
}


