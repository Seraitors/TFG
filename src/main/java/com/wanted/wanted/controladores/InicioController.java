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






    @GetMapping({"/aaa" ,"/inicio"})
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

 /*   @PostMapping("/figuras/{id}/favorito")
    public ResponseEntity<String> toggleFavorito(@PathVariable Long id, @AuthenticationPrincipal UserDetails userDetails) {
        Optional<Figura> figuraOpt = figuraServices.findById(id);
        if (figuraOpt.isPresent()) {
            Figura figura = figuraOpt.get();
            Usuario usuario = usuariosServicesSeguridad.findByUsername(userDetails.getUsername());
            if (usuario.getFavoritos().contains(figura)) {
                usuario.getFavoritos().remove(figura);
            } else {
                usuario.getFavoritos().add(figura);
            }
            usuariosServicesSeguridad.save(usuario);
            return ResponseEntity.ok("Favorito actualizado");
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}*/






    // darle un ojo
/*     @RestController
@RequestMapping("/carrito")
public class CarritoController {

    @PostMapping("/agregar")
    public ResponseEntity<String> agregarAlCarrito(@RequestBody Figura figura, HttpServletResponse response) {
        // Aquí deberías agregar la lógica para almacenar la figura en una cookie
        Cookie cookie = new Cookie("carrito", figura.getId().toString());
        cookie.setMaxAge(24 * 60 * 60); // La cookie expirará en 1 día
        response.addCookie(cookie);
        return ResponseEntity.ok("Figura agregada al carrito");
    }
} */




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
     * Poner bonito y hacer todo lo del detalle con todos
     */
    /*@GetMapping("/detalle/dragon/{id}")
    public String verDetall1e(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> dragon = figuraServices.findById(id);

        if (dragon.isPresent()) {
            Figura dragonBall2 = dragon.get();
            model.addAttribute("figura", dragonBall2);
            return "html/inspeccionar/inspeccionarDragonBall"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }*/




/*

    @GetMapping("/figuras/dragonBall/new")
    public String nuevaFiguraa(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("dragonBall", new Figura()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarDragonBall";
    }

    @PostMapping("/figuras/dragonBall/new/submit") // Cambio la URL de la anotación
    public String nuevaMascotaSubmiit(@ModelAttribute("dragonBall") Figura nuevaPersona) {
        log.info(nuevaPersona.toString());
        figuraServices.add(nuevaPersona);
        return "redirect:/inicio";
    }

    @GetMapping("/figuras/filtrarDragon")
    public String listadoFiltradjo(@RequestParam(name = "nombre", required = false) String nombre, Model model){
        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("listaFigura", figuraServices.findByNombre(nombre));
        } else {
            model.addAttribute("listaFigura", figuraServices.findAll());
        }
        return "/html/lista";
    }
*/


    /**
     * Naruto controller
     */

    @GetMapping("/Naruto")
    public String inicioOnePipece(Model model) {
        List<Figura> figuras = figuraServices.getFigurasByCategoria("naruto");
        model.addAttribute("listaNaruto", figuras);

        return "html/naruto/index";
    }




  /*  @GetMapping("/detalle/naruto/{id}")
    public String verDetalle1e(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> naruto = figuraServices.findById(id);

        if (naruto.isPresent()) {
            Figura naruto2 = naruto.get();
            model.addAttribute("figura", naruto2);
            return "html/inspeccionar/inspeccionarnaruto"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }




    @GetMapping("/figuras/naruto/new")
    public String nuevaaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("naruto", new Figura()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarNaruto";
    }

    @PostMapping("/figuras/naruto/new/submit") // Cambio la URL de la anotación
    public String nuevaaMascotaSubmit(@ModelAttribute("naruto") Figura nuevaPersona) {
        log.info(nuevaPersona.toString());
        figuraServices.add(nuevaPersona);
        return "redirect:/inicio";
    }


    @GetMapping("/figuras/filtrarNaruto")
    public String listadoFiltrwado(@RequestParam(name = "nombre", required = false) String nombre, Model model){
        if (nombre != null && !nombre.isEmpty()) {
            model.addAttribute("listaFigura", figuraServices.findByNombre(nombre));
        } else {
            model.addAttribute("listaFigura", figuraServices.findAll());
        }
        return "/html/lista";
    }*/


    /**
     * Novedad
     * @param model
     * @return
     */





  /*  @GetMapping("/detalle/novedad/{id}")
    public String vearDetalle(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> novedad = figuraServices.findById(id);

        if (novedad.isPresent()) {
            Figura novedad2 = novedad.get();
            model.addAttribute("figura", novedad2);
            return "html/inspeccionar/inspeccionarNovedad"; // Devolver la vista de detalle
        }else{

            return "redirect:/inicio";
        }


    }

    @GetMapping("/figuras/novedad/new")
    public String nuaevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("novedad", new Figura()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarNovedad";
    }

    @PostMapping("/figuras/novedad/new/submit") // Cambio la URL de la anotación
    public String nuaevaMascotaSubmit(@ModelAttribute("novedad") Figura nuevaPersona) {
        log.info(nuevaPersona.toString());
        figuraServices.add(nuevaPersona);
        return "redirect:/inicio";
    }*/

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


/*
    @GetMapping("/detalle/onePiece/{id}")
    public String verDetallee(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> onePiece = figuraServices.findById(id);

        if (onePiece.isPresent()) {
            Figura  onePiece2 = onePiece.get();
            model.addAttribute("figura", onePiece2);
            return "html/inspeccionar/inspeccionarOnePiece"; // Devolver la vista de detalle
        } else {

            return "redirect:/inicio";
        }


    }




    @GetMapping("/figuras/onePiece/new")
    public String anuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("onePiece", new Figura()); // Cambio el nombre del objeto en el modelo
        return "/html/agregarFigura/agregarOnePiece";
    }

    @PostMapping("/figuras/onePiece/new/submit") // Cambio la URL de la anotación
    public String nuevaaaMascotaSubmit(@ModelAttribute("onePiece") Figura nuevaPersona) {
        log.info(nuevaPersona.toString());
        figuraServices.add(nuevaPersona);
        return "redirect:/inicio";
    }*/

}
