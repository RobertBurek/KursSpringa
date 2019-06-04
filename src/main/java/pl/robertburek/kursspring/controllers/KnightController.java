package pl.robertburek.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.services.KnightService;

import java.util.List;

/**
 * Created by Robert Burek
 */

@Controller
public class KnightController {

    @Autowired
    KnightService service;

    @RequestMapping("/knights")
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("powitanie", "Witaj Robercie w WEB SPRINGU");
        return "knights";
    }

}
