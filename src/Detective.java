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
        List <Detective> detectives = Arrays.asList(values());
        Detective.HOLMES.setPosition(new Position(1,0));
        Detective.WATSON.setPosition(new Position(1,4));
        Detective.TOBY.setPosition(new Position(4,2));
        return values();


    }
    public static void deplacerDetective(Detective d) {
        Position x1 = d.getPosition();


}



