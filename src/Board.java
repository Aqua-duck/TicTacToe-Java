import java.util.ArrayList;
import java.util.List;

// p = player
// c = computer
// e = empty
@SuppressWarnings("SpellCheckingInspection")
public class Board {

    private String[][] grid = new String[3][3];
    private List<Coords> moves = new ArrayList<>();

    public Board() {
        //Invalid coordinate in order to allow list to be rendered
        //Should look up why this happens
    }

    public boolean addCoords(Coords c) {
        for (Coords t : this.moves) {
            if (c.getX() == t.getX() && c.getY() == t.getY()) {
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

    public String buildBoard() {
        StringBuilder board = new StringBuilder();
        //Move through 2D array
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                //Check every item in list "moves" for these coordinates
                for (Coords c : this.moves) {
                    if (c.getX() == i && c.getY() == j) {
                        //If the player owns the coordinates
                        if (c.getOwner().equals("p")) {
                            grid[i][j] = "X";
                        }
                        //If the computer owns the coordinates
                        if (c.getOwner().equals("c")) {
                            grid[i][j] = "O";
                        }
                    }
                }
                if (grid[i][j] == null) {
                    grid[i][j] = "_";
                }
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board.append(grid[i][j]);
            }
            board.append("\n");
        }
        return board.toString();
    }

}
