package pl.robertburek.kursspring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.PlayerInformation;
import pl.robertburek.kursspring.domain.Quest;
import pl.robertburek.kursspring.services.KnightService;
import pl.robertburek.kursspring.services.QuestService;

import java.util.List;

/**
 * Created by Robert Burek
 */

@Controller
public class QuestController {

    @Autowired
    KnightService knightService;

    @Autowired
    QuestService questService;

    @Autowired
    PlayerInformation playerInformation;

    @RequestMapping("/assignquest")
    public String assignQuest(@RequestParam("knightId") Integer id, Model model) {
        Knight knight = knightService.getKnight(id);
        List<Quest> notStartedQuests = questService.getAllNotStartedQuests();
        model.addAttribute("knight", knight);
        model.addAttribute("notStartedQuests", notStartedQuests);
        return "assignquest";
    }

    @RequestMapping(value = "/assignquest", method = RequestMethod.POST)
    public String assignQuest(Knight knight) {
        knightService.updateKnight(knight);
        Quest quest = knight.getQuest();
        questService.update(quest);
        return "redirect:/knights";
    }

    @RequestMapping(value = "/checkQuests")
    public String checkQuest() {
        knightService.getMyGold();
        return "redirect:/knights";
    }
}
