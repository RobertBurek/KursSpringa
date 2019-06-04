package pl.robertburek.kursspring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Robert Burek
 */

@Controller
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "helloworld.html";
        // localhost8080/hello wyświetli plik helloworld.html, który jest w resources/static
    }

}
