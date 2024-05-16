package com.wanted.wanted.controladores;

import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;




import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wanted.wanted.servicios.DragonBallServices;
import com.wanted.wanted.servicios.FiguraServices;
import com.wanted.wanted.servicios.NarutoServices;
import com.wanted.wanted.servicios.NovedadServices;
import com.wanted.wanted.servicios.OnePieceServices;


@RequiredArgsConstructor
@Slf4j
@Controller
public class AdminController {



    private final FiguraServices   figuraServices;
    private final NovedadServices novedadServices;
    private final OnePieceServices onePieceServices;
    private final NarutoServices narutoServices ;
    private final DragonBallServices dragonBallServices;



        @GetMapping("/admin/pagina")
    public  String  inicio(Model model){
    model.addAttribute("listaFigura",figuraServices.findAll());
    model.addAttribute("novedadFigura", novedadServices.findAll());
    model.addAttribute("onePiece", onePieceServices.findAll());
    model.addAttribute("naruto", narutoServices.findAll());
    model.addAttribute("dragonBall", dragonBallServices.findAll());
        log.info("paso por administrador");

    return "html/adminMonitorizar/admin";




    }

    
    
}
