import java.util.ArrayDeque;
import java.util.Arrays;

import java.util.Collections;
import java.util.List;

public class JetonAlibi extends Jeton{

    AlibiName nomPiece;

    @Override
    public void action() { // classe qui tourne la carte choisie.
        // Scanner scanner = new Scanner(System.in);
        List<AlibiName> listAlibis = Arrays.asList(AlibiName.values());
        Collections.shuffle(listAlibis);
        nomPiece = listAlibis.get(1); //Pioche un alibi au hasard
        PlayerMrJack.sablierAddAlibi(nomPiece); //Ajoute au compteur de sablier la valeur recupérée par la carte retournée par MrJack (SI C'EST AU TOUR DE MRJACK DE JOUER);

        AlibiName.tournerTuile(nomPiece); //Tourne la tuile de l'Alibi pioché au hasard qui n'est donc plus en jeu (SI C'EST AU TOUR DE DETECTIVE DE JOUER);



    }



}
