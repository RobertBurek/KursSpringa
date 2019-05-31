package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */
public class Quest {

    private String description;

    public Quest(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}
