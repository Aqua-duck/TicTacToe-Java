import java.util.Scanner;
import java.lang.Character;

public class Main {

    //Initializing class variables
    Board gameBoard = new Board();
    Scanner input = new Scanner(System.in);
    Player player1 = new Player("player1");
    Player player2 = new Player("player2");

    public static void main(String[] args) {
        //Is this proper...? I should look into this later
        Main main = new Main();

        //Start menu
        main.startMenu();

        boolean bool = main.didGameEnd();
        while (!bool) {
            main.round(main.player1);
            bool = main.didGameEnd();
            System.out.println(main.didGameEnd());
            main.round(main.player2);
            bool = main.didGameEnd();
            System.out.println(main.didGameEnd());
        }
    }

    public void round(Player player) {


        boolean done = false;
        while (!done) {

            //Prompt player to input their move
            System.out.print("Input coords: ");

            //Initializing relevant variables needed to acquire coordinates from player's input
            //**Add loop here to allow player to retry move in event of invalid move
            String move = input.nextLine();
            int x = 4;
            int y = 4;
            int charCheck = 0;
            Coords attemptMove = new Coords(0, 0, "e");

            //Parse through every character in player's input
            for (int i = 0; i < move.length(); i++) {
                char c = move.charAt(i);
                System.out.println("Character: " + move.charAt(i));
                //Check if character is number
                if (Character.isDigit(c)) {
                    if (charCheck == 0) {
                        x = Character.getNumericValue(c);
                        System.out.println("X value: " + x);
                    }
                    if (charCheck == 1) {
                        y = Character.getNumericValue(c);
                        System.out.println("Y value: " + y);
                        break;
                    }
                    //Increment to show that x value has already been assigned
                    charCheck++;
                }
            }
            System.out.println("Parsing characters complete");

            //Attempt to store provided coordinates into an object
            try {
                attemptMove = player.makeMove(x, y);
            } catch (Exception e) {
                System.out.println("Coordinates provided were invalid");
            }
            System.out.println("These are the coordinates you provided:");
            System.out.println(attemptMove);
            //Attempt to pass coordinates onto Board object to be stored
            try {
                if (!gameBoard.addCoords(attemptMove)) {
                    System.out.println("Move rejected! Either this spot is taken or your coordinates were out of bounds.");
                } else {
                    done = true;
                }
            } catch (Exception e) {
                System.out.println("Coordinate object was not valid");
            }
            System.out.println(gameBoard.buildBoard(player1, player2));
            System.out.println(gameBoard.moves.size());
        }
    }

    public int startMenu() {
        System.out.println("TIC TAC TOE: \n" +
                "Which version would you like to play?\n" +
                "1. Player vs. Player");
        System.out.print("Select version: ");

        int version = 0;
        boolean valid = false;
        while (!valid) {
            try {
                version = Integer.parseInt(input.nextLine());
                valid = true;
            } catch (Exception e) {
                System.out.println("Invalid version!");
            }
        }

        return version;
    }

    public boolean didGameEnd() {
        return gameBoard.moves.size() >= 9;
    }
}
