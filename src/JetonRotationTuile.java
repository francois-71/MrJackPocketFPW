import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

public class JetonRotationTuile extends Jeton{

    String nomTuile;
    String sensTuile;

    @Override
    public void action() {
        //Scanner scanner = new Scanner(System.in); //TODO SCANNER A REACTIVE (DESACTIVE POUR JUNIT);
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());
        List<Position.Sens> listSens = Arrays.asList(Position.Sens.values());

        do {
            //System.out.println("saisir le nom de la tuile à déplacer");
            nomTuile = "BERT";
        } while(!listAlibis.toString().contains(nomTuile));

        //System.out.println("Le sens initial de " + nomTuile + " est " + AlibiName.BERT.getPosition().getSens());

        do {
            //System.out.println("Tapez le sens (NORTH, SOUTH, EAST ou WEST)");
            sensTuile = "SOUTH";

        } while(!listSens.toString().contains(sensTuile));

        AlibiName.rotationTuile(AlibiName.valueOf(nomTuile), Position.Sens.valueOf(sensTuile));



    }

    @Override
    public void getName() {
        System.out.println("Jeton Rotation d'une Tuile");
    }
}