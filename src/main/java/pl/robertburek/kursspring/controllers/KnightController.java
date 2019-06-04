package pl.robertburek.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
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

    @RequestMapping("/knights")  //defaultowo metoda przesyłudanych z formularza jest ustawiona na GET
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("powitanie", "Witaj Robercie w WEB SPRINGU");
        return "knights";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        return "knightform";
    }

    @RequestMapping(value="/knights", method = RequestMethod.POST)  //ustawienie przesyłu dnych z formularza na POST
    public String saveKnight(Knight knight) {
        service.saveKnight(knight);
        return "redirect:/knights";
    }

}
