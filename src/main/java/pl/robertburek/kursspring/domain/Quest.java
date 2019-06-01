package pl.robertburek.kursspring.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */
@Component
public class Quest {

    private String description;

    public Quest() {
        this.description = "Uratuj wszystkie księżniczki.";
    }

    @Override
    public String toString() {
        return description;
    }
}
