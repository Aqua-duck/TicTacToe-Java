import java.util.ArrayList;
import java.util.List;

// p = player
// c = computer
// e = empty
@SuppressWarnings("SpellCheckingInspection")
public class Board {

    private String[][] grid = new String[3][3];
    public List<Coords> moves = new ArrayList<>();

    public Board() {
        //Invalid coordinate in order to allow list to be rendered
        //Should look up why this happens
    }

    public boolean addCoords(Coords c) {
        for (Coords t : this.moves) {
            //Check if coordinate already exists
            if (c.getX() == t.getX() && c.getY() == t.getY()
                    //Check if coordinate is out of bounds
                || c.getX() < 1 || c.getX() > 3
                || c.getY() < 1 || c.getY() > 3) {
                return false;
            }
        }
        moves.add(c);
        return true;

    }

    public boolean checkCoords(int x, int y, String owner) {
        for (Coords c : this.moves) {
            if (c.getX() == x && c.getY() == y && c.getOwner() == owner) {
                return true;
            }
        }
        return false;
    }

    public String buildBoard(Player player1, Player player2) {
        StringBuilder board = new StringBuilder();
        //Move through 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Check every item in list "moves" for these coordinates
                for (Coords c : this.moves) {
                    if (c.getX() == i+1 && c.getY() == j+1) {
                        //If the player owns the coordinates
                        if (c.getOwner().equals(player1.getName())) {
                            grid[i][j] = "X";
                        }
                        //If the computer owns the coordinates
                        if (c.getOwner().equals("c") || c.getOwner().equals(player2.getName())) {
                            grid[i][j] = "O";
                        }
                    }
                }
                //Render any null items in grid as "_"
                if (grid[i][j] == null) {
                    grid[i][j] = "_";
                }
            }
        }

        //Add all rendered spaces to the grid array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.append(grid[i][j]);
            }
            board.append("\n");
        }

        //Return the rendered board
        return board.toString();
    }

}
