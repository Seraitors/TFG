package com.wanted.wanted.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.DragonBallServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@RequiredArgsConstructor
@Slf4j
@Controller
public class DragonBallController {


    private final DragonBallServices dragonBallServices;

    @GetMapping("/DragonBall")
    public String inicioOnePiece(Model model) {

        model.addAttribute("listaDragonBall", dragonBallServices.findAll());

        return "html/dragonBall/index";
    }

    /**
     * Poner bonito y hacer todo lo del detalle con todos
     */
    @GetMapping("/detalle/dragon/{id}")
    public String verDetallee(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<DragonBall> dragon = dragonBallServices.findById(id);

        if (dragon.isPresent()) {
            DragonBall dragonBall2 = dragon.get();
            model.addAttribute("figura", dragonBall2);
            return "html/inspeccionar/inspeccionarDragonBall"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }





    @GetMapping("/figuras/dragonBall/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("dragonBall", new DragonBall()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarDragonBall";
    }

    @PostMapping("/figuras/dragonBall/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmit(@ModelAttribute("dragonBall") DragonBall nuevaPersona) {
        log.info(nuevaPersona.toString());
        dragonBallServices.add(nuevaPersona);
        return "redirect:/inicio";
    }

    @GetMapping("/figuras/filtrarDragon")
    public String listadoFiltrado(@RequestParam(name = "nombre", required = false) String nombre, Model model){
        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("listaFigura", dragonBallServices.findByNombre(nombre));
        } else {
            model.addAttribute("listaFigura", dragonBallServices.findAll());
        }
        return "/html/lista";
    }

}



