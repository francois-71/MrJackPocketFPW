import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class PileAlibi {

    public ArrayDeque<AlibiName> pile;

    public PileAlibi() {
        List<AlibiName> listeAlibi = Arrays.asList(AlibiName.values());
        Collections.shuffle(listeAlibi);
        this.pile = new ArrayDeque(listeAlibi);

    }
    public AlibiName tirerUneCarte(){
        return this.pile.pollFirst();
    }

    public ArrayDeque<AlibiName> getPile() {
        return pile;
    }
}
