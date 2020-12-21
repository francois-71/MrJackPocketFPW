import org.junit.jupiter.api.Test;


class PlateauJeuTest {
    @Test

    void PlateauJeu() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();
        AlibiName.echangerPositionAlibi(AlibiName.LESTRADE, AlibiName.STEALTHY);
        monJeu.updateBoard();
        monJeu.printBoard();
    }
}