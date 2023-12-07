import com.Pablo.demo.GameLogic;
import org.junit.Test;

import java.io.ByteArrayInputStream;

import static org.junit.Assert.*;

public class GameLogicTest {

    @Test
    public void testReadIntWithInvalidInput() {
        GameLogic gameLogic = new GameLogic();

        System.setIn(new ByteArrayInputStream("invalid\n1".getBytes()));

        int result = gameLogic.readInt("Enter a number: ", 5);
        assertEquals(1, result);

        System.setIn(System.in);
    }

}
