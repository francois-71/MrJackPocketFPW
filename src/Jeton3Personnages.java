import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Jeton3Personnages extends Jeton{

    String detective;
    String deplacement;
    Scanner scanner = new Scanner(System.in);

    @Override
    public void action() {
        //Scanner scanner = new Scanner(System.in); //TODO Rajouter le scanner quand on ne fait plus de test JUNIT

        List<Detective> listDetective = Arrays.asList(Detective.values());
        int[] deplacementPossible = {0,1};

        do {
            System.out.println("Choisir le detective à déplacer: TOBY, HOLMES ou WATSON"); // Rajouter le choix des personnages
            detective = scanner.nextLine().toUpperCase();

        }while(!listDetective.toString().toUpperCase().contains(detective));

        System.out.println("Vous avez choisi de déplacer " + detective);

        do {
            System.out.println("De combien de case souhaitez vous déplacer " + detective + " ? Saisir '0' pour qu'il ne bouge pas, '1' pour le faire avancer d'une case Sens horaire");
            deplacement = scanner.nextLine();


        }while(!Arrays.toString(deplacementPossible).contains(deplacement)); // Condition est tjs vraie OU fausse car on fixe un int, qui ne devra plus être fixé quand on utilisera le scanner

        System.out.println("le deplacement est " + deplacement);
        if (deplacement.equals("1")) {
            Detective.move1of3Characters(Detective.valueOf(detective), Integer.parseInt(deplacement));
        }
    }

    @Override
    public void getName(){
        System.out.println("Jeton Deplacer 1 des 3 Detectives");
    }

}
