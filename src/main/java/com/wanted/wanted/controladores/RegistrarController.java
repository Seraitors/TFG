package com.wanted.wanted.controladores;

import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.servicios.UsuarioServices;
import com.wanted.wanted.servicios.EmailService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
    private final UsuarioServices usuarioServices;
    @Autowired
    private final EmailService emailService;

    @GetMapping("/usuario/signup")
    public String signup(Model model) {
        model.addAttribute("usuarioDto", new Usuario());
        log.info("Paso por registrar ");
        return "html/registarSesion/registrar"; // Ruta correcta para el formulario de registro
    }

    @PostMapping("/usuario/signup/entrar")
    public String signupSubmit(@Valid @ModelAttribute("usuarioDto") Usuario dto,
                               BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            log.info("Hay errores en el formulario");
            bindingResult.getFieldErrors().forEach(e -> log.info("field: " + e.getField() + ", rejected value: " + e.getRejectedValue()));
            return "html/registarSesion/registrar"; // Ruta correcta para mostrar errores
        } else {
            Usuario usuario = usuarioServices.findByUsernameOrEmail(dto.getUsername(), dto.getEmail());
            if (usuario != null || usuario.getUsername().equals(dto.getUsername()) || usuario.getEmail().equals(dto.getEmail()))  { // El usuario ya existe
                bindingResult.rejectValue("username", "username.existente", "Ya existe un usuario con ese username");
                return "html/registarSesion/registrar";
            }
            usuarioServices.save(dto);

            // Enviar correo electrónico de notificación
            emailService.sendRegistrationEmail(dto.getEmail(),
                    "Bienvenido a Wanted",
                    "Gracias por registrarte en nuestra aplicación nakama, bienvenido al nuevo mundo " + dto.getUsername() + ".");

            return "redirect:/aaa";
        }
    }
}
