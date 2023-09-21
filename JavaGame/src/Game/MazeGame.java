package Game;
// All information sourced from Joyce Farrel,202, Java Programming Cengage 9th Edition
// and Bro Code, 2020, Java Full Course for Free, Youtube (https://www.youtube.com/watch?v=xk4_1vDrzzo)

import Game.Player;
import java.util.Scanner;

public class MazeGame {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        // maze 1 
        String[][] mazeLevel1= {
             {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", " ", "#", " ", "#"},
            {"#", " ", "#", "#", "#", "#", "#", " ", " ", "#", " ", "#", "#", " ", "#", " ", "#"},
            {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#", " ", " ", "#", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "E", "#"},
        };
        // maze 2
        String[][] mazeLevel2 = {
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", "#", " ", " ", " ", "#", " ", " ", " ", " ", " ", " ", " ", "#"}, 
            {"#", " ", " ", " ", "#", " ", "#", " ", "#", " ", " ", " ", " ", " ", " ", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", "#", "#"},
            {"#", " ", "#", " ", " ", " ", "#", " ", " ", "#", " ", " ", " ", " ", "#", " ", "#"},
            {"#", " ", "#", "#", "#", "#", "#", " ", " ", "#", " ", "#", "#", " ", "#", " ", "#"},
            {"#", " ", " ", " ", " ", " ", " ", " ", " ", "#", " ", " ", "#", " ", " ", " ", "#"},
            {"#", "#", "#", " ", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", " ", "#"},
            {"#", " ", "#", " ", "#", " ", "#", "#", "#", "#", " ", "#", "#", "#", "#", " ", "#"},
            {"#", " ", "#", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", "#", "#", " ", "#"},
            {"#", " ", "#", "#", "#", "#", "#", " ", " ", "#", " ", "#", "#", "E", "#", " ", "#"},
            {"#", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", " ", "#", " ", " ", " ", "#"},
            {"#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#", "#"},
        };
        // default level
        int currentLevel = 1;
        // while loop for menu
        while (true) {

            System.out.println("Maze Game");
            System.out.println("1. Level 1");
            System.out.println("2. Level 2");
            System.out.println("Q. Quit");
            System.out.print("Choose a level (1/2/Q): ");

            String choice = scanner.nextLine().toUpperCase();

            if (choice.equals("Q")) {
                System.out.println("Goodbye!");
                break;
            } else if (choice.equals("1")) {
                playMazeGame(mazeLevel1, currentLevel);
                currentLevel = 1;
            } else if (choice.equals("2")) {
                playMazeGame(mazeLevel2, currentLevel);
                currentLevel = 2;
            } else {
                System.out.println("Invalid choice. Please try again.");
            }
        }

        scanner.close(); // 
    }

    public static void playMazeGame(String[][] maze, int currentLevel) {
        Player player = new Player(maze, 1, 1);
        int exitRow = findExitRow(maze);
        int exitCol = findExitCol(maze);

        while (true) {
            // Clear the console
            System.out.print("\033[H\033[2J");
            System.out.flush();

            // Display the current maze
            for (int i = 0; i < maze.length; i++) {
                for (int j = 0; j < maze[i].length; j++) {
                    if (i == player.getPlayerRow() && j == player.getPlayerCol()) {
                        System.out.print('P'); // Player
                    } else {
                        System.out.print(maze[i][j]);
                    }
                    System.out.print(' '); 
                }
                System.out.println(); 
            }

            player.movement("w");
            int playerRow = player.getPlayerRow();
            int playerCol = player.getPlayerCol();

            if (playerRow == exitRow && playerCol == exitCol) {
                // Clear the console before displaying the victory message
                System.out.print("\033[H\033[2J");
                System.out.flush();
                System.out.println("Congratulations! You won level " + currentLevel);
                break;
            }
        }
    }
    // used to locate where the exit is
    public static int findExitRow(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == "E") {
                    return i;
                }
            }
        }
        return -1; // Return -1 if no exit is found
    }
    // used to locate where the exit is
    public static int findExitCol(String[][] maze) {
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[i].length; j++) {
                if (maze[i][j] == "E") {
                    return j;
                }
            }
        }
        return -1; // Return -1 if no exit is found
    }
}
