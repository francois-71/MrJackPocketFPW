import org.junit.jupiter.api.Test;


class PlateauJeuTest {
    @Test

    void PlateauJeu() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();
        Jeton b = new JetonEchangeTuile();
        b.action();
        Jeton a = new JetonAlibi();
        a.action();
        monJeu.updateBoard();
        System.out.println(" ");
        monJeu.printBoard();



    }
}