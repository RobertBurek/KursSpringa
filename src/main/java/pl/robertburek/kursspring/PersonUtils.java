package pl.robertburek.kursspring;

/**
 * Created by Robert Burek
 */
public class PersonUtils {

    public final String operacja(Person person) {
        return person.name.toUpperCase();
    }
    // same metody bez pół to klasa bezstanowa, bez zależności
}
