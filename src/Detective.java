import com.sun.corba.se.impl.orb.NormalDataCollector;

import java.util.*;

public enum Detective implements PositionableObject {
    HOLMES(0),
    WATSON(0),
    TOBY(0);

    private final int image;
    private Optional<Position> position;

    Detective(int image) {
        this.image = image;
        this.position = Optional.empty();
    }

    public Detective setPosition(Position p) {
        this.position = Optional.of(p);
        return this;

    }

    public Position getPosition() {
        if (!this.position.isPresent()) throw new UnsupportedOperationException("Erreur le joueur n'a pas de position");
        return this.position.get();
    }


    public int getImage() {
        return image;
    }

    public static Detective[] placerDetective() {
        Detective.HOLMES.setPosition(new Position(1, 0, Position.Sens.AUCUN, Position.Returned.NONE)); //On ne tient pas compte des Sens
        Detective.WATSON.setPosition(new Position(1, 4, Position.Sens.AUCUN, Position.Returned.NONE)); //On ne tient pas compte des Sens
        Detective.TOBY.setPosition(new Position(4, 2, Position.Sens.AUCUN, Position.Returned.NONE)); //On ne tient pas compte des Sens
        return values();
    }

    public static void move1of3Characters(Detective p1, int mouvement) {

        Position x1 = p1.getPosition();
        if (mouvement == 1) {
            if (x1.getLigne() == 1 && x1.getColonne() == 0) {
                x1.setLigne(0);
                x1.setColonne(1);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 1) {
                x1.setLigne(0);
                x1.setColonne(2);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 2) {
                x1.setLigne(0);
                x1.setColonne(3);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 3) {
                x1.setLigne(1);
                x1.setColonne(4);
            } else if (x1.getLigne() == 1 && x1.getColonne() == 4) {
                x1.setLigne(2);
                x1.setColonne(4);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 4) {
                x1.setLigne(3);
                x1.setColonne(4);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 4) {
                x1.setLigne(4);
                x1.setColonne(3);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 3) {
                x1.setLigne(4);
                x1.setColonne(2);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 2) {
                x1.setLigne(4);
                x1.setColonne(1);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 1) {
                x1.setLigne(3);
                x1.setColonne(0);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 0) {
                x1.setLigne(2);
                x1.setColonne(0);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 0) {
                x1.setLigne(1);
                x1.setColonne(0);
            }
        }
    }

    public static void move1Character(Detective p1, int mouvement) {
        Position x1 = p1.getPosition();
        if (mouvement == 1) {
            if (x1.getLigne() == 1 && x1.getColonne() == 0) {
                x1.setLigne(0);
                x1.setColonne(1);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 1) {
                x1.setLigne(0);
                x1.setColonne(2);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 2) {
                x1.setLigne(0);
                x1.setColonne(3);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 3) {
                x1.setLigne(1);
                x1.setColonne(4);
            } else if (x1.getLigne() == 1 && x1.getColonne() == 4) {
                x1.setLigne(2);
                x1.setColonne(4);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 4) {
                x1.setLigne(3);
                x1.setColonne(4);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 4) {
                x1.setLigne(4);
                x1.setColonne(3);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 3) {
                x1.setLigne(4);
                x1.setColonne(2);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 2) {
                x1.setLigne(4);
                x1.setColonne(1);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 1) {
                x1.setLigne(3);
                x1.setColonne(0);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 0) {
                x1.setLigne(2);
                x1.setColonne(0);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 0) {
                x1.setLigne(1);
                x1.setColonne(0);
            }
        }
        if (mouvement == 2) {
            if (x1.getLigne() == 1 && x1.getColonne() == 0) {
                x1.setLigne(0);
                x1.setColonne(2);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 1) {
                x1.setLigne(0);
                x1.setColonne(3);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 2) {
                x1.setLigne(1);
                x1.setColonne(4);
            } else if (x1.getLigne() == 0 && x1.getColonne() == 3) {
                x1.setLigne(2);
                x1.setColonne(4);
            } else if (x1.getLigne() == 1 && x1.getColonne() == 4) {
                x1.setLigne(3);
                x1.setColonne(4);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 4) {
                x1.setLigne(4);
                x1.setColonne(3);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 4) {
                x1.setLigne(4);
                x1.setColonne(2);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 3) {
                x1.setLigne(4);
                x1.setColonne(1);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 2) {
                x1.setLigne(3);
                x1.setColonne(0);
            } else if (x1.getLigne() == 4 && x1.getColonne() == 1) {
                x1.setLigne(2);
                x1.setColonne(0);
            } else if (x1.getLigne() == 3 && x1.getColonne() == 0) {
                x1.setLigne(1);
                x1.setColonne(0);
            } else if (x1.getLigne() == 2 && x1.getColonne() == 0) {
                x1.setLigne(0);
                x1.setColonne(1);
            }
        }


    }

