import javax.xml.bind.SchemaOutputResolver;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class TourImpair extends Tour{
    int choice1;
    int choice2;
    int choice3;
    int choice4;


    @Override
    public void jouerTour(){
        //Scanner scanner = new Scanner(System.in);
        System.out.println(" ");
        jetonShuffle();
        System.out.println("Detective, c'est à vous");
        System.out.println("Jetons disponible: ");
        System.out.print("0: ");
        listeJeton().get(0).getName();
        System.out.print("1: ");
        listeJeton().get(1).getName();
        System.out.print("2: ");
        listeJeton().get(2).getName();
        System.out.print("3: ");
        listeJeton().get(3).getName();
        do{
            //System.out.println("tapez le nombre");
            //int choice1 = scanner.nextInt();
            choice1 = 0;
        }while(!(choice1 == 0 || choice1 == 1 || choice1 == 2 || choice1 == 3));

        switch (choice1) {
            case 1:
                listeJeton().get(0);
                break;
            case 2:
                listeJeton().get(1);
                break;
            case 3:
                listeJeton().get(2);
                break;
            case 4:
                listeJeton().get(3);
                break;

        }
        listeJeton().get(choice1).action();
        System.out.print("CHOIX : ");
        listeJeton().get(choice1).getName();






        System.out.println("MrJack, c'est à votre tour de jouer 2 jetons");
        System.out.println("Jetons disponible: ");
        System.out.print("0: ");
        listeJeton().get(0).getName();
        System.out.print("1: ");
        listeJeton().get(1).getName();
        System.out.print("2: ");
        listeJeton().get(2).getName();
        do{
            //System.out.println("tapez le nombre");
            //int choice1 = scanner.nextInt();
            choice2 = 2;
        }while(!(choice2 == 0 || choice2 == 1 || choice2 == 2));

        switch (choice2) {
            case 1:
                listeJeton().get(0);
                break;
            case 2:
                listeJeton().get(1);
                break;
            case 3:
                listeJeton().get(2);
                break;
        }

        listeJeton().get(choice2).action();
        System.out.print("CHOIX: ");
        listeJeton().get(choice2).getName();






        System.out.println("MrJack, choisissez votre 2ème jeton");
        System.out.println("Jetons disponible: ");
        System.out.print("0: ");
        listeJeton().get(0).getName();
        System.out.print("1: ");
        listeJeton().get(1).getName();
        do{
            //System.out.println("tapez le nombre");
            //int choice1 = scanner.nextInt();
            choice3 = 1;
        }while(!(choice3 == 0 || choice3 == 1));
        switch (choice3) {
            case 1:
                listeJeton().get(0);
                break;
            case 2:
                listeJeton().get(1);
                break;
        }
        listeJeton().get(choice3).action();
        listeJeton().get(choice3).getName();



        System.out.println("Detective, jouez le dernier jeton");
        System.out.println("Jetons disponible: ");
        System.out.print("0: ");
        listeJeton().get(0).getName();

        do{
            //System.out.println("tapez le nombre");
            //int choice1 = scanner.nextInt();
            choice4 = 0;
        }while(choice4 != 0);

        switch (choice4) {
            case 1:
                listeJeton().get(0);
                break;
        }
        listeJeton().get(choice4).action();
        listeJeton().get(choice4).getName();







    }
}
