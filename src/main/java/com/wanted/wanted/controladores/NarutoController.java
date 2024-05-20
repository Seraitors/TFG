package com.wanted.wanted.controladores;



import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.Naruto;
import com.wanted.wanted.servicios.NarutoServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
            return "html/inspeccionar/inspeccionar"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }


    @GetMapping("/comprar/naruto")
    public String comprarNaruto(@RequestParam("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Naruto> naruto = narutoServices.findById(id);

        if (naruto.isPresent()) {
            Naruto naruto2 = naruto.get();
            model.addAttribute("figura", naruto2);
            return "html/comprar/comprar"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }

}
