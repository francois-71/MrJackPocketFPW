public class Position {

    private int ligne;

    private int colonne;

    private Sens sens;

    private Returned etatTuile;

    public enum Sens {
        NORTH, SOUTH, EAST, WEST, AUCUN;
    }
    public enum Returned{
        INGAME, RETURNED, NONE;
    }

    public Position(int ligne, int colonne, Sens sens, Returned etatTuile) {
        this.ligne = ligne;
        this.colonne = colonne;
        this.sens = sens;
        this.etatTuile = etatTuile;
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

    public Returned getEtatTuile() {
        return etatTuile;
    }

    public void setEtatTuile(Returned etatTuile) {
        this.etatTuile = etatTuile;
    }


}