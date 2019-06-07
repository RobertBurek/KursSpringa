package pl.robertburek.kursspring.domain;

import org.springframework.stereotype.Component;

/**
 * Created by Robert Burek
 */

@Component
//@Scope(value = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class PlayerInformation {

    private int gold = 0;

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
