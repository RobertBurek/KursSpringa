package pl.robertburek.kursspring;

/**
 * Created by Robert Burek
 */

//singleton stworzony na podstawie enuma
//ponoć najlepsze rozwiązanie

public enum PersonUtilsSingletonNew {

    INSTANCE;

    public final String operacja(Person person) {
        return person.name.toUpperCase();
    }
}
