package Game;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)

public abstract class GameEntity {
    protected String[][] maze;
    protected int playerRow;
    protected int playerCol;

    public GameEntity(String[][] maze, int startRow, int startCol) {
        this.maze = maze;
        this.playerRow = startRow;
        this.playerCol = startCol;
    }
}