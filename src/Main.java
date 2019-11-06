import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Scanner reader = new Scanner(System.in);
        Board gameBoard = new Board();

        int x;
        int y;
        String owner;

        System.out.print("Input x coord: ");
        x = Integer.parseInt(reader.nextLine());
        System.out.print("Input y coord: ");
        y = Integer.parseInt(reader.nextLine());

        gameBoard.addCoords(x, y, "player");

        gameBoard.getCoords();

        System.out.println(gameBoard.checkCoords(1,1,"player"));
    }
}
