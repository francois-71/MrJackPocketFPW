import java.util.Scanner;

public class TourImpair extends Tour{

    void jouerTour(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Detective, c'est à vous");
        System.out.println("Jeton disponible +" + jetonShuffle().get(0) + jetonShuffle().get(1) + jetonShuffle().get(2) + jetonShuffle().get(3));
        System.out.println("");

    }
}
