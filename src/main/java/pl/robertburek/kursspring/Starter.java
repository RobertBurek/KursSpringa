package pl.robertburek.kursspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

/**
 * Created by Robert Burek
 */

@Component
public class Starter implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {

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
