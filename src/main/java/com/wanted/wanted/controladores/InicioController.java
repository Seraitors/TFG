package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.FiguraServices;


import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
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

    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {

        Optional<Figura> figura = figuraServices.findById(id);

        if (figura.isPresent()) {
            Figura figura2 = figura.get();
             model.addAttribute("figura", figura2);
               return "html/inspeccionar/inspeccionar";
        }else{

            return "redirect:/inicio";
        }


    }


    @GetMapping("/figuras/new")
    public String nuevaFigura(Model model) {
        log.info("Estoy en nuevaFigura");
        model.addAttribute("figuraDTO", new Figura());
        return "html/agregarFigura/agregar";
    }


    @PostMapping("figura/new/submit")
    public String submitNewFigura(@RequestParam("file") MultipartFile file, @ModelAttribute("figuraDTO") Figura figuraDTO, BindingResult result, Model model) {
        if (file.isEmpty()) {
            result.rejectValue("url", "file.empty", "El archivo de imagen es requerido");
            return "html/agregarFigura/agregar";
        }

        try {
            String fileName = file.getOriginalFilename();
            String uploadDir = new File("src/main/resources/static/imagen/fotosDragonBall/").getAbsolutePath();

            // Crear el directorio si no existe
            File dir = new File(uploadDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            // Guardar el archivo en el servidor
            File dest = new File(uploadDir + File.separator + fileName);
            file.transferTo(dest);

            // Establecer la URL del archivo subido en el DTO
            figuraDTO.setUrl("/imagen/fotosDragonBall/" + fileName);

            // Guardar el resto de la información
            figuraServices.save(figuraDTO);
            return "redirect:/inicio";
        } catch (IOException e) {
            log.error("Error al subir el archivo", e);
            result.rejectValue("url", "file.upload.error", "Error al subir el archivo");
            return "html/agregarFigura/agregar";
        }
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
        return "html/lista";
    }


    @GetMapping("/comprar")
    public  String comprar(){


        return "html/comprar/stripe";
    }




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



    @GetMapping("/DragonBall")
    public String inicioOnePiece(Model model) {

        List<Figura> figuras = figuraServices.getFigurasByCategoria("dragon-ball");
        model.addAttribute("listaDragonBall", figuras);
        return "html/dragonBall/index";
    }




    @GetMapping("/Naruto")
    public String inicioOnePipece(Model model) {
        List<Figura> figuras = figuraServices.getFigurasByCategoria("naruto");
        model.addAttribute("listaNaruto", figuras);

        return "html/naruto/index";
    }


    @GetMapping("/OnePiece")
    public String inicioOneoPiece(  Model model) {
        List<Figura> figuras = figuraServices.getFigurasByCategoria("one-piece");
        model.addAttribute("listaOnePiece", figuras);

        return "html/onePiece/index";
    }




}
