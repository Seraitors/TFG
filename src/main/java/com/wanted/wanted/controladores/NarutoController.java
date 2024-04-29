package com.wanted.wanted.controladores;



import com.wanted.wanted.servicios.NarutoServices;
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
public class NarutoController {

    private final NarutoServices narutoServices;

    @GetMapping("/Naruto")
    public String inicioOnePiece(Model model) {

        model.addAttribute("listaNaruto", narutoServices.findAll());

        return "html/naruto/index";
    }

}
