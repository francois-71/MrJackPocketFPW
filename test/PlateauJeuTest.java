import org.junit.jupiter.api.Test;


class PlateauJeuTest {
    @Test

    void PlateauJeu() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();

        System.out.println(" ");

        /*


        Jeton b = new JetonEchangeTuile(); //correct
        b.action();
        Jeton a = new JetonAlibi();
        a.action();
        Jeton c = new JetonRotationTuile();
        c.action();

         */
        //Jeton d = new Jeton3Personnages();

        //d.action();

        //Jeton f = new JetonDeplacerWATSON();
        //f.action();







        //Jeton e = new JetonDeplacerHOLMES();
        //e.action();
        /*
        Jeton f = new JetonDeplacerWATSON();
        f.action();
        Jeton g = new JetonDeplacerTOBY();
        g.action();

         */






        //Jeton d = new Jeton3Personnages();
        //d.action();
        monJeu.updateBoard();
        Detective.isVisible(AlibiName.values());
        System.out.println(" ");
        monJeu.printBoard();



    }
}