package com.wanted.wanted.controladores;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.wanted.wanted.servicios.DragonBallServices;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@RequiredArgsConstructor
@Slf4j
@Controller
public class DragonBallController {
    



       private final DragonBallServices  dragonBallServices;

    @GetMapping("/DragonBall")
    public String inicioOnePiece(Model model) {

        model.addAttribute("listaDragonBall", dragonBallServices.findAll());

        return "html/dragonBall/index";
    }
}
