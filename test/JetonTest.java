import org.junit.jupiter.api.Test;

import java.util.List;


class JetonTest {
    @Test

    void Jeton() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();
        JetonRotationTuile a = new JetonRotationTuile();
        a.action();
        //AlibiName.echangerPosition(AlibiName.LESTRADE, AlibiName.STEALTHY);
        monJeu.updateBoard();
        monJeu.printBoard();
    }
}