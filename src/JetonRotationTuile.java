import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class JetonRotationTuile extends Jeton{

    String nomPiece1;
    String nomPiece2;

    @Override
    public void action() {
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());
        do{
            System.out.println("Saisir l'alibi à déplacer");
            nomPiece1 = "BERT";

        } while(!listAlibis.toString().contains(nomPiece1));
        do{
            System.out.println("Saisir le nom de l'alibi avec lequel vous souhaitez échanger la place");
            nomPiece2 = "STEALTHY";

        } while((nomPiece2 == nomPiece1) || (!listAlibis.toString().contains(nomPiece2)));

        AlibiName.echangerPositionAlibi(AlibiName.valueOf(nomPiece1), AlibiName.valueOf(nomPiece2));
    }

}