package Game;
import java.util.Scanner;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)

public class Player extends GameEntity {
    public Player(String[][] maze, int startRow, int startCol) {
        super(maze, startRow, startCol);
    }

    public int getPlayerRow() {
        return playerRow;
    }

    public int getPlayerCol() {
        return playerCol;
    }

    public void movement(String move) {
        Scanner scanner = new Scanner(System.in);
        
        // Get player input
        System.out.print("Enter your move (W/A/S/D/Q): ");
        move = scanner.nextLine().toUpperCase();

        // Update player position based on input
        switch (move) {
            case "W":
                if (maze[playerRow - 1][playerCol] != "#") {
                    maze[playerRow][playerCol] = " "; // Clear the current position
                    playerRow--;
                }
                break;
            case "A":
                if (maze[playerRow][playerCol - 1] != "#") {
                    maze[playerRow][playerCol] = " "; // Clear the current position
                    playerCol--;
                }
                break;
            case "S":
                if (maze[playerRow + 1][playerCol] != "#") {
                    maze[playerRow][playerCol] = " "; // Clear the current position
                    playerRow++;
                }
                break;
            case "D":
                if (maze[playerRow][playerCol + 1] != "#") {
                    maze[playerRow][playerCol] = " "; // Clear the current position
                    playerCol++;
                }
                break;
            case "Q":
                System.out.println("You quit the game.");
                System.exit(0);
                break;
            default:
                System.out.println("Invalid move.");
                break;
        }
        maze[playerRow][playerCol] = "P"; // Update the new position with 'P'
    }

}
