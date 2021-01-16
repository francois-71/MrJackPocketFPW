import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JetonRotationTuile extends Jeton{

    String nomTuile;
    String sensTuile;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void action() {
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());
        List<Position.Sens> listSens = Arrays.asList(Position.Sens.values());

        do {
            System.out.println("saisir le nom de la tuile à tourner");
            nomTuile = scanner.nextLine().toUpperCase();
        } while(!listAlibis.toString().toUpperCase().contains(nomTuile));


        do {
            System.out.println("Tapez le sens (NORTH, SOUTH, EAST ou WEST)");
            sensTuile = scanner.nextLine().toUpperCase();

        } while(!listSens.toString().toUpperCase().contains(sensTuile));

        AlibiName.rotationTuile(AlibiName.valueOf(nomTuile), Position.Sens.valueOf(sensTuile));



    }

    @Override
    public void getName() {
        System.out.println("Jeton Rotation d'une Tuile");
    }
}