    public static void isVisible(AlibiName[] alibis) {

        HashSet<AlibiName> listVisible = new HashSet<>();
        HashSet<String> listNotVisible = new HashSet<>();
        AlibiName[][] tableau = new AlibiName[3][3];
        for (AlibiName alibi : alibis) {         // Pour toutes les cellules de la liste,
            Position p = alibi.getPosition();    // On attribue une position p
            tableau[p.getLigne()][p.getColonne()] = alibi;
        }
        Position p1 = tableau[0][0].getPosition();
        Position p2 = tableau[0][1].getPosition();
        Position p3 = tableau[0][2].getPosition();
        Position p4 = tableau[1][0].getPosition();
        Position p5 = tableau[1][1].getPosition();
        Position p6 = tableau[1][2].getPosition();
        Position p7 = tableau[2][0].getPosition();
        Position p8 = tableau[2][1].getPosition();
        Position p9 = tableau[2][2].getPosition();


        //DEBUT COTE HAUT
        if ((Detective.HOLMES.getPosition().getLigne() == 0 && Detective.HOLMES.getPosition().getColonne() == 1) ||
                (Detective.WATSON.getPosition().getLigne() == 0 && Detective.WATSON.getPosition().getColonne() == 1) ||
                (Detective.TOBY.getPosition().getLigne() == 0 && Detective.TOBY.getPosition().getColonne() == 1)) {

            if (p1.getSens() == Position.Sens.NORTH || p1.getSens() == Position.Sens.EAST || p1.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[0][0]); // On ajoute cet alibi à la liste des visibles
                if ((p1.getSens() == Position.Sens.EAST || p1.getSens() == Position.Sens.WEST) &&
                        (p4.getSens() == Position.Sens.EAST || p4.getSens() == Position.Sens.WEST || p4.getSens() == Position.Sens.NORTH)){
                    listVisible.add(tableau[1][0]);
                    if ((p4.getSens() == Position.Sens.EAST || p4.getSens() == Position.Sens.WEST) &&
                            (p7.getSens() == Position.Sens.EAST || p7.getSens() == Position.Sens.WEST || p7.getSens() == Position.Sens.NORTH)){
                        listVisible.add(tableau[2][0]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 0 && Detective.HOLMES.getPosition().getColonne() == 2) ||
                (Detective.WATSON.getPosition().getLigne() == 0 && Detective.WATSON.getPosition().getColonne() == 2) ||
                (Detective.TOBY.getPosition().getLigne() == 0 && Detective.TOBY.getPosition().getColonne() == 2)){

            if (p2.getSens() == Position.Sens.NORTH || p2.getSens() == Position.Sens.EAST || p2.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[0][1]); // On ajoute cet alibi à la liste des visibles
                if ((p2.getSens() == Position.Sens.EAST || p2.getSens() == Position.Sens.WEST) &&
                        (p5.getSens() == Position.Sens.EAST || p5.getSens() == Position.Sens.WEST || p5.getSens() == Position.Sens.NORTH)){
                    listVisible.add(tableau[1][1]);
                    if ((p5.getSens() == Position.Sens.EAST || p5.getSens() == Position.Sens.WEST) &&
                            (p8.getSens() == Position.Sens.EAST || p8.getSens() == Position.Sens.WEST || p8.getSens() == Position.Sens.NORTH)){
                        listVisible.add(tableau[2][1]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 0 && Detective.HOLMES.getPosition().getColonne() == 3) ||
                (Detective.WATSON.getPosition().getLigne() == 0 && Detective.WATSON.getPosition().getColonne() == 3) ||
                (Detective.TOBY.getPosition().getLigne() == 0 && Detective.TOBY.getPosition().getColonne() == 3)){

            if (p3.getSens() == Position.Sens.NORTH || p3.getSens() == Position.Sens.EAST || p3.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[0][2]); // On ajoute cet alibi à la liste des visibles
                if ((p3.getSens() == Position.Sens.EAST || p3.getSens() == Position.Sens.WEST) &&
                        (p6.getSens() == Position.Sens.EAST || p6.getSens() == Position.Sens.WEST || p6.getSens() == Position.Sens.NORTH)){
                    listVisible.add(tableau[1][2]);
                    if ((p6.getSens() == Position.Sens.EAST || p6.getSens() == Position.Sens.WEST) &&
                            (p9.getSens() == Position.Sens.EAST || p9.getSens() == Position.Sens.WEST || p9.getSens() == Position.Sens.NORTH)){
                        listVisible.add(tableau[2][2]);
                    }
                }
            }
        }
        //FIN COTE HAUT

        //DEBUT COTE DROIT
        if ((Detective.HOLMES.getPosition().getLigne() == 1 && Detective.HOLMES.getPosition().getColonne() == 4) ||
                (Detective.WATSON.getPosition().getLigne() == 1 && Detective.WATSON.getPosition().getColonne() == 4) ||
                (Detective.TOBY.getPosition().getLigne() == 1 && Detective.TOBY.getPosition().getColonne() == 4)) {

            if (p3.getSens() == Position.Sens.NORTH || p3.getSens() == Position.Sens.EAST || p3.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[0][2]); // On ajoute cet alibi à la liste des visibles
                if ((p3.getSens() == Position.Sens.NORTH || p3.getSens() == Position.Sens.SOUTH) &&
                        (p2.getSens() == Position.Sens.NORTH || p2.getSens() == Position.Sens.EAST || p2.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[0][1]);
                    if ((p2.getSens() == Position.Sens.NORTH || p2.getSens() == Position.Sens.SOUTH) &&
                            (p1.getSens() == Position.Sens.NORTH || p1.getSens() == Position.Sens.EAST || p1.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[0][0]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 2 && Detective.HOLMES.getPosition().getColonne() == 4) ||
                (Detective.WATSON.getPosition().getLigne() == 2 && Detective.WATSON.getPosition().getColonne() == 4) ||
                (Detective.TOBY.getPosition().getLigne() == 2 && Detective.TOBY.getPosition().getColonne() == 4)){

            if (p6.getSens() == Position.Sens.NORTH || p6.getSens() == Position.Sens.EAST || p6.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[1][2]); // On ajoute cet alibi à la liste des visibles
                if ((p6.getSens() == Position.Sens.NORTH || p6.getSens() == Position.Sens.SOUTH) &&
                        (p5.getSens() == Position.Sens.NORTH || p5.getSens() == Position.Sens.EAST || p5.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[1][1]);
                    if ((p5.getSens() == Position.Sens.NORTH || p5.getSens() == Position.Sens.SOUTH) &&
                            (p4.getSens() == Position.Sens.NORTH || p4.getSens() == Position.Sens.EAST || p4.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[1][0]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 3 && Detective.HOLMES.getPosition().getColonne() == 4) ||
                (Detective.WATSON.getPosition().getLigne() == 3 && Detective.WATSON.getPosition().getColonne() == 4) ||
                (Detective.TOBY.getPosition().getLigne() == 3 && Detective.TOBY.getPosition().getColonne() == 4)){

            if (p9.getSens() == Position.Sens.NORTH || p9.getSens() == Position.Sens.EAST || p9.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[2][2]); // On ajoute cet alibi à la liste des visibles
                if ((p9.getSens() == Position.Sens.NORTH || p9.getSens() == Position.Sens.SOUTH) &&
                        (p8.getSens() == Position.Sens.NORTH || p8.getSens() == Position.Sens.EAST || p8.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[2][1]);
                    if ((p8.getSens() == Position.Sens.NORTH || p8.getSens() == Position.Sens.SOUTH) &&
                            (p7.getSens() == Position.Sens.NORTH || p7.getSens() == Position.Sens.EAST || p7.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[2][0]);
                    }
                }
            }
        }
        //FIN COTE DROIT

        //DEBUT COTE BAS
        if ((Detective.HOLMES.getPosition().getLigne() == 4 && Detective.HOLMES.getPosition().getColonne() == 3) ||
                (Detective.WATSON.getPosition().getLigne() == 4 && Detective.WATSON.getPosition().getColonne() == 3) ||
                (Detective.TOBY.getPosition().getLigne() == 4 && Detective.TOBY.getPosition().getColonne() == 3)) {

            if (p9.getSens() == Position.Sens.SOUTH || p9.getSens() == Position.Sens.EAST || p9.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[2][2]); // On ajoute cet alibi à la liste des visibles
                if ((p9.getSens() == Position.Sens.EAST || p9.getSens() == Position.Sens.WEST) &&
                        (p6.getSens() == Position.Sens.SOUTH || p6.getSens() == Position.Sens.EAST || p6.getSens() == Position.Sens.WEST)){
                    listVisible.add(tableau[1][2]);
                    if ((p6.getSens() == Position.Sens.EAST || p6.getSens() == Position.Sens.WEST) &&
                            (p3.getSens() == Position.Sens.SOUTH || p3.getSens() == Position.Sens.EAST || p3.getSens() == Position.Sens.WEST)){
                        listVisible.add(tableau[0][2]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 4 && Detective.HOLMES.getPosition().getColonne() == 2) ||
                (Detective.WATSON.getPosition().getLigne() == 4 && Detective.WATSON.getPosition().getColonne() == 2) ||
                (Detective.TOBY.getPosition().getLigne() == 4 && Detective.TOBY.getPosition().getColonne() == 2)) {

            if (p8.getSens() == Position.Sens.SOUTH || p8.getSens() == Position.Sens.EAST || p8.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[2][1]); // On ajoute cet alibi à la liste des visibles
                if ((p8.getSens() == Position.Sens.EAST || p8.getSens() == Position.Sens.WEST) &&
                        (p5.getSens() == Position.Sens.SOUTH || p5.getSens() == Position.Sens.EAST || p5.getSens() == Position.Sens.WEST)){
                    listVisible.add(tableau[1][1]);
                    if ((p5.getSens() == Position.Sens.EAST || p5.getSens() == Position.Sens.WEST) &&
                            (p2.getSens() == Position.Sens.SOUTH || p2.getSens() == Position.Sens.EAST || p2.getSens() == Position.Sens.WEST)){
                        listVisible.add(tableau[0][1]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 4 && Detective.HOLMES.getPosition().getColonne() == 1) ||
                (Detective.WATSON.getPosition().getLigne() == 4 && Detective.WATSON.getPosition().getColonne() == 1) ||
                (Detective.TOBY.getPosition().getLigne() == 4 && Detective.TOBY.getPosition().getColonne() == 1)) {

            if (p7.getSens() == Position.Sens.SOUTH || p7.getSens() == Position.Sens.EAST || p7.getSens() == Position.Sens.WEST){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[2][0]); // On ajoute cet alibi à la liste des visibles
                if ((p7.getSens() == Position.Sens.EAST || p7.getSens() == Position.Sens.WEST) &&
                        (p4.getSens() == Position.Sens.SOUTH || p4.getSens() == Position.Sens.EAST || p4.getSens() == Position.Sens.WEST)){
                    listVisible.add(tableau[1][0]);
                    if ((p4.getSens() == Position.Sens.EAST || p4.getSens() == Position.Sens.WEST) &&
                            (p1.getSens() == Position.Sens.SOUTH || p1.getSens() == Position.Sens.EAST || p1.getSens() == Position.Sens.WEST)){
                        listVisible.add(tableau[0][0]);
                    }
                }
            }
        }

        //FIN COTE BAS
        //DEBUT COTE GAUCHE

        if ((Detective.HOLMES.getPosition().getLigne() == 3 && Detective.HOLMES.getPosition().getColonne() == 0) ||
                (Detective.WATSON.getPosition().getLigne() == 3 && Detective.WATSON.getPosition().getColonne() == 0) ||
                (Detective.TOBY.getPosition().getLigne() == 3 && Detective.TOBY.getPosition().getColonne() == 0)) {

            if (p7.getSens() == Position.Sens.NORTH || p7.getSens() == Position.Sens.WEST || p7.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[2][0]); // On ajoute cet alibi à la liste des visibles
                if ((p7.getSens() == Position.Sens.NORTH || p7.getSens() == Position.Sens.SOUTH) &&
                        (p8.getSens() == Position.Sens.NORTH || p8.getSens() == Position.Sens.WEST || p8.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[2][1]);
                    if ((p8.getSens() == Position.Sens.NORTH || p8.getSens() == Position.Sens.SOUTH) &&
                            (p9.getSens() == Position.Sens.NORTH || p9.getSens() == Position.Sens.WEST || p9.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[2][2]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 2 && Detective.HOLMES.getPosition().getColonne() == 0) ||
                (Detective.WATSON.getPosition().getLigne() == 2 && Detective.WATSON.getPosition().getColonne() == 0) ||
                (Detective.TOBY.getPosition().getLigne() == 2 && Detective.TOBY.getPosition().getColonne() == 0)){

            if (p4.getSens() == Position.Sens.NORTH || p4.getSens() == Position.Sens.WEST || p4.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[1][0]); // On ajoute cet alibi à la liste des visibles
                if ((p4.getSens() == Position.Sens.NORTH || p4.getSens() == Position.Sens.SOUTH) &&
                        (p5.getSens() == Position.Sens.NORTH || p5.getSens() == Position.Sens.WEST || p5.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[1][1]);
                    if ((p5.getSens() == Position.Sens.NORTH || p5.getSens() == Position.Sens.SOUTH) &&
                            (p6.getSens() == Position.Sens.NORTH || p6.getSens() == Position.Sens.WEST || p6.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[1][2]);
                    }
                }
            }
        }
        if ((Detective.HOLMES.getPosition().getLigne() == 1 && Detective.HOLMES.getPosition().getColonne() == 0) ||
                (Detective.WATSON.getPosition().getLigne() == 1 && Detective.WATSON.getPosition().getColonne() == 0) ||
                (Detective.TOBY.getPosition().getLigne() == 1 && Detective.TOBY.getPosition().getColonne() == 0)){

            if (p1.getSens() == Position.Sens.NORTH || p1.getSens() == Position.Sens.WEST || p1.getSens() == Position.Sens.SOUTH){    // Si un des alibis à cette position (ligne 1, colonne 1)
                listVisible.add(tableau[0][0]); // On ajoute cet alibi à la liste des visibles
                if ((p1.getSens() == Position.Sens.NORTH || p1.getSens() == Position.Sens.SOUTH) &&
                        (p2.getSens() == Position.Sens.NORTH || p2.getSens() == Position.Sens.WEST || p2.getSens() == Position.Sens.SOUTH)){
                    listVisible.add(tableau[0][1]);
                    if ((p2.getSens() == Position.Sens.NORTH || p2.getSens() == Position.Sens.SOUTH) &&
                            (p3.getSens() == Position.Sens.NORTH || p3.getSens() == Position.Sens.WEST || p3.getSens() == Position.Sens.SOUTH)){
                        listVisible.add(tableau[0][2]);
                    }
                }
            }
        }
        //FIN COTE GAUCHE

        System.out.println("la liste des gens visible est " + listVisible);
        System.out.println(p1.getSens());
        System.out.println(p2.getSens());
        System.out.println(p3.getSens());

    }

}




