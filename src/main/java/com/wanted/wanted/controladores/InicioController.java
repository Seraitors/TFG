package com.wanted.wanted.controladores;


import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.NovedadServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Slf4j
@Controller

public class InicioController {

    private final FiguraServices   figuraServices;

    private final NovedadServices novedadServices;





    @GetMapping({"/aaa" ,"/inicio"})
    public  String  inicio(Model model){
    model.addAttribute("listaFigura",figuraServices.findAll());
    model.addAttribute("novedadFigura", novedadServices.findAll());


    return "html/lista";


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

    //seguridad probar


/*

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

    @PostMapping("/logout")
    public String logout() {
        // En este método, puedes realizar cualquier limpieza o tareas adicionales necesarias para el logout
        return "redirect:/inicio"; // Redirige al usuario a la página de inicio de sesión después del logout
    }
*/


}
