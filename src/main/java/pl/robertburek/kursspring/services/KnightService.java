package pl.robertburek.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.PlayerInformation;
import pl.robertburek.kursspring.domain.repository.KnightRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

/**
 * Created by Robert Burek
 */

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

    @Autowired
    PlayerInformation playerInformation;


    @RequestMapping("/knights")
    public List<Knight> getAllKnights() {
        return new ArrayList<>(knightRepository.getAllKnights());
    }

    public void saveKnight(Knight knight) {
        knightRepository.createKnight(knight);
    }

    public Knight getKnight(Integer id) {
        return knightRepository.getKnightById(id);
    }

    public void removeKnight(Integer id) {
        knightRepository.deleteKnight(id);
    }

    public void updateKnight(Knight knight) {
        knightRepository.updateKnight(knight.getId(), knight);
    }

    public int collectRewards() {
        Predicate<Knight> knightPredicate = knight -> {
            if (knight.getQuest() != null) {
                return knight.getQuest().isCompleted();
            } else {
                return false;
            }
        };
        int sum = knightRepository.getAllKnights().stream().filter(knightPredicate)
                .mapToInt(knight -> knight.getQuest().getReward()).sum();
        knightRepository.getAllKnights().stream().filter(knightPredicate)
                .forEach(knight -> knight.setQuest(null));
        return sum;
    }

    public void getMyGold() {
        List<Knight> allKnights = getAllKnights();
        allKnights.forEach(knight -> {
            if (knight.getQuest() != null) {
                knight.getQuest().isCompleted();
            }
        });
        int currentGold = playerInformation.getGold();
        playerInformation.setGold(currentGold + collectRewards());
    }
}