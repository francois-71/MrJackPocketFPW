import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PileAlibi {

    private final ArrayDeque<Alibi> pile;

    public PileAlibi() {
        List<Alibi> listeAlibi = Arrays.asList(Alibi.values());
        Collections.shuffle(listeAlibi);
        this.pile = new ArrayDeque(listeAlibi);

    }
    public Alibi tirerUneCarte(){
        return this.pile.pollFirst();
    }

}
