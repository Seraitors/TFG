package com.wanted.wanted.controladores;



import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Naruto;
import com.wanted.wanted.servicios.NarutoServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Controller
public class NarutoController {

    private final NarutoServices narutoServices;

    @GetMapping("/Naruto")
    public String inicioOnePiece(Model model) {

        model.addAttribute("listaNaruto", narutoServices.findAll());

        return "html/naruto/index";
    }




    @GetMapping("/detalle/naruto/{id}")
    public String verDetallee(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Naruto> naruto = narutoServices.findById(id);

        if (naruto.isPresent()) {
            Naruto naruto2 = naruto.get();
            model.addAttribute("figura", naruto2);
            return "html/inspeccionar/inspeccionarnaruto"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }




    @GetMapping("/figuras/naruto/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("naruto", new Naruto()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarNaruto";
    }

    @PostMapping("/figuras/naruto/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmit(@ModelAttribute("naruto") Naruto nuevaPersona) {
        log.info(nuevaPersona.toString());
        narutoServices.add(nuevaPersona);
        return "redirect:/inicio";
    }


    @GetMapping("/figuras/filtrarNaruto")
    public String listadoFiltrado(@RequestParam(name = "nombre", required = false) String nombre, Model model){
        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("listaFigura", narutoServices.findByNombre(nombre));
        } else {
            model.addAttribute("listaFigura", narutoServices.findAll());
        }
        return "/html/lista";
    }

}
