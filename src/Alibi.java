// Type de structure de donnée ? Pile, arrayDeque
import java.util.ArrayDeque;

public enum Alibi {
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

    Alibi(int sabliers, int image) {
        this.sabliers = sabliers;
        this.image = image;
    }

    public int getSabliers() {
        return sabliers;
    }

    public int getImage() {
        return image;
    }
}
