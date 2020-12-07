public class Main {
    public static void main(String[] args) {
        Players.DETECTIVE.addJeton();
        System.out.println(Players.DETECTIVE.jeton);
        Players.MRJACK.addJeton();
        System.out.println(Players.DETECTIVE.jeton);
    }

}