package pl.robertburek.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.robertburek.kursspring.components.TimeComponent;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.PlayerInformation;
import pl.robertburek.kursspring.services.KnightService;

import javax.validation.Valid;
import java.util.List;

/**
 * Created by Robert Burek
 */

@Controller
public class KnightController {

    @Autowired
    TimeComponent timeComponent;

    @Autowired
    PlayerInformation playerInformation;

    @Autowired
    KnightService service;

    @RequestMapping("/knights")  //defaultowo metoda przesyłudanych z formularza jest ustawiona na GET
    public String getKnights(Model model) {
        List<Knight> allKnights = service.getAllKnights();
        model.addAttribute("knights", allKnights);
        model.addAttribute("powitanie", "Witaj Robercie w WEB SPRINGU");
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knights";
    }

    @RequestMapping("/knight")
    public String getKnight(@RequestParam("id") Integer id, Model model) {
        Knight knight = service.getKnight(id);
        model.addAttribute("knight", knight);
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knight";
    }

    @RequestMapping("/newknight")
    public String createKnight(Model model) {
        model.addAttribute("knight", new Knight());
        model.addAttribute("timecomponent", timeComponent);
        model.addAttribute("playerinformation", playerInformation);
        return "knightform";
    }

    @RequestMapping(value = "/knights", method = RequestMethod.POST)  //ustawienie przesyłu dnych z formularza na POST
    public String saveKnight(@Valid Knight knight, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            System.out.println("Błędnie wypełniony formularz!!!");
            bindingResult.getAllErrors().forEach(error -> {
                System.out.println(error.getObjectName() + " " + error.getDefaultMessage());
            });
            return "knightform";
        } else {
            service.saveKnight(knight);
            return "redirect:/knights";
        }
    }

    @RequestMapping(value = "/knight/delete/{id}")  //id przekazane za pomocą danych w URL
    public String deleteKnight(@PathVariable("id") Integer id) {
        service.removeKnight(id);
        return "redirect:/knights";
    }

}
