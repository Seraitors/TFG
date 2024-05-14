package com.wanted.wanted.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.DragonBallServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Slf4j
@Controller
public class DragonBallController {
    



       private final DragonBallServices  dragonBallServices;

    @GetMapping("/DragonBall")
    public String inicioOnePiece(Model model) {

        model.addAttribute("listaDragonBall", dragonBallServices.findAll());

        return "html/dragonBall/index";
    }

    /**
     * Poner bonito y hacer todo lo del detalle con todos 
     */
       @GetMapping("/detalle/{id}")
    public String verDetallee(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<DragonBall> dragon = dragonBallServices.findById(id);

        if (dragon.isPresent()) {
            DragonBall dragonBall2 = dragon.get();
             model.addAttribute("figura", dragonBall2);
               return "html/inspeccionar/inspeccionar"; // Devolver la vista de detalle
        }else{

            return "redirect:/inicio";
        }
       
      
    } 


}
