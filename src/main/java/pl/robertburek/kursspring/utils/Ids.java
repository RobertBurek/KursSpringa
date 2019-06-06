package pl.robertburek.kursspring.utils;

import java.util.Set;

/**
 * Created by Robert Burek
 */
public class Ids {

    static public int generateNewId(Set<Integer> existingIds) {
        if (existingIds.isEmpty()) {
            return 0;
        } else {
            Integer newId = existingIds.stream().max((o1, o2) -> o1.compareTo(o2)).get();
            return newId + 1;
        }
    }
}
