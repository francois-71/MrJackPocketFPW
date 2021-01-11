import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class JetonAlibi extends Jeton{

    AlibiName nomPiece;
    String whoIsPlaying;

    @Override
    public void action() { // classe qui tourne la carte choisie.
        // Scanner scanner = new Scanner(System.in);
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());
        Collections.shuffle(listAlibis);
        whoIsPlaying = Tour.getPlayer();
        if (listAlibis.get(1) != PlayerMrJack.getMrJackCard()) { // Permet d'empêcher le retournement de la carte Alibi de MrJack.
            nomPiece = listAlibis.get(1);
        }
        else {
            nomPiece = listAlibis.get(2);
        }

        if (whoIsPlaying.equalsIgnoreCase("MrJack")) {
            PlayerMrJack.sablierAddAlibi(nomPiece); // Ajoute au compteur de sablier la valeur recupérée par la carte retournée par MrJack (SI C'EST AU TOUR DE MRJACK DE JOUER);
            System.out.println("MrJack a reçu : " + nomPiece.getSabliers() + "sablier(s).");
        }else if (whoIsPlaying.equalsIgnoreCase("Detective")){
            AlibiName.tournerTuile(nomPiece); // Tourne la tuile de l'Alibi pioché au hasard qui n'est donc plus en jeu (SI C'EST AU TOUR DE DETECTIVE DE JOUER);
            System.out.println("La tuile: " + nomPiece + " a été tournée.");
        }


    }

    @Override
    public void getName() {
        System.out.println("Jeton Alibi");
    }
}
