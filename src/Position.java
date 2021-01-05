import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Position {

    private int ligne;

    private int colonne;

    private Sens sens;

    public Position(int ligne, int colonne, Sens sens) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.sens = sens;
    }


    public int getLigne() {
        return ligne;
    }

    public void setLigne(int ligne) {
        this.ligne = ligne;
    }

    public int getColonne() {
        return colonne;
    }

    public void setColonne(int colonne) {
        this.colonne = colonne;
    }

    public Sens getSens() {
        return sens;
    }

    public void setSens(Sens sens) {
        this.sens = sens;
    }

    public boolean equals(Position position) {
        return position.getColonne() == this.getColonne()
                && position.ligne == this.ligne
                && position.sens == this.sens;

    }

    public enum Sens {
        NORTH, SOUTH, EAST, WEST
    }
    public void shuffleSens() {
        List<Position.Sens> sensRandom = Arrays.asList(sens.values());
        Collections.shuffle(sensRandom);
        ArrayDeque<AlibiName> deck = new ArrayDeque(sensRandom);

    }
}