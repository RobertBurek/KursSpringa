package pl.robertburek.kursspring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import pl.robertburek.component.TestComponent;
import pl.robertburek.kursspring.domain.Castle;

/**
 * Created by Robert Burek
 */

@Component
// wiele różnych adnotacji
//@Repository
//@Service
//@Controller
public class Starter implements CommandLineRunner {

    @Autowired
    TestComponent test;

    @Autowired
    Castle castle;

    @Override
    public void run(String... args) throws Exception {

        System.out.println(castle);

    }
}
