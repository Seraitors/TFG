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
    public String signup(Model model){
        model.addAttribute("usuarioDto", new Usuario()); // Debes pasar un nuevo Usuario
        return "usuario/signup"; // Asumiendo que "usuario/signup" es la ruta correcta para el formulario de registro
    }


    @PostMapping("/usuario/signup/entrar")
    public String signupSubmit(@Valid @ModelAttribute("usuarioDto")
                               BindingResult bindingResult,Usuario dto,
                               Model model) {
        if (bindingResult.hasErrors()) {
            log.info("hay errores en el formulario");
            bindingResult.getFieldErrors()
                    .forEach(e -> log.info("field: " + e.getField() + ", rejected value: " + e.getRejectedValue()));
            return "/inicioSesion/login";
            /*return "Añadir";*/
        } else {
            Usuario usuario = usuarioServices.findByUsernameOrEmail(dto.getUsername(), dto.getEmail());
            if (usuario != null) { // el usuario ya existe
                bindingResult.rejectValue("username", "username.existente",
                        "ya existe un usuario con ese username");
                return "/usuario/signup";
            }
            usuarioServices.save(dto);
            return "redirect:/inicioSesion/login";

        }
    }
}


