import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        Board gameBoard = new Board();

        gameBoard.addCoords(new Coords(1, 2, "p"));
        System.out.println(gameBoard.buildBoard());
    }
}
