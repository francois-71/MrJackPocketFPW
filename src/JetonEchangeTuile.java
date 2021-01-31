import org.w3c.dom.ls.LSOutput;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class JetonEchangeTuile extends Jeton{

    String nomPiece1;
    String nomPiece2;
    Scanner scanner = new Scanner(System.in);
    @Override
    public void action() {
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());

        do{
            System.out.println("Saisir l'alibi à déplacer"); //TODO Remplacer nomPiece1, nomPiece2 par un scanner(les noms sont fixés pour tester la classe avec JUNIT);
            nomPiece1 = scanner.nextLine().toUpperCase();

        } while(!listAlibis.toString().toUpperCase().contains(nomPiece1));

        do{
            System.out.println("Saisir le nom de l'alibi avec lequel vous souhaitez échanger la place");
            nomPiece2 = scanner.nextLine().toUpperCase();

        } while((nomPiece2 == nomPiece1) || (!listAlibis.toString().toUpperCase().contains(nomPiece2)));

        AlibiName.echangerPositionAlibi(AlibiName.valueOf(nomPiece1), AlibiName.valueOf(nomPiece2));
    }

    @Override
    public void getName() {
        System.out.println("Jeton Echange Tuile");
    }

}