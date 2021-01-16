import java.util.Arrays;
import java.util.Scanner;

public class JetonDeplacerWATSON extends Jeton{

    String detective = "WATSON";
    String deplacement;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void action() {
        int[] deplacementPossible = {1,2};
        System.out.println("Vous avez choisi de déplacer " + detective);

        do {
            System.out.println("De combien de case souhaitez vous déplacer " + detective + " ? Saisir '1' pour le faire avancer d'une case, '2' pour le faire avancer de deux case (MOUVEMENT SENS HORAIRE)");
            deplacement = scanner.nextLine().toUpperCase();


        }while(!Arrays.toString(deplacementPossible).toUpperCase().contains(deplacement)); // Condition est tjs vraie OU fausse car on fixe un int, qui ne devra plus être fixé quand on utilisera le scanner

        System.out.println("le deplacement est " + deplacement +" case(s) (Sens horaire).");

        Detective.move1Character(Detective.valueOf(detective), Integer.parseInt(deplacement));
    }

    @Override
    public void getName() {
        System.out.println("Jeton Deplacer Detective WATSON");
    }
}
