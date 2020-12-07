public class Position {

    private int ligne;

    private int colonne;

    private int sens;

    public Position(int ligne, int colonne, int sens) {
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

    public int getSens() {
        return sens;
    }

    public void setSens(int sens) {
        this.sens = sens;
    }

    public boolean equals(Position position) {
        return position.getColonne() == this.getColonne()
                && position.ligne == this.ligne
                && position.sens == this.sens;

    }

}