package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Tournament;

/**
 * Created by Robert Burek
 */

@Component
//@Scope("singleton") domyslnie jest singleton
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Autowired
    Tournament tournament;

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);
        System.out.println(tournament);
//        tournament.duel();
        System.out.println("Jest już po turnieju!!!");
        System.out.println("Wygrał rycerz : " + tournament.getKnight());

        System.out.println("Stan zamku po turnieju : ");
        System.out.println(castle);

    }
}
