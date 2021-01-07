import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class JetonRotationTuile extends Jeton{

    String nomTuile;

    @Override
    public void action() {
        //Scanner scanner = new Scanner(System.in); //TODO SCANNER A REACTIVE (DESACTIVE POUR JUNIT);
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());

        do {
            System.out.println("saisir le nom de la tuile à déplacer");
            nomTuile = "BERT";
        } while(listAlibis.toString().contains(nomTuile));



    }
}