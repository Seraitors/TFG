package com.wanted.wanted.controladores;

import com.wanted.wanted.entidades.Usuario;
import com.wanted.wanted.servicios.UsuarioServices;
import com.wanted.wanted.servicios.VentasServices;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

import com.wanted.wanted.entidades.Figura;

import com.wanted.wanted.servicios.FiguraServices;


@RequiredArgsConstructor
@Slf4j
@Controller
public class AdminController {

    private final FiguraServices figuraServices;
    private final UsuarioServices  usuarioServices;
    private final VentasServices ventasServices;

    @GetMapping("/admin/pagina")
    public String inicio(Model model) {

        List<Figura> figuras = figuraServices.getFigurasByCategoria("dragon-ball");
        List<Figura> figuras1 = figuraServices.getFigurasByCategoria("naruto");
        List<Figura> figuras2 = figuraServices.getFigurasByCategoria("one-piece");
        model.addAttribute("listaDragonBall", figuras);
        model.addAttribute("listaNaruto", figuras1);
        model.addAttribute("listaOnePiece", figuras2);

        return "html/adminMonitorizar/admin";

    }

    /* Editar Figuras de inicio */

    @GetMapping("/edit/{id}")
    public String editar(@PathVariable Long id, Model moddel) {
        Optional<Figura> figura1 = figuraServices.findById(id);

        if (figura1.isPresent()) {

            Figura figura = figura1.get();
            moddel.addAttribute("figura", figura);

            return "html/editarFigura/editarFigura";
        } else {


            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/submit")
    public String editarSubmit(@Valid @ModelAttribute("figura") Figura figura, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "html/editarFigura/editarFigura";
        }
        figuraServices.edit(figura);

        return "redirect:/admin/pagina";

    }

    /*Usuario*/

    @GetMapping("/admin/usuario")
    public  String paginaUsuario( Model model){
        model.addAttribute("usuario" , usuarioServices.findAll());
        model.addAttribute("ventas",ventasServices.findAll());

        return "html/adminMonitorizar/adminUsuario";

    }

    @GetMapping("/edit/usuario/{id}")
    public String editarUsuario(@PathVariable Long id, Model moddel) {
        Optional<Usuario> usuario = usuarioServices.findById(id);

        if (usuario.isPresent()) {

            Usuario usuario1 = usuario.get();
            moddel.addAttribute("usuario", usuario1);

            return "html/editarFigura/editarUsuario";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/usuario/submit")
    public String editarSubmitUsuario(@Valid @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarUsuario";
        }
        usuarioServices.edit(usuario);

        return "redirect:/admin/pagina";

    }



    @GetMapping("/figuras/delete/{id}")
    public String borrarTodo(@PathVariable("id") Long id, Model model) {
        Optional<Figura> figura = figuraServices.findById(id);
        Optional<Usuario> usuario = usuarioServices.findById(id);

        if (figura.isPresent()) {
            figuraServices.delete(figura.get());
        }

        if (usuario.isPresent()) {
            usuarioServices.delete(usuario.get());
        }

        return "redirect:/admin/pagina";
    }



}






