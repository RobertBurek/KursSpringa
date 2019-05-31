package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

/**
 * Created by Robert Burek
 */

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    Castle castle;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);

        //wstrzykiwanie poprzez konstruktor
        Quest saveThePrincess = new Quest("Uratuj księżniczkę!!!");
        Knight lancelot = new Knight("Lancelot", 29, saveThePrincess);
        System.out.println(lancelot);

        //wstrzykiwanie poprze metodę
        Quest killTheDragon = new Quest("Zabij smoka!");
        Knight percival = new Knight("Percival", 31);
        System.out.println(percival);
        percival.setQuest(killTheDragon);
        System.out.println(percival);
    }
}
