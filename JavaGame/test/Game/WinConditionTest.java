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
public class WinConditionTest {
    
    public WinConditionTest() {
    }
    
    @Test
    public void testCheckGameEnd_PlayerWins() {
        String[][] maze = {
            {"#", " ", "#", "E"},
            {"#", " ", " ", " "},
            {"#", " ", "#", "#"},
        };
        WinCondition winCondition = new WinCondition(maze, 0, 3);
        winCondition.checkGameEnd();

        assertTrue(winCondition.isGameWon());
    }

    @Test
    public void testCheckGameEnd_PlayerNotAtExit() {
        String[][] maze = {
            {"#", " ", "#", " "},
            {"#", " ", " ", " "},
            {"#", " ", "#", "#"},
        };
        WinCondition winCondition = new WinCondition(maze, 0, 1);
        winCondition.checkGameEnd();

        assertFalse(winCondition.isGameWon());
    }
    
}
