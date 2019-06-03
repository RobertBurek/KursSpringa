package pl.robertburek.kursspring;

/**
 * Created by Robert Burek
 */

//singleton to klasa której instancja może być tylko jedna
//poniższa klasa nie do końca jest singletonem można ją oszukać
//na przykład poprzez serialiację
// właściwszym rozwiązaniem będzie klasa PersonUtilsSingletonNew

public class PersonUtilsSingleton {

    private static PersonUtilsSingleton instance = null;

    private PersonUtilsSingleton() {
    }


    public PersonUtilsSingleton getInstance() {
        if (instance == null) {
            instance = new PersonUtilsSingleton();
        }
        return instance;
    }

    public final String operacja(Person person) {
        return person.name.toUpperCase();
    }
}
