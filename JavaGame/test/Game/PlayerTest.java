package Game;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
/**
 *
 * @author Dean
 */

public class PlayerTest {
    
    public PlayerTest() {
    }
    
    @Test
    public void testPlayerMovement_ValidMove() {
        String[][] maze = {
            {"#", " ", "#", "E"},
            {"#", " ", " ", " "},
            {"#", " ", "#", "#"},
        };
        Player player = new Player(maze, 0, 1);
                
        player.movement("w");

        assertEquals(1, player.getPlayerRow());
        assertEquals(1, player.getPlayerCol());
    }

    @Test
    public void testPlayerMovement_InvalidMove() {
        String[][] maze = {
            {"#", " ", "#", "E"},
            {"#", " ", " ", " "},
            {"#", " ", "#", "#"},
        };
        Player player = new Player(maze, 0, 1);
        player.movement("A"); 

        assertEquals(0, player.getPlayerRow());
        assertEquals(1, player.getPlayerCol());
    }
    
}
