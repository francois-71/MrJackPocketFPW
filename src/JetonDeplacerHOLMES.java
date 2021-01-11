import java.util.Arrays;
import java.util.List;

public class JetonDeplacerHOLMES extends Jeton{

    String detective = "HOLMES";
    String deplacement;

    @Override
    public void action() {
        int[] deplacementPossible = {1,2};




        System.out.println("Vous avez choisi de déplacer " + detective);

        do {
            //System.out.println("De combien de case souhaitez vous déplacer " + detective + " ? Saisir '1' pour qu'il ne bouge pas, '2' pour le faire avancer d'une case Sens horaire");
            //String  deplacement = scanner.nextLine();
            deplacement = "2";


        }while(!Arrays.toString(deplacementPossible).contains(deplacement)); // Condition est tjs vraie OU fausse car on fixe un int, qui ne devra plus être fixé quand on utilisera le scanner

        System.out.println("le deplacement est " + deplacement);

        Detective.move1Character(Detective.valueOf(detective), Integer.parseInt(deplacement));
    }

    @Override
    public void getName() {
        System.out.println("Jeton Deplacer Detective HOLMES");
    }

}
