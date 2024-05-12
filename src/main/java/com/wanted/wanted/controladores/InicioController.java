package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.entidades.UsuarioSeguridad;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.NovedadServices;

import com.wanted.wanted.servicios.UsuariosServicesSeguridad;
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

public class InicioController {

    private final FiguraServices   figuraServices;
    private final NovedadServices novedadServices;
    private final UsuariosServicesSeguridad usuariosServicesSeguridad;



    @GetMapping({"/" ,"/inicio"})
    public  String  inicio(Model model){
    model.addAttribute("listaFigura",figuraServices.findAll());
    model.addAttribute("novedadFigura", novedadServices.findAll());
    model.addAttribute("usuario", usuariosServicesSeguridad.findAll());

    return "html/lista";


    }
    @GetMapping("/detalle/{id}")
    public String verDetalle(@PathVariable("id") Long id, Model model) {
        // Obtener el objeto con el ID especificado y pasarlo al modelo
        Optional<Figura> figura = figuraServices.findById(id);
        model.addAttribute("figura", figura);
        return "html/inspeccionar"; // Devolver la vista de detalle
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

    //seguridad probar



    @GetMapping( "/inicioSesion")
    public  String inicio (){

        return "html/index";
    }

    @PostMapping("/inicioSesion/submit")
    public String inicioSesion(@ModelAttribute UsuarioSeguridad usuario, Model model) {
        if (usuario.getNombre().isEmpty() ) {
            model.addAttribute("errorNombre", "Credenciales inválidas");
        }

        if (usuario.getApellido().isEmpty()){
            model.addAttribute("errorApellido", "Credenciales inválidas");
        }
        if (usuario.getCorreo().isEmpty()){
            model.addAttribute("errorCorreo","Credenciales invalidas");
        }
        if (usuario.getContrasena().isEmpty()){
            model.addAttribute("errorContra","Credenciales invalidas");
        }

        if (model.containsAttribute("errorNombre") || model.containsAttribute("errorApellido") || model.containsAttribute("errorCorreo") || model.containsAttribute("errorContra") ) {

            return "html/index";
        } else {
            if (usuariosServicesSeguridad.validarusuario(usuario.getNombre(),usuario.getContrasena(), usuario.getCorreo())==true){
                return "redirect:/inicio";
            } else {
                model.addAttribute("errorValidacion","Credenciales invalidas");
                return "html/index";
            }

        }
    }


    @GetMapping("/registrarse")
    public String registro() {
        log.info(" estoy ne el get mapping");

        return "html/registro";
    }


    @PostMapping("/registrarse/submit")
    public String registrarUsuario(@ModelAttribute UsuarioSeguridad usuario, Model model) {
        if (usuario.getNombre().isEmpty() ) {
            model.addAttribute("errorNombre", "Credenciales inválidas");
        }

        if (usuario.getApellido().isEmpty()){
            model.addAttribute("errorApellido", "Credenciales inválidas");
        }
        if (usuario.getCorreo().isEmpty()){
            model.addAttribute("errorCorreo","Credenciales invalidas");
        }
        if (usuario.getContrasena().isEmpty()){
            model.addAttribute("errorContra","Credenciales invalidas");
        }

        if (model.containsAttribute("errorNombre") || model.containsAttribute("errorApellido") || model.containsAttribute("errorCorreo") || model.containsAttribute("errorContra") ) {

            return "html/registro";
        } else {
            //usuariosServices.addUser(usuario);
            usuariosServicesSeguridad.registarUSuario(usuario);
            return "html/index";
        }
    }

}
