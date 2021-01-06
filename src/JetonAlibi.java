import java.util.Arrays;
import java.util.List;

public class JetonAlibi extends Jeton{

    String nomPiece;

    @Override
    public void action() { // classe qui tourne la carte choisie.
        // Scanner scanner = new Scanner(System.in);
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());

        do{
            System.out.println("Saisir l'alibi à retourner"); //TODO Remplacer nomPiece1, nomPiece2 par un scanner(les noms sont fixés pour tester la classe avec JUNIT)
            nomPiece = "BERT";

        } while(!listAlibis.toString().contains(nomPiece));

        AlibiName.tournerTuile(AlibiName.valueOf(nomPiece));



    }



}
