import java.util.*;

public enum PlateauJeu {

    PLATEAU;
    class PlateauMrJack{
        private AlibiName[][] tableau = new AlibiName[3][3]; // Initialise un tableau vide 3X3
        private Detective[][] tableau2 = new Detective[5][5];

        public PlateauMrJack(AlibiName[] alibis, Detective[] detectives) {     // Constructeur du tableau.
            for (AlibiName alibi : alibis) {         // Pour toutes les cellules de la liste,
                Position p = alibi.getPosition();    // On attribue une position p
                tableau[p.getLigne()][p.getColonne()] = alibi;
            }
            for (Detective detective: detectives){
                Position p = detective.getPosition();
                tableau2[p.getLigne()][p.getColonne()] = detective;
            }
        }
        public AlibiName getAlibi(int x, int y){ // Méthode qui retourne la position des alibis
            return tableau[x][y];

        }

        public AlibiName[][] getTableau() { // Méthode qui renvoie un clone du tableau
            return tableau.clone();
            //List<Detective> detectives
        }


        public Optional<PositionableObject>[][] getExtendedBoard() {
            Optional<PositionableObject>[][] board = new Optional[5][5]; // Crée un tableau de type Objet 5x5
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j] = Optional.empty(); // Initialise le tableau sans valeurs à l'intérieur des cellules
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i + 1][j + 1] = Optional.of(this.tableau[i][j]); // Initialise le tableau avec les emplacements des alibis
                }
            }
            for



            return board.clone();
        }
    }

    private PlateauMrJack currentBoard;

    PlateauJeu() {
        AlibiName.shuffle(); // place les alibis dans un ordre aléatoire
        Detective.placerDetective(); // place les detectives
        updateBoard();
    }
    public void updateBoard(){
        this.currentBoard = new PlateauMrJack(AlibiName.values(), Detective.values());
    }

    public void printBoard() {
        for (Optional<PositionableObject>[] ligne : currentBoard.getExtendedBoard())
            System.out.println(Arrays.toString(ligne));

        }

}
