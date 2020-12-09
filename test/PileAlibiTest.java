import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PileAlibiTest {

    @Test
    void tirerUneCarte() {
        PileAlibi pile = new PileAlibi();
        System.out.println(pile.tirerUneCarte().ordinal());
    }
}