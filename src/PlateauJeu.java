import java.sql.Array;
import java.util.*;

public enum PlateauJeu {

    PLATEAU;

    class PlateauMrJack {
        private final AlibiName[][] tableau = new AlibiName[3][3]; // Initialise un tableau vide 3X3
        private final Detective[][] tableau2 = new Detective[5][5];

        public PlateauMrJack(AlibiName[] alibis, Detective[] detectives) {
            for (AlibiName alibi : alibis) {         // Pour toutes les cellules de la liste,
                Position p = alibi.getPosition();    // On attribue une position p
                tableau[p.getLigne()][p.getColonne()] = alibi;
            }
            for (Detective detective : detectives) {
                Position p = detective.getPosition();
                tableau2[p.getLigne()][p.getColonne()] = detective;
            }
        }

        public AlibiName getAlibi(int x, int y) { // Méthode qui retourne la position des alibis
            return tableau[x][y];

        }

        public AlibiName[][] getTableau() {
            return tableau.clone();
            //List<Detective> detectives
        }


        public Set<PositionableObject>[][] getExtendedBoard() {
            HashSet<PositionableObject>[][] board = new HashSet[5][5];


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) { //Initialise le tableau sans valeurs à l'intérieur des cellules
                    board[i][j] = new HashSet<>();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i + 1][j + 1].add(this.tableau[i][j]); // Initialise le tableau avec les emplacements des alibis
                }
            }
            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) {
                    if (tableau2[i][j] == Detective.HOLMES) {
                        board[i][j].add(this.tableau2[i][j]);
                    } else if (tableau2[i][j] == Detective.TOBY) {
                        board[i][j].add(this.tableau2[i][j]);
                    } else if (tableau2[i][j] == Detective.WATSON) {
                        board[i][j].add(this.tableau2[i][j]);
                    }
                }
            }
            return board.clone();
        }
    }

    public PlateauMrJack currentBoard;
    Jeton jeton3Personnages = new Jeton3Personnages();
    Jeton jetonAlibi = new JetonAlibi();
    Jeton jetonDeplacerHOLMES = new JetonDeplacerHOLMES();
    Jeton jetonDeplacerTOBY = new JetonDeplacerTOBY();
    Jeton jetonDeplacerWATSON = new JetonDeplacerWATSON();
    Jeton jetonEchangeTuile = new JetonEchangeTuile();
    Jeton jetonRotationTuile1 = new JetonRotationTuile();
    Jeton jetonRotationTuile2 = new JetonRotationTuile();
    List<Jeton> listeJeton = new ArrayList<>();
    int choice1;
    int choice2;
    int choice3;
    int choice4;
    int tourCount = 1;

    PlateauJeu() {


        AlibiName.placerAlibi(); // place les alibis dans un ordre aléatoire
        Detective.placerDetective(); // place les detectives
        PlayerMrJack.setMrJackCard();
        updateBoard();
        printBoard();
        listeJeton.add(jeton3Personnages);
        listeJeton.add(jetonAlibi);
        listeJeton.add(jetonDeplacerHOLMES);
        listeJeton.add(jetonDeplacerTOBY);
        listeJeton.add(jetonDeplacerWATSON);
        listeJeton.add(jetonEchangeTuile);
        listeJeton.add(jetonRotationTuile1);
        listeJeton.add(jetonRotationTuile2);
        jetonShuffle();



        while (tourCount <= 8 && PlayerMrJack.getSablier() <= 6 && ) { // Rajouter condition (que la carte piochée par MrJack ne soit pas la seule visible par les detectives);

            if ((tourCount % 2) != 0){
                Tour.setPlayer("Detective");
                System.out.println(" ");

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
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice1 = 0;
                } while (!(choice1 == 0 || choice1 == 1 || choice1 == 2 || choice1 == 3));

                listeJeton().get(choice1).action();
                System.out.print("CHOIX : ");
                listeJeton().get(choice1).getName();
                listeJeton().remove(choice1);
                System.out.println(" ");
                updateBoard();
                printBoard();

                //FIN ACTION PREMIER JETON
                //A MrJack de jouer les 2 prochains jetons

                Tour.setPlayer("MrJack");
                System.out.println(" ");

                System.out.println("MrJack, c'est à votre tour de jouer 2 jetons");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                System.out.print("2: ");
                listeJeton().get(2).getName();
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice2 = 2;
                } while (!(choice2 == 0 || choice2 == 1 || choice2 == 2));

                listeJeton().get(choice2).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice2).getName();
                listeJeton().remove(choice2);

                System.out.println(" ");
                updateBoard();
                printBoard();

                System.out.println(" ");


                System.out.println("MrJack, choisissez votre 2ème jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice3 = 1;
                } while (!(choice3 == 0 || choice3 == 1));

                listeJeton().get(choice3).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice3).getName();
                listeJeton().remove(choice3);
                System.out.println(" ");
                updateBoard();
                printBoard();

                Tour.setPlayer("Detective");

                System.out.println(" ");
                System.out.println("Detective, jouez le dernier jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();

                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice4 = 0;
                } while (choice4 != 0);


                listeJeton().get(choice4).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice4).getName();
                listeJeton().remove(choice4);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");

                System.out.println(Detective.isVisible(AlibiName.values()));
                ArrayList<AlibiName> listAlibisVisible = new ArrayList(Detective.isVisible(AlibiName.values())); //Conversion du HashSet en ArrayList pour avoir accès à l'index de la liste d'alibis visibles.
                List<AlibiName> alibiList = Arrays.asList(AlibiName.values());


                if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard())) {
                    System.out.println("MrJack fait partie des Alibis visible");
                    for (int i = 0; i < AlibiName.values().length; i++) {
                        if (!listAlibisVisible.contains(alibiList.get(i))) {
                            AlibiName.tournerTuile(alibiList.get(i));
                        }
                    }
                } else if (!(listAlibisVisible.contains(PlayerMrJack.getMrJackCard()))) {
                    System.out.println("MrJack ne fait pas partie des Alibis visible");
                    PlayerMrJack.sablierAddFinTour();
                    for (int i = 0; i < listAlibisVisible.toArray().length; i++) {
                        AlibiName.tournerTuile(listAlibisVisible.get(i));


                    }

                }
                System.out.println(PlayerMrJack.getSablier());
                System.out.println(PlayerMrJack.getMrJackCard());
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i).getPosition().getEtatTuile() + " " + alibiList.get(i));

                }
                tourCount += 1;
            }
            else{
                Tour.setPlayer("MrJack");
                System.out.println(" ");

                System.out.println("MrJack, c'est à vous");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                System.out.print("2: ");
                listeJeton().get(2).getName();
                System.out.print("3: ");
                listeJeton().get(3).getName();
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice1 = 0;
                } while (!(choice1 == 0 || choice1 == 1 || choice1 == 2 || choice1 == 3));

                listeJeton().get(choice1).action();
                System.out.print("CHOIX : ");
                listeJeton().get(choice1).getName();
                listeJeton().remove(choice1);
                System.out.println(" ");
                updateBoard();
                printBoard();

                //FIN ACTION PREMIER JETON
                //A MrJack de jouer les 2 prochains jetons

                Tour.setPlayer("Detective");
                System.out.println(" ");

                System.out.println("Detective, c'est à votre tour de jouer 2 jetons");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                System.out.print("2: ");
                listeJeton().get(2).getName();
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice2 = 2;
                } while (!(choice2 == 0 || choice2 == 1 || choice2 == 2));

                listeJeton().get(choice2).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice2).getName();
                listeJeton().remove(choice2);

                System.out.println(" ");
                updateBoard();
                printBoard();

                System.out.println(" ");


                System.out.println("Detective, choisissez votre 2ème jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice3 = 1;
                } while (!(choice3 == 0 || choice3 == 1));

                listeJeton().get(choice3).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice3).getName();
                listeJeton().remove(choice3);
                System.out.println(" ");
                updateBoard();
                printBoard();

                Tour.setPlayer("MrJack");

                System.out.println(" ");
                System.out.println("MrJack, jouez le dernier jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();

                do {
                    //System.out.println("tapez le nombre");
                    //int choice1 = scanner.nextInt();
                    choice4 = 0;
                } while (choice4 != 0);


                listeJeton().get(choice4).action();
                System.out.print("CHOIX: ");
                listeJeton().get(choice4).getName();
                listeJeton().remove(choice4);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");

                System.out.println(Detective.isVisible(AlibiName.values()));
                ArrayList<AlibiName> listAlibisVisible = new ArrayList(Detective.isVisible(AlibiName.values())); //Conversion du HashSet en ArrayList pour avoir accès à l'index de la liste d'alibis visibles.
                List<AlibiName> alibiList = Arrays.asList(AlibiName.values());


                if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard())) {
                    System.out.println("MrJack fait partie des Alibis visible");
                    for (int i = 0; i < AlibiName.values().length; i++) {
                        if (!listAlibisVisible.contains(alibiList.get(i))) {
                            AlibiName.tournerTuile(alibiList.get(i));
                        }
                    }
                } else if (!(listAlibisVisible.contains(PlayerMrJack.getMrJackCard()))) {
                    System.out.println("MrJack ne fait pas partie des Alibis visible");
                    PlayerMrJack.sablierAddFinTour();
                    for (int i = 0; i < listAlibisVisible.toArray().length; i++) {
                        AlibiName.tournerTuile(listAlibisVisible.get(i));


                    }

                }
                System.out.println(PlayerMrJack.getSablier());
                System.out.println(PlayerMrJack.getMrJackCard());
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i).getPosition().getEtatTuile() + " " + alibiList.get(i));

                }
                tourCount += 1;
                listeJeton.add(jeton3Personnages);
                listeJeton.add(jetonAlibi);
                listeJeton.add(jetonDeplacerHOLMES);
                listeJeton.add(jetonDeplacerTOBY);
                listeJeton.add(jetonDeplacerWATSON);
                listeJeton.add(jetonEchangeTuile);
                listeJeton.add(jetonRotationTuile1);
                listeJeton.add(jetonRotationTuile2);
                jetonShuffle();


            }

        }
    }

    public void updateBoard() {
        this.currentBoard = new PlateauMrJack(AlibiName.values(), Detective.values());
    }

    public void printBoard() {
        for (Set<PositionableObject>[] ligne : currentBoard.getExtendedBoard()) {
            System.out.println(" ");
            for (Set<PositionableObject> cell : ligne) {
                System.out.print(cell +" ");
            }
        }
    }

    public void jetonShuffle(){
        Collections.shuffle(listeJeton);

    }
    public List <Jeton> listeJeton() {
        return listeJeton;
    }

}



