import java.util.*;

public enum AlibiName implements PositionableObject{
    LESTRADE(0,0),
    STEALTHY(1,0),
    BERT(1,0),
    PIZER(1,0),
    SMITH(1,0),
    LANE(1,0),
    MADAME(2,0),
    GOODLEY(0,0),
    GULL(1,0);

    private final int sabliers;
    private final int image; // TODO ajouter les images
    private Optional<Position> position;

    AlibiName(int sabliers, int image) {
        this.sabliers = sabliers;
        this.image = image;
        this.position = Optional.empty();
    }

    public static void echangerPositionAlibi(AlibiName p1, AlibiName p2) {
        Position x1 = p1.getPosition();
        Position x2 = p2.getPosition();

        Position.Sens a = x1.getSens(); //Pour réinverser les sens lors du changement de position des 2 tuiles.
        Position.Sens b = x2.getSens();
        x2.setSens(a);
        x1.setSens(b);

        Position.Returned c = x1.getEtatTuile(); //Pour réinverser les états de cartes (retournée ou pas) lors du changement de position entre 2 cartes.
        Position.Returned d= x2.getEtatTuile();
        x2.setEtatTuile(c);
        x1.setEtatTuile(d);

        p2.setPosition(x1);
        p1.setPosition(x2);
    }

    public static void tournerTuile(AlibiName p1) { // méthode pour retourner une tuile
        Position x1 = p1.getPosition();
        x1.setEtatTuile(Position.Returned.RETURNED);
        if (p1 == AlibiName.LANE) {
            x1.setSens(Position.Sens.AUCUN); // si LANE est retourné, cette carte ne possède plus de sens en particulier
        }


    }

    public static void rotationTuile(AlibiName p1, Position.Sens s1) { // méthode qui modifie l'orientation de la tuile
        Position x1 = p1.getPosition();
        x1.setSens(s1);
    }

    public int getSabliers() {
        return sabliers;
    }


    public int getImage() {
        return image;
    }

    public AlibiName setPosition(Position p){
        this.position = Optional.of(p);
        return this;
    }

    public Position getPosition(){
        if (!this.position.isPresent()) throw new UnsupportedOperationException("Erreur le joueur n'a pas de position");
        return this.position.get();
    }

    public static AlibiName[] placerAlibi(){ // Méthode qui place les alibis en début de jeu.
        List<AlibiName> listeAlibi = Arrays.asList(values());
        Collections.shuffle(listeAlibi);
        ArrayDeque<AlibiName> deck = new ArrayDeque(listeAlibi);

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if ((i == 0) && (j == 0)) {
                    deck.pollFirst().setPosition(new Position(i,j,Position.Sens.EAST, Position.Returned.INGAME)); // initialise la tuile pour que HOLMES soit face au mur
                }
                else if ((i == 0) && (j == 2)){
                    deck.pollFirst().setPosition(new Position(i,j,Position.Sens.WEST, Position.Returned.INGAME)); // initialise la tuile pour que WATSON soit face au mur

                }
                else if ((i == 2) && (j == 1)) {
                    deck.pollFirst().setPosition(new Position(i,j,Position.Sens.NORTH,Position.Returned.INGAME)); // initialise la tuile pour que TOBY soit face au mur
                }
                else{
                    List<Position.Sens> sensRandom = Arrays.asList(Position.Sens.EAST, Position.Sens.NORTH, Position.Sens.SOUTH, Position.Sens.WEST);
                    Collections.shuffle(sensRandom);
                    deck.pollFirst().setPosition(new Position(i, j, sensRandom.get(1), Position.Returned.INGAME)); // Positione le reste des cartes avec une orientation aléatoire
                }

            }
        }

        return values();
    }
}
