import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PlayerMrJack extends Player{


    private static AlibiName mrJackAlibiCard;
    public static int sablier;

    public static void setMrJackCard(){
        List<AlibiName> listeAlibi = Arrays.asList(AlibiName.values());
        Collections.shuffle(listeAlibi);
        ArrayDeque<AlibiName> deckTuiles = new ArrayDeque(listeAlibi);
        mrJackAlibiCard = deckTuiles.pollFirst();
    }
    public static AlibiName getMrJackCard(){
        return mrJackAlibiCard;
    }
    public static void sablierAddFinTour(){
        sablier += 1;
    }
    public static void sablierAddAlibi(AlibiName p1){
        sablier += p1.getSabliers();
    }
    public static int getSablier(){
        return sablier;

    }
}
