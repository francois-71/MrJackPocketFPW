import java.sql.Array;
import java.util.*;

public enum PlateauJeu {

    PLATEAU;

    class PlateauMrJack {
        private final AlibiName[][] tableau = new AlibiName[3][3]; // Initialise un tableau vide 3X3
        private final Detective[][] tableau2 = new Detective[5][5];

        public PlateauMrJack(AlibiName[] alibis, Detective[] detectives) {
            for (AlibiName alibi : alibis) {         // On place dans un tableau les alibis
                Position p = alibi.getPosition();    // On attribue grâce à un passage dans la boucle une position unique p à chaque alibis
                tableau[p.getLigne()][p.getColonne()] = alibi; // on remplit le tableau de tous les alibis
            }
            for (Detective detective : detectives) { // Même chose qu'au dessus, mais pour les detectives cette fois.
                Position p = detective.getPosition();
                tableau2[p.getLigne()][p.getColonne()] = detective;
            }
        }
        public Set<PositionableObject>[][] getExtendedBoard() { // Plus haut, nous avons crée 2 tableau, de types différents (AlibiName et Detective)
            HashSet<PositionableObject>[][] board = new HashSet[5][5]; // On utilise une interface pour faire un tableau de ce type, afin de regrouper AlibiName et Detective dans un même board


            for (int i = 0; i < 5; i++) {
                for (int j = 0; j < 5; j++) { //Initialise le tableau sans valeurs à l'intérieur des cellules
                    board[i][j] = new HashSet<>();
                }
            }
            for (int i = 0; i < 3; i++) {
                for (int j = 0; j < 3; j++) {
                    board[i + 1][j + 1].add(this.tableau[i][j]); // Initialise le tableau avec les emplacements des alibis (on décale de i+1, j+1 par rapport à leur position dans "tableau" plus haut).
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
    Jeton jeton3Personnages = new Jeton3Personnages(); // création des jetons jusqu'à la ligne 59.
    Jeton jetonAlibi = new JetonAlibi();
    Jeton jetonDeplacerHOLMES = new JetonDeplacerHOLMES();
    Jeton jetonDeplacerTOBY = new JetonDeplacerTOBY();
    Jeton jetonDeplacerWATSON = new JetonDeplacerWATSON();
    Jeton jetonEchangeTuile = new JetonEchangeTuile();
    Jeton jetonRotationTuile1 = new JetonRotationTuile();
    Jeton jetonRotationTuile2 = new JetonRotationTuile();
    List<Jeton> listeJeton = new ArrayList<>();
    int choice;
    int tourCount=1;

    PlateauJeu() {


        AlibiName.placerAlibi(); // place les alibis dans un ordre aléatoire
        Detective.placerDetective(); // place les detectives
        PlayerMrJack.setMrJackCard(); // Etablit l'identité de MrJack.
        listeJeton.add(jeton3Personnages);
        listeJeton.add(jetonAlibi);
        listeJeton.add(jetonDeplacerHOLMES);
        listeJeton.add(jetonDeplacerTOBY);
        listeJeton.add(jetonDeplacerWATSON);
        listeJeton.add(jetonEchangeTuile);
        listeJeton.add(jetonRotationTuile1);
        listeJeton.add(jetonRotationTuile2);
        jetonShuffle();
        Scanner scanner = new Scanner(System.in); // On crée un premier scanner pour interagir avec l'utilisateur
        Scanner protection = new Scanner(System.in); // On crée un deuxième scanner uniquement pour ne pas passer au tour de MrJack directement (pour ne pas dévoiler son identité);

        HashSet <AlibiName> listAlibisReturned = new HashSet<>();
        List<AlibiName> alibiList = Arrays.asList(AlibiName.values());



        while (tourCount <= 8 && PlayerMrJack.getSablier() <= 6) {

            if ((tourCount % 2) != 0){
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println(" ");
                System.out.println("Tour : " + tourCount);

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
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();
                } while (!(choice == 0 || choice == 1 || choice == 2 || choice == 3));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();

                //FIN ACTION PREMIER JETON
                //A MrJack de jouer les 2 prochains jetons

                Tour.setPlayer("MrJack");
                System.out.println(" ");

                System.out.println("MrJack, c'est à votre tour de jouer 2 jetons");
                System.out.println("Ecrivez quelque chose pour continuer");
                protection.nextLine();
                System.out.println("Votre identité est : " + PlayerMrJack.getMrJackCard());
                System.out.println("");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println(" ");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                System.out.print("2: ");
                listeJeton().get(2).getName();
                do {
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();
                } while (!(choice == 0 || choice == 1 || choice == 2));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);

                System.out.println(" ");
                updateBoard();
                printBoard();

                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println(" ");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                System.out.println("MrJack, choisissez votre 2ème jeton");
                System.out.println("Votre identité est : " + PlayerMrJack.getMrJackCard());
                System.out.println("");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                do {
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (!(choice == 0 || choice == 1));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println(" ");
                System.out.println("Tour : " + tourCount);
                Tour.setPlayer("Detective");
                System.out.println(" ");
                System.out.println("Detective, jouez le dernier jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();

                do {

                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (choice != 0);
                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }


                System.out.println(Detective.isVisible(AlibiName.values()));
                ArrayList<AlibiName> listAlibisVisible = new ArrayList(Detective.isVisible(AlibiName.values()));


                if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard()) && listAlibisReturned.size() != 8) {
                    System.out.println(" ");
                    System.out.println("MrJack fait partie des Alibis visible");
                    for (int i = 0; i < AlibiName.values().length; i++) {
                        if (!listAlibisVisible.contains(alibiList.get(i))) {
                            AlibiName.tournerTuile(alibiList.get(i));
                            listAlibisReturned.add(alibiList.get(i));

                        }
                    }

                } else if (!listAlibisVisible.contains(PlayerMrJack.getMrJackCard()) && listAlibisReturned.size() != 8) {
                    System.out.print(" ");
                    System.out.println("MrJack ne fait pas partie des Alibis visible");
                    PlayerMrJack.sablierAddFinTour();
                    for (int i = 0; i < listAlibisVisible.toArray().length; i++) {
                        AlibiName.tournerTuile(listAlibisVisible.get(i));
                        listAlibisReturned.add(listAlibisVisible.get(i));
                    }
                }

                if (PlayerMrJack.getSablier() > 5 && listAlibisReturned.size() == 8){ // Si les deux joueurs ont remplis leur objectif au même moment
                    if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard())) { //Si MrJack est la seule carte alibi visible (Seule carte car pour acceder à cette condition, les 8 autres cartes doivent déjà être retournée)
                        System.out.println("Le detective l'emporte");
                        break;
                    }
                    else if (!listAlibisVisible.contains(PlayerMrJack.getMrJackCard())){ //Si MrJack n'est pas visible, mais qu'il reste que lui
                        System.out.println("MrJack gagne");
                        break;

                    }
                }else if (PlayerMrJack.getSablier() > 5 || tourCount >= 8){
                    System.out.println("MrJack l'emporte");
                    break;
                }else if (listAlibisReturned.size() == 8){
                    System.out.println("Le detective l'emporte");
                    break;
                }
                tourCount++;
            }
            else{
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println("");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                Tour.setPlayer("MrJack");
                System.out.println(" ");

                System.out.println("MrJack, c'est à vous");
                System.out.println("Ecrivez quelque chose pour continuer");
                protection.nextLine();
                System.out.println("Votre identité est : " + PlayerMrJack.getMrJackCard());
                System.out.println("");
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
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (!(choice == 0 || choice == 1 || choice == 2 || choice == 3));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();

                //FIN ACTION PREMIER JETON
                //A MrJack de jouer les 2 prochains jetons
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println("");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                Tour.setPlayer("Detective");

                System.out.println("Detective, c'est à votre tour de jouer 2 jetons");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                System.out.print("2: ");
                listeJeton().get(2).getName();
                do {
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (!(choice == 0 || choice == 1 || choice == 2));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);

                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println("");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                System.out.println("Detective, choisissez votre 2ème jeton");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();
                System.out.print("1: ");
                listeJeton().get(1).getName();
                do {
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (!(choice == 0 || choice == 1));
                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println("");
                System.out.println("Tour : " + tourCount);
                System.out.println("");
                Tour.setPlayer("MrJack");

                System.out.println(" ");
                System.out.println("MrJack, jouez le dernier jeton");
                System.out.println("Ecrivez un mot pour continuer");
                protection.nextLine();
                System.out.println("Votre identité est : " + PlayerMrJack.getMrJackCard());
                System.out.println("");
                System.out.println("Jetons disponible: ");
                System.out.print("0: ");
                listeJeton().get(0).getName();

                do {
                    System.out.println("Tapez le nombre");
                    choice = scanner.nextInt();

                } while (choice != 0);


                listeJeton().get(choice).action();
                listeJeton().remove(choice);
                System.out.println(" ");
                updateBoard();
                printBoard();
                System.out.println(" ");
                for (int i = 0; i < AlibiName.values().length; i++) {
                    System.out.println(alibiList.get(i) + " - " + alibiList.get(i).getPosition().getEtatTuile() + " - " + alibiList.get(i).getPosition().getSens());
                }
                System.out.println(" ");


                ArrayList<AlibiName> listAlibisVisible = new ArrayList(Detective.isVisible(AlibiName.values()));



                if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard()) && listAlibisReturned.size() != 8) {
                    System.out.println(" ");
                    System.out.println("MrJack fait partie des Alibis visible");
                    for (int i = 0; i < AlibiName.values().length; i++) {
                        if (!listAlibisVisible.contains(alibiList.get(i))) {
                            AlibiName.tournerTuile(alibiList.get(i));
                            listAlibisReturned.add(alibiList.get(i));

                        }
                    }

                } else if (!listAlibisVisible.contains(PlayerMrJack.getMrJackCard()) && listAlibisReturned.size() != 8) {
                    System.out.println(" ");
                    System.out.println("MrJack ne fait pas partie des Alibis visible");
                    PlayerMrJack.sablierAddFinTour();
                    for (int i = 0; i < listAlibisVisible.toArray().length; i++) {
                        AlibiName.tournerTuile(listAlibisVisible.get(i));
                        listAlibisReturned.add(listAlibisVisible.get(i));
                    }
                }

                if (PlayerMrJack.getSablier() > 5 && listAlibisReturned.size() == 8){ // Si les deux joueurs ont remplis leur objectif au même moment
                    if (listAlibisVisible.contains(PlayerMrJack.getMrJackCard())) { //Si MrJack est la seule carte alibi visible (Seule carte car pour acceder à cette condition, les 8 autres cartes doivent déjà être retournée)
                        System.out.println("Le detective l'emporte");
                        break;
                    }
                    else if (!listAlibisVisible.contains(PlayerMrJack.getMrJackCard())){ //Si MrJack n'est pas visible, mais qu'il reste que lui,
                        System.out.println("MrJack gagne");
                        break;

                    }
                }else if (PlayerMrJack.getSablier() > 5 || tourCount >= 8){
                    System.out.println("MrJack l'emporte");
                    break;
                }else if (listAlibisReturned.size() == 8){
                    System.out.println("Le detective l'emporte");
                    break;
                }
                tourCount++;


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
        System.out.println(listAlibisReturned);
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
        System.out.println(" ");
    }

    public void jetonShuffle(){
        Collections.shuffle(listeJeton);

    }
    public List <Jeton> listeJeton() {
        return listeJeton;
    }

}



