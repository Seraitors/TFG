package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Novedad;
import com.wanted.wanted.servicios.NovedadServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Controller
public class NovedadController {


    private final NovedadServices novedadServices;




    @GetMapping("/detalle/novedad/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Novedad> novedad = novedadServices.findById(id);

        if (novedad.isPresent()) {
            Novedad novedad2 = novedad.get();
            model.addAttribute("figura", novedad2);
            return "html/inspeccionar/inspeccionar"; // Devolver la vista de detalle
        }else{

            return "redirect:/inicio";
        }


    }

    @GetMapping("/figuras/novedad/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("novedad", new Novedad()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarNovedad";
    }

    @PostMapping("/figuras/novedad/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmit(@ModelAttribute("novedad") Novedad nuevaPersona) {
        log.info(nuevaPersona.toString());
        novedadServices.add(nuevaPersona);
        return "redirect:/inicio";
    }

}
