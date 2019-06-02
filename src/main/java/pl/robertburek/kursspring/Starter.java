package pl.robertburek.kursspring;

import org.springframework.boot.CommandLineRunner;
import pl.robertburek.kursspring.domain.Castle;

/**
 * Created by Robert Burek
 */

public class Starter implements CommandLineRunner {

    Castle castle;

    public void setCastle(Castle castle) {
        this.castle = castle;
    }

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);

    }
}
