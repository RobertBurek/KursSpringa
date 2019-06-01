package pl.robertburek.kursspring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import pl.robertburek.component.TestComponent;
import pl.robertburek.kursspring.domain.Castle;
import pl.robertburek.kursspring.domain.Knight;
import pl.robertburek.kursspring.domain.Quest;

@SpringBootApplication
// 1) sposób wskazania miejsca komponentów poprzez @ComponentScan({,,,})
//@ComponentScan({"pl.robertburek.kursspring","pl.robertburek.component","pl.robertburek"})  // ścieżka przeszukiwań
// komponentów przez springa, może być lista folderów albo jakiś wyższy folder
// 2) sposób wskazania miejsca komponentów poprzez @ComponentScan(basePackageClass={*.class,*.class,*.class})
@ComponentScan(basePackageClasses ={Starter.class, Castle.class, Knight.class, Quest.class, TestComponent.class})
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
