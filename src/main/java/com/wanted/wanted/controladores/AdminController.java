package com.wanted.wanted.controladores;

import com.wanted.wanted.entidades.DragonBall;
import com.wanted.wanted.entidades.Naruto;
import com.wanted.wanted.entidades.OnePiece;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Null;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wanted.wanted.entidades.Figura;
import com.wanted.wanted.servicios.DragonBallServices;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.NarutoServices;
import com.wanted.wanted.servicios.NovedadServices;
import com.wanted.wanted.servicios.OnePieceServices;

@RequiredArgsConstructor
@Slf4j
@Controller
public class AdminController {

    private final FiguraServices figuraServices;
    private final NovedadServices novedadServices;
    private final OnePieceServices onePieceServices;
    private final NarutoServices narutoServices;
    private final DragonBallServices dragonBallServices;

    @GetMapping("/admin/pagina")
    public String inicio(Model model) {
        model.addAttribute("listaFigura", figuraServices.findAll());
        model.addAttribute("novedadFigura", novedadServices.findAll());
        model.addAttribute("onePiece", onePieceServices.findAll());
        model.addAttribute("naruto", narutoServices.findAll());
        model.addAttribute("dragonBall", dragonBallServices.findAll());
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
        Optional<OnePiece> onePiece1 = onePieceServices.findById(id);

        if (onePiece1.isPresent()) {

            OnePiece onePiece = onePiece1.get();
            moddel.addAttribute("onePiece", onePiece);

            return "html/editarFigura/editarOnePiece";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/onePiece/submit")
    public String editarSubmit1(@Valid @ModelAttribute("onePiece") OnePiece onePiece, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarOnePiece";
        }
        onePieceServices.edit(onePiece);

        return "redirect:/admin/pagina";

    }

    // Editar Dragon Ball Z

    @GetMapping("/edit/dragonBall/{id}")
    public String editar2(@PathVariable Long id, Model moddel) {
        Optional<DragonBall> dragonBall1 = dragonBallServices.findById(id);

        if (dragonBall1.isPresent()) {

            DragonBall dragonBall = dragonBall1.get();
            moddel.addAttribute("dragonBall", dragonBall);

            return "html/editarFigura/editarDragonBall";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/dragonBall/submit")
    public String editarSubmit2(@Valid @ModelAttribute("dragonBall") DragonBall dragonBall,
            BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarDragonBall";
        }
        dragonBallServices.edit(dragonBall);

        return "redirect:/admin/pagina";

    }
    // Aqui empieza lo de naruto

    @GetMapping("/edit/naruto/{id}")
    public String editar3(@PathVariable Long id, Model moddel) {
        Optional<Naruto> naruto1 = narutoServices.findById(id);

        if (naruto1.isPresent()) {

            Naruto naruto = naruto1.get();
            moddel.addAttribute("naruto", naruto);

            return "html/editarFigura/editarNaruto";
        } else {

            // el fallo puede estar aqui de por qu ete crea cosas nuevas
            return "redirect:/admin/pagina";
        }

    }

    @PostMapping("/edit/naruto/submit")
    public String editarSubmit3(@Valid @ModelAttribute("naruto") Naruto naruto, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "editarNaruto";
        }
        narutoServices.edit(naruto);

        return "redirect:/admin/pagina";

    }

    @GetMapping("/figuras/delete/{id}")
    public String borrarMascota(@PathVariable("id") Long id, Model model) {

        Optional<Figura> figura = figuraServices.findById(id);
        Optional<OnePiece> onePiece = onePieceServices.findById(id);
        Optional<DragonBall> dragonBall = dragonBallServices.findById(id);
        Optional<Naruto> naruto = narutoServices.findById(id);
        if (figura != null || onePiece != null || dragonBall != null || naruto != null)
            figuraServices.delete(figura.get());
        onePieceServices.delete(onePiece.get());
        dragonBallServices.delete(dragonBall.get());
        narutoServices.delete(naruto.get());
        return "redirect:/admin/pagina";
    }

}
