import java.util.*;

public enum PlateauJeu {

    PLATEAU;
    class PlateauJack{
        private AlibiName[][] tableau = new AlibiName[3][3]; // INITIALISE UN TABLEAU VIDE 3X3

        public PlateauJack(AlibiName[] alibis) {
            for (AlibiName alibi : alibis) {
                Position p = alibi.getPosition();
                tableau[p.getLigne()][p.getColonne()] = alibi;
            }

        }
        public AlibiName getAlibi(int x, int y){
            return tableau[x][y];

        }

        public AlibiName[][] getTableau() {
            return tableau.clone();
        }
        public Optional<PositionableObject>[][] getExtentedBoard(List<Detective> detectives){
            Object[][] board = new Object[5][5];
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    board[i][j]=Optional.empty();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i+1][j+1] = Optional.of(this.tableau[i][j]);

                }
            }
            return (Optional<PositionableObject>[][]) board.clone();
        }
    }

    private PlateauJack currentBoard;
    PlateauJeu() {
        AlibiName.shuffle();
        updateBoard();
    }
    public void updateBoard(){
        this.currentBoard = new PlateauJack(AlibiName.values());
    }

    public void printBoard() {
        for (AlibiName[] ligne : currentBoard.getTableau())
            System.out.println(Arrays.toString(ligne));

        }

}
