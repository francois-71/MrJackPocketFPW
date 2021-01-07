import java.util.*;

public enum Detective implements PositionableObject {
    HOLMES(0),
    WATSON(0),
    TOBY(0);

    private final int image;
    private Optional<Position> position;

    Detective(int image) {
        this.image = image;
        this.position = Optional.empty();
    }

    public Detective setPosition(Position p) {
        this.position = Optional.of(p);
        return this;

    }
    public Position getPosition(){
        if (!this.position.isPresent()) throw new UnsupportedOperationException("Erreur le joueur n'a pas de position");
        return this.position.get();
    }


    public int getImage() {
        return image;
    }
    public static Detective[] placerDetective(){
        Detective.HOLMES.setPosition(new Position(1,0, Position.Sens.WEST, Position.Returned.INGAME));
        Detective.WATSON.setPosition(new Position(1,4,Position.Sens.EAST, Position.Returned.INGAME));
        Detective.TOBY.setPosition(new Position(4,2,Position.Sens.SOUTH, Position.Returned.INGAME));
        return values();
    }

    public static void move1of3Characters(Detective p1, int mouvement){

        Position x1 = p1.getPosition();
        if (mouvement == 1){
            if (x1.getLigne() == 1 && x1.getColonne() == 0){
                x1.setLigne(0);
                x1.setColonne(1);
            }
            else if (x1.getLigne() == 0 && x1.getColonne() == 1){
                x1.setLigne(0);
                x1.setColonne(2);
            }
            else if (x1.getLigne() == 0 && x1.getColonne() == 2){
                x1.setLigne(0);
                x1.setColonne(3);
            }
            else if (x1.getLigne() == 0 && x1.getColonne() == 3) {
                x1.setLigne(1);
                x1.setColonne(4);
            }
            else if (x1.getLigne() == 1 && x1.getColonne() == 4){
                x1.setLigne(2);
                x1.setColonne(4);
            }
            else if (x1.getLigne() == 2 && x1.getColonne() == 4){
                x1.setLigne(3);
                x1.setColonne(4);
            }
            else if (x1.getLigne() == 3 && x1.getColonne() == 4){
                x1.setLigne(4);
                x1.setColonne(3);
            }
            else if (x1.getLigne() == 4 && x1.getColonne() == 3){
                x1.setLigne(4);
                x1.setColonne(2);
            }
            else if (x1.getLigne() == 4 && x1.getColonne() == 2){
                x1.setLigne(4);
                x1.setColonne(1);
            }
            else if (x1.getLigne() == 4 && x1.getColonne() == 1){
                x1.setLigne(3);
                x1.setColonne(0);
            }
            else if (x1.getLigne() == 3 && x1.getColonne() == 0){
                x1.setLigne(2);
                x1.setColonne(0);
            }
            else if (x1.getLigne() == 2 && x1.getColonne() == 0){
                x1.setLigne(1);
                x1.setColonne(0);
            }
        }
    }
    public static void deplacerDetective(Detective d) {
        Position x1 = d.getPosition();
    }


}



