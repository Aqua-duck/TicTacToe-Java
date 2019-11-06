import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class Board {

    private List<Coords> grid = new ArrayList<>();

    public Board(){
    }

    public void addCoords(int x, int y, String owner){
        grid.add(new Coords(x, y, owner));
    }

    public void getCoords(){
        for (Coords c : this.grid){
            System.out.println(c);
        }
    }

    public boolean checkCoords(int x, int y, String owner){
        for (Coords c : this.grid){
            if (c.getX() == x && c.getY() == y && c.getOwner() == owner){
                return true;
            }
        }
        return false;
    }

}
