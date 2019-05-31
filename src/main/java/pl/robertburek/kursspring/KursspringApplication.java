package pl.robertburek.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class KursspringApplication {

    public static void main(String[] args) {
        //jeden ze sposobób odwołania się do kontekstu i kontenera w celu przywołania beana, dość rozbudowany - stary
//		ConfigurableApplicationContext ctx = SpringApplication.run(KursspringApplication.class, args);
//		Castle castle = (Castle)ctx.getBean("castle");
//		System.out.println(castle);
//		System.out.println(ctx);

        //drugi to w Starter robimy instancje klasy do której chcemy się odwołać
        // i oznaczamy ją @Autowired (depenndencie indection i kontener springowy działają)
        SpringApplication.run(KursspringApplication.class, args);
    }

}
