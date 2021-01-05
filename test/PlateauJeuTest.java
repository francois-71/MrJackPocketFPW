import org.junit.jupiter.api.Test;


class PlateauJeuTest {
    @Test

    void PlateauJeu() {
        PlateauJeu monJeu = PlateauJeu.PLATEAU;
        monJeu.printBoard();
        System.out.println(AlibiName.STEALTHY.getPosition().getSens() +" STEALTHY");
        System.out.println(AlibiName.SMITH.getPosition().getSens() + " SMITH");
        AlibiName.echangerPositionAlibi(AlibiName.SMITH, AlibiName.STEALTHY);
        monJeu.updateBoard();
        System.out.println(" ");
        monJeu.printBoard();
        System.out.println(AlibiName.STEALTHY.getPosition().getSens() +" STEALTHY");
        //System.out.println(AlibiName.MADAME.getPosition().getSens()+ " MADAME");
        //System.out.println(AlibiName.LESTRADE.getPosition().getSens() + " LESTRADE");
        System.out.println(AlibiName.GOODLEY.getPosition().getSens() + " GOODLEY");
        System.out.println(AlibiName.BERT.getPosition().getSens()+ " BERT");
        System.out.println(AlibiName.LANE.getPosition().getSens()+ " LANE");
        System.out.println(AlibiName.GULL.getPosition().getSens()+ " GULL");
        System.out.println(AlibiName.PIZER.getPosition().getSens() +" PIZER");
        System.out.println(AlibiName.SMITH.getPosition().getSens() + " SMITH");
        System.out.println("c'est beau");
        //System.out.println(AlibiName.PIZER.getPosition().setSens(Position.Sens.NORD));



    }
}