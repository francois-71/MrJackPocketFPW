import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class JetonEchangeTuile extends Jeton{

    String nomPiece1;
    String nomPiece2;

    @Override
    public void action() {
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values()); // ici faux, car la liste ne tient pas compte des eventuels joueurs qui ont été sup avant

        do{
            System.out.println("Saisir l'alibi à déplacer"); //TODO Remplacer nomPiece1, nomPiece2 par un scanner(les noms sont fixés pour tester la classe avec JUNIT);
            nomPiece1 = "STEALTHY";

        } while(!listAlibis.toString().contains(nomPiece1));
        do{
            //System.out.println("Saisir le nom de l'alibi avec lequel vous souhaitez échanger la place");
            nomPiece2 = "LANE";

        } while((nomPiece2 == nomPiece1) || (!listAlibis.toString().contains(nomPiece2))); // Faux, car peut échanger avec une carte retourné

        AlibiName.echangerPositionAlibi(AlibiName.valueOf(nomPiece1), AlibiName.valueOf(nomPiece2));
    }

}