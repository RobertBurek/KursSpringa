package pl.robertburek.kursspring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.repository.KnightRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Robert Burek
 */

@Component
public class KnightService {

    @Autowired
    KnightRepository knightRepository;

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
}