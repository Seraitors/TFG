package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.FiguraServices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Controller

public class InicioController {

    private final FiguraServices   figuraServices;




    @GetMapping({"/aaa" ,"/inicio","/"})
    public  String  inicio(Model model){


        List<Figura> figura = figuraServices.getRandomFiguras(8);
        List<Figura> figuras = figuraServices.getFiguras(4, "novedad");


        model.addAttribute("listaFigura",figura);
        model.addAttribute("listaNovedad",figuras);



    return "html/lista";


    }
    @GetMapping("/Novedad")
    public String figurasPorFecha( Model model) {


        List<Figura> figuras = figuraServices.getFigurasByCategoria("novedad");
        model.addAttribute("listaNovedad", figuras);
        return "html/novedad/index";
    }
    /**
     * Para coger le id y ver el detalle
     * @param id
     * @param model
     * @return
     */
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> figura = figuraServices.findById(id);

        if (figura.isPresent()) {
            Figura figura2 = figura.get();
             model.addAttribute("figura", figura2);
               return "html/inspeccionar/inspeccionar"; // Devolver la vista de detalle
        }else{

            return "redirect:/inicio";
        }


    }


    @GetMapping("/figuras/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("figuraDTO", new Figura()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregar";
    }

    @PostMapping("/figuras/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmit(@ModelAttribute("figuraDTO") Figura nuevaPersona) {
        log.info(nuevaPersona.toString());
        figuraServices.add(nuevaPersona);
        return "redirect:/inicio";
    }


    @GetMapping("/admin/meter/figura")

    public  String añadirFiguras (){


        return "html/adminMonitorizar/adminMeterFigura";
    }


    /**
     * Filtrar
     */

    @GetMapping("/figuras/filtrar")
    public String listadoFiltrado(@RequestParam(name = "nombre", required = false) String nombre, Model model){
        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("listaFigura", figuraServices.findByNombre(nombre));
        } else {
            model.addAttribute("listaFigura", figuraServices.findAll() );
        }
        return "/html/lista";
    }


    @GetMapping("/comprar")
    public  String comprar(){


        return "html/comprar/comprar";
    }

    /**
     * Esto para añadir a favoritos
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

    @GetMapping("/centroDeSoporte")
    public  String centroDeSoporte(){
        return "html/footer/centroDeSoporte";
    }

    @GetMapping("/devolucionesGarantias")
    public  String devolucionesGarantias(){
        return "html/footer/devolucionesGarantias";
    }

    @GetMapping("/contactar")
    public  String contactar(){
        return "html/footer/contactar";
    }

    @GetMapping("/privacidad")
    public  String privacidad(){
        return "html/footer/privacidad";
    }
    @GetMapping("/contacto")
    public  String contacto(){
        return "html/encabezado/contacto";
    }

    /**
     * Dragon ball controler
     */

    @GetMapping("/DragonBall")
    public String inicioOnePiece(Model model) {

        List<Figura> figuras = figuraServices.getFigurasByCategoria("dragon-ball");
        model.addAttribute("listaDragonBall", figuras);
        return "html/dragonBall/index";
    }


    /**
     * Naruto controller
     */

    @GetMapping("/Naruto")
    public String inicioOnePipece(Model model) {
        List<Figura> figuras = figuraServices.getFigurasByCategoria("naruto");
        model.addAttribute("listaNaruto", figuras);

        return "html/naruto/index";
    }



    /**
     * One piece
     * @param model
     * @return
     */
    @GetMapping("/OnePiece")
    public String inicioOneoPiece(  Model model) {
        List<Figura> figuras = figuraServices.getFigurasByCategoria("one-piece");
        model.addAttribute("listaOnePiece", figuras);

        return "html/onePiece/index";
    }




}
