import java.util.*;

public class PlateauJeu {

    private AlibiName[][] tableau = new AlibiName[3][3]; // INITIALISE UN TABLEAU VIDE 3X3
    private final ArrayList<AlibiName> listAlibis; // ON CREER UNE ARRAYLIST DE TYPE ALIBINAME

    public PlateauJeu() {
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values()); // ON CREER UNE LISTE DE TOUS LES ALIBIS
        Collections.shuffle(listAlibis); // ON MELANGE AU HASARD CETTE LISTE
        this.listAlibis = new ArrayList(listAlibis); //
    }

    public AlibiName[][] printBoard() {
        int k = 0;
        for (int i = 0; i <= 2; i++) {
            for (int j = 0; j <= 2; j++) {
                tableau[i][j] = listAlibis.get(k); // PLACE UN ALIBI PAR CASE
                k += 1;
            }
        }
        for (AlibiName[] line : tableau) { // PRINT DU TABLEAU
            for (AlibiName cell : line) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
        return null;
    }



}