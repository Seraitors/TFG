package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Controller


public class ComprarController {
    private  final FiguraServices figuraServices;
    private final OnePieceServices onePieceServices;
    private final NarutoServices narutoServices ;
    private final DragonBallServices dragonBallServices ;
    private final NovedadServices novedadServices ;


    /**
     * Aqui tenemso que coger la id de cada de los que queramos olo la informacion que se va a monstrar en la pagina web
     * Despues de eso hacemos un formulario donde llenar los datos y con seguyridad hacemso que si estas registrado no te
     * salga el nombre ni el apellido pero si que tenga que poner la tarjeta para pagar
     */


    @GetMapping("/comprar")
    public String comprar(@RequestParam("id") Long id, Model model) {
       Optional<Figura>  figura = figuraServices.findById(id);
        model.addAttribute("figura", figura);

        if (figura.isPresent()) {
            Figura figura2 = figura.get();
            model.addAttribute("figura", figura2);
            return "html/comprar/comprar"; // Devolver la vista de detalle
        }else{

            return "html/comprar/comprar";
        }




    }
}
