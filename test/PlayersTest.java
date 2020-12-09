import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class PlayersTest {
    @Test
    public void renvoiDetective() {
        assertEquals("Detective",Players.DETECTIVE.getName(), "ne m'a pas renvoyé Detective");
}



}
