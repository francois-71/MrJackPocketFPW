import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {
    @Test
    public void testAjoutJetonDonne1(){
        Players.DETECTIVE.addJeton();
        assertEquals(1, Players.DETECTIVE.jeton, "Ajoute ne marche pas");
    }

}
