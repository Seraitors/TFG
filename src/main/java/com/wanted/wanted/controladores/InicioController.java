package com.wanted.wanted.controladores;


import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.NovedadServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@RequiredArgsConstructor
@Slf4j
@Controller

public class InicioController {

    private final FiguraServices   figuraServices;
    private final NovedadServices novedadServices;



    @GetMapping({"/" ,"/inicio"})
    public  String  inicio(Model model){
    model.addAttribute("listaFigura",figuraServices.findAll());
    model.addAttribute("novedadFigura", novedadServices.findAll());

    return "html/lista";


    }
    @GetMapping("/inicio/inspeccionar ")
    public  String inspeccionar(Model model){
        model.addAttribute("listaFigura",figuraServices.findAll());
        model.addAttribute("novedadFigura", novedadServices.findAll());


        return null;
    }

    /**
     * esto va a ser importnate
     * Tenemso qu ecoger los correos que se queden guardados y que los pille para cada usuario
     * @return
     */

  



    @GetMapping("/caracteristicas")
    public  String caracteristicas (){
        return "html/encabezado/caracteristicas";


    }

    @PostMapping("/caracteristicas")
    public  String caracteristica(){


        return "redirect:/figuras/lista";
    }

    @GetMapping("/pagoEnca")
    public  String encabezadoPago(){

        return  "html/encabezado/precios";

    }
    @PostMapping("/pago/figura")
    public  String encabezadoPrecio(){


        return"redirect:/figuras/lista";
    }

    @GetMapping("/encabezado")
    public  String Encabezado(){

        return "html/encabezado/acercaEnca";

    }

    @PostMapping("/encabezadoPost")
    public  String encabezadoPost(){
        return "redirect:/figuras/lista";

    }

    @GetMapping("/inicio/creador")
    public  String creador (){


        return "html/encabezado/creador";
    }
    @PostMapping("/inicio/figura")
    public  String volver(){

        return "redirect:/figuras/lista";
    }

    @GetMapping("/faqs")
    public  String factos(){
        return "html/encabezado/faqs";
    }

    @PostMapping("/exit/faqs")
    public  String volverAtras(){


        return "redirect:/figuras/lista";
    }
}
