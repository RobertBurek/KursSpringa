package pl.robertburek.kursspring.domain;

/**
 * Created by Robert Burek
 */

public class Castle {

    Knight knight;
    private String name;

    public Castle(Knight knight) {
        this.knight = knight;
    }

    Castle(Knight knight, String name) {
        this.knight = knight;
        this.name = name;
    }

    public void build() {
        System.out.println("Wybudowano zamek " + name);
    }

    public void tearDown() {
        System.out.println("Zaraz wyburzymy zamek " + name);
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Znajduje się tu zamek o nazwie " + this.name + ". Zamieszkuje go " + knight;
    }
}
