import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public abstract class Tour {


    Jeton jeton3Personnages = new Jeton3Personnages();
    Jeton jetonAlibi = new JetonAlibi();
    Jeton jetonDeplacerHOLMES = new JetonDeplacerHOLMES();
    Jeton jetonDeplacerTOBY = new JetonDeplacerTOBY();
    Jeton jetonDeplacerWATSON = new JetonDeplacerWATSON();
    Jeton jetonEchangeTuile = new JetonEchangeTuile();
    Jeton jetonRotationTuile1 = new JetonRotationTuile();
    Jeton jetonRotationTuile2 = new JetonRotationTuile();

    List<Jeton> listeJetons = Arrays.asList(jeton3Personnages, jetonAlibi, jetonDeplacerHOLMES,
            jetonDeplacerTOBY, jetonDeplacerWATSON, jetonEchangeTuile, jetonRotationTuile1,
            jetonRotationTuile2);



    public void jetonShuffle(){
        Collections.shuffle(listeJetons);

    }
    public List <Jeton> listeJeton(){
        return listeJetons;
    }
    public abstract void jouerTour();





    public void tourCount(){ //TODO Implementer cette classe ici
        //TODO Rajouter un sablier à MrJack
        //TODO Vérifier que MrJack ne possède pas 6 sabliers
        //TODO Arrêter la partie si nb de sabliers =8
    }
    public void tourPair(){ //TODO A implementer dans la classe tourPair
        //TODO Melanger la liste de 8 jetons et en proposer 4 au hasard
        //TODO MrJack commence et joue 1 jeton
        //TODO Detective continue et joue 2 jetons
        //TODO MrJack continue et joue le dernier jeton
    }

    public void tourImpair(){ //TODO A implementer dans la classe tourImpair
        //TODO proposer au joueurs les 4 jetons restants du tourPair
        //TODO Detective commence et joue 1 jeton
        //TODO MrJack continue et joue 2 jetons
        //TODO Detective continue et joue 1 jeton
    }
    public void visibiliteDetective(){ //TODO implémenter cette classe ici


    }
}
