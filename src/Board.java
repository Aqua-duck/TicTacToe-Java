import java.util.ArrayList;
import java.util.List;

@SuppressWarnings("SpellCheckingInspection")
public class Board {

    private List<Coords> grid = new ArrayList<>();

    public Board(){
        //Invalid coordinate in order to allow list to be rendered
        //Should look up why this happens
        grid.add(new Coords(-1,-1,"e"));
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

    public String boardState(){
        String boardString = "";
        for (Coords c : this.grid){
            for (int i = 0; i < 3; i++){
                for (int j = 0; j < 3; j++){

                   if (c.getX() == i && c.getY() == j){

                       if (c.getOwner() == "p"){
                           boardString += "X";
                       }
                       if (c.getOwner() == "c"){
                           boardString += "O";
                       }
                   } else {
                       boardString += "_";
                   }
                }
                boardString += "\n";
            }
        }
        return boardString;
    }

}
