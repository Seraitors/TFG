package com.wanted.wanted.controladores;

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

import java.util.Optional;

import com.wanted.wanted.entidades.Figura;

import com.wanted.wanted.servicios.FiguraServices;


@RequiredArgsConstructor
@Slf4j
@Controller
public class AdminController {

    private final FiguraServices figuraServices;

    @GetMapping("/admin/pagina")
    public String inicio(Model model) {
        model.addAttribute("listaFigura", figuraServices.findAll());
        model.addAttribute("novedadFigura", figuraServices.findAll());
        model.addAttribute("onePiece", figuraServices.findAll());
        model.addAttribute("naruto", figuraServices.findAll());
        model.addAttribute("dragonBall", figuraServices.findAll());
        log.info("paso por administrador");

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
            return "editarFigura";
        }
        figuraServices.edit(figura);

        return "redirect:/admin/pagina";

    }

    /* Editar One piece */

    @GetMapping("/edit/onePiece/{id}")
    public String editar1(@PathVariable Long id, Model moddel) {
        Optional<Figura> onePiece1 = figuraServices.findById(id);

        if (onePiece1.isPresent()) {

            Figura onePiece = onePiece1.get();
            moddel.addAttribute("onePiece", onePiece);

            return "html/editarFigura/editarOnePiece";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/onePiece/submit")
    public String editarSubmit1(@Valid @ModelAttribute("onePiece") Figura onePiece, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarOnePiece";
        }
        figuraServices.edit(onePiece);

        return "redirect:/admin/pagina";

    }

    // Editar Dragon Ball Z

    @GetMapping("/edit/dragonBall/{id}")
    public String editar2(@PathVariable Long id, Model moddel) {
        Optional<Figura> dragonBall1 = figuraServices.findById(id);

        if (dragonBall1.isPresent()) {

            Figura dragonBall = dragonBall1.get();
            moddel.addAttribute("dragonBall", dragonBall);

            return "html/editarFigura/editarDragonBall";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/dragonBall/submit")
    public String editarSubmit2(@Valid @ModelAttribute("dragonBall") Figura dragonBall,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarDragonBall";
        }
        figuraServices.edit(dragonBall);

        return "redirect:/admin/pagina";

    }
    // Aqui empieza lo de naruto

    @GetMapping("/edit/naruto/{id}")
    public String editar3(@PathVariable Long id, Model moddel) {
        Optional<Figura> naruto1 = figuraServices.findById(id);

        if (naruto1.isPresent()) {

            Figura naruto = naruto1.get();
            moddel.addAttribute("naruto", naruto);

            return "html/editarFigura/editarNaruto";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/naruto/submit")
    public String editarSubmit3(@Valid @ModelAttribute("naruto") Figura naruto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarNaruto";
        }
        figuraServices.edit(naruto);

        return "redirect:/admin/pagina";

    }

    @GetMapping("/figuras/delete/{id}")
    public String borrarTodo(@PathVariable("id") Long id, Model model) {

        Optional<Figura> figura = figuraServices.findById(id);
        Optional<Figura> onePiece = figuraServices.findById(id);
        Optional<Figura> dragonBall = figuraServices.findById(id);
        Optional<Figura> naruto = figuraServices.findById(id);
        if (figura != null || onePiece != null || dragonBall != null || naruto != null)
            figuraServices.delete(figura.get());
        figuraServices.delete(onePiece.get());
        figuraServices.delete(dragonBall.get());
        figuraServices.delete(naruto.get());
        return "redirect:/admin/pagina";
    }

}
