import java.sql.Array;
import java.util.*;

public enum PlateauJeu {

    PLATEAU;

    class PlateauMrJack {
        private final AlibiName[][] tableau = new AlibiName[3][3]; // Initialise un tableau vide 3X3
        private final Detective[][] tableau2 = new Detective[5][5];

        public PlateauMrJack(AlibiName[] alibis, Detective[] detectives) {
            for (AlibiName alibi : alibis) {         // Pour toutes les cellules de la liste,
                Position p = alibi.getPosition();    // On attribue une position p
                tableau[p.getLigne()][p.getColonne()] = alibi;
            }
            for (Detective detective : detectives) {
                Position p = detective.getPosition();
                tableau2[p.getLigne()][p.getColonne()] = detective;
            }
        }

        public AlibiName getAlibi(int x, int y) { // Méthode qui retourne la position des alibis
            return tableau[x][y];

        }

        public AlibiName[][] getTableau() {
            return tableau.clone();
            //List<Detective> detectives
        }


        public Set<PositionableObject>[][] getExtendedBoard() {
            HashSet<PositionableObject>[][] board = new HashSet[5][5];


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) { //Initialise le tableau sans valeurs à l'intérieur des cellules
                    board[i][j] = new HashSet<>();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i + 1][j + 1].add(this.tableau[i][j]); // Initialise le tableau avec les emplacements des alibis
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (tableau2[i][j] == Detective.HOLMES) {
                        board[i][j].add(this.tableau2[i][j]);
                    } else if (tableau2[i][j] == Detective.TOBY) {
                        board[i][j].add(this.tableau2[i][j]);
                    } else if (tableau2[i][j] == Detective.WATSON) {
                        board[i][j].add(this.tableau2[i][j]);
                    }
                }
            }
            return board.clone();
        }
    }

    public PlateauMrJack currentBoard;


    int tourCount;

    PlateauJeu() {
        AlibiName.placerAlibi(); // place les alibis dans un ordre aléatoire
        Detective.placerDetective(); // place les detectives
        PlayerMrJack.setMrJackCard();
        updateBoard();
        printBoard();
        while (tourCount <= 8 && PlayerMrJack.getSablier() <= 6){ // Rajouter condition (que la carte piochée par MrJack ne soit pas la seule visible par les detectives);

            if (tourCount % 2 != 0){
                Tour action = new TourImpair();



                // Detective qui commence
            }
            else {
                Tour action = new TourPair();
               // MrJack qui commence

            }
        }




    }

    public void updateBoard() {

        this.currentBoard = new PlateauMrJack(AlibiName.values(), Detective.values());
    }

    public void printBoard() {
        for (Set<PositionableObject>[] ligne : currentBoard.getExtendedBoard()) {
            System.out.println(" ");
            for (Set<PositionableObject> cell : ligne) {
                System.out.print(cell +" ");
            }
        }
    }
    public void askMove(){

    }
}



