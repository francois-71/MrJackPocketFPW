import org.junit.jupiter.api.Test;


class DetectiveTest {
    @Test

    void Detective() {
        Detective.placerDetective();
        System.out.println(Detective.HOLMES.getPosition().getLigne());
    }
}