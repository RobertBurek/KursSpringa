package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */

public class Quest {

    private String description;

    public Quest(String tresc) {
        this.description = tresc;
    }

    @Override
    public String toString() {
        return description;
    }
}
