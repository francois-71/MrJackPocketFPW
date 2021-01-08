import java.util.Arrays;
import java.util.List;

public class JetonDeplacerHOLMES extends Jeton{

    String detective;
    String deplacement;

    @Override
    public void action() {
        Detective detectiveDuJeton = Detective.HOLMES;
        int[] deplacementPossible = {1,2};

        do {
            System.out.println("Choisir le detective à déplacer: TOBY, HOLMES ou WATSON"); // Rajouter le choix des personnages
            //String detective = scanner.nextLine();
            detective = "TOBY";
        }while(detectiveDuJeton.toString().equals(detective));

        System.out.println("Vous avez choisi de déplacer " + detective);

        do {
            System.out.println("De combien de case souhaitez vous déplacer " + detective + " ? Saisir '0' pour qu'il ne bouge pas, '1' pour le faire avancer d'une case Sens horaire");
            //String  deplacement = scanner.nextLine();
            deplacement = "1";


        }while(!Arrays.toString(deplacementPossible).contains(deplacement)); // Condition est tjs vraie OU fausse car on fixe un int, qui ne devra plus être fixé quand on utilisera le scanner

        System.out.println("le deplacement est " + deplacement);
    }
}
