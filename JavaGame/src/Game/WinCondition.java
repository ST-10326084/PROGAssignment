package Game;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)

public class WinCondition extends GameEntity {
    private boolean gameWon;

    public WinCondition(String[][] maze, int startRow, int startCol) {
        super(maze, startRow, startCol);
        this.gameWon = false;
    }

    public boolean isGameWon() {
        return gameWon;
    }

    public void checkGameEnd() {
        // Check if the player has won
        if (maze[playerRow][playerCol].equals("E")) {
            gameWon = true;
            System.out.println("Congratulations! You won!");
        }
    }

    public void printMaze() {
    for (int i = 0; i < maze.length; i++) {
        for (int j = 0; j < maze[i].length; j++) {
            if (i == playerRow && j == playerCol) {
                System.out.print('P'); // Player
            } else {
                System.out.print(maze[i][j]);
            }
            System.out.print(' '); // Add a space to separate each cell for better visualization
        }
        System.out.println(); // Move to the next row
    }
}
}