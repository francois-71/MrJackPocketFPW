import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jeton3Personnages extends Jeton{

    String detective;
    String deplacement;

    @Override
    public void action() {
        //Scanner scanner = new Scanner(System.in); //TODO Rajouter le scanner quand on ne fait plus de test JUNIT

        List<Detective> listDetective = Arrays.asList(Detective.values());
        int[] deplacementPossible = {0,1};

        do {
            System.out.println("Choisir le detective à déplacer: TOBY, HOLMES ou WATSON");
            //String detective = scanner.nextLine();
            detective = "TOBY";
        }while(!listDetective.toString().contains(detective));

        System.out.println("Vous avez choisi de déplacer " + detective);

        do {
            System.out.println("De combien de case souhaitez vous déplacer " + detective + " ? Saisir '0' pour qu'il ne bouge pas, '1' pour le faire avancer d'une case Sens horaire");
            //String  deplacement = scanner.nextLine();
            deplacement = "0";


        }while(!Arrays.toString(deplacementPossible).contains(deplacement)); // Condition est tjs vraie OU fausse car on fixe un int, qui ne devra plus être fixé quand on utilisera le scanner

        System.out.println("le deplacement est " + deplacement);
    }

    //Detective.move1of3Characters(Detective.valueOf(detective), String deplacement);
}
