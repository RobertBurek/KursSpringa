package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */

public class Quest {

    private String description;

    public Quest() {
        this.description = "Uratuj wszystkie księżniczki.";
    }

    public Quest(String tresc) {
        this.description = tresc;
    }

    @Override
    public String toString() {
        return description;
    }
}
