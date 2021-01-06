import org.junit.jupiter.api.Test;

import java.util.List;


class JetonTest {
    @Test

    void Jeton() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();
        JetonEchangeTuile a = new JetonEchangeTuile();
        a.action();
        //AlibiName.echangerPosition(AlibiName.LESTRADE, AlibiName.STEALTHY);
        monJeu.updateBoard();
        System.out.println(" ");
        monJeu.printBoard();
    }
}