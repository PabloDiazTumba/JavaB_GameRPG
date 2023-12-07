import com.Pablo.demo.Player;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class PlayerTest {

    @Test
    public void testDefend() {
        Player player = new Player("TestPlayer");

        player.xp = 50;
        player.numAtkUpgrades = 2;
        player.numDefUpgrades = 1;

        int result = player.defend();

        // Print the actual result for debugging
        System.out.println("Actual result: " + result);

        assertTrue(result >= 20 && result <= 40);
    }
}
