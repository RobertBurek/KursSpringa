package pl.robertburek.kursspring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */

@Component
public class Hi implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        System.out.println("Witam w Świecie SPRINGa !!!");
    }
}
