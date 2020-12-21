import java.util.*;

public enum AlibiName implements PositionableObject{
    LESTRADE(0,0),
    STEALTHY(1,0),
    BERT(1,0),
    PIZER(1,0),
    SMITH(1,0),
    LANE(1,0),
    MADAME(2,0),
    GOODLEY(0,0),
    GULL(1,0);

    private final int sabliers;
    private final int image; // TODO ajouter les images
    private Optional<Position> position;

    AlibiName(int sabliers, int image) {
        this.sabliers = sabliers;
        this.image = image;
        this.position = Optional.empty();
    }

    public static void echangerPositionAlibi(AlibiName p1, AlibiName p2) {
        Position x1 = p1.getPosition();
        Position x2 = p2.getPosition();
        p2.setPosition(x1);
        p1.setPosition(x2);
    }

    public int getSabliers() {
        return sabliers;
    }

    public int getImage() {
        return image;
    }

    public AlibiName setPosition(Position p){
        this.position = Optional.of(p);
        return this;
    }

    public Position getPosition(){
        if (!this.position.isPresent()) throw new UnsupportedOperationException("Erreur le joueur n'a pas de position");
        return this.position.get();
    }

    public static AlibiName[] shuffle(){
        List<AlibiName> listeAlibi = Arrays.asList(values());
        Collections.shuffle(listeAlibi);
        ArrayDeque<AlibiName> deck = new ArrayDeque(listeAlibi);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                deck.pollFirst().setPosition(new Position(i,j));
            }
        }
        return values();
    }
}
