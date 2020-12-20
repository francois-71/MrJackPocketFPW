import org.junit.jupiter.api.Test;

import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

class PileAlibiTest {

    @Test
    void tirerUneCarte() {
        PileAlibi pile = new PileAlibi();
        System.out.println(pile.tirerUneCarte());
    }
}