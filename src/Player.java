public class Player {

    private String name;
    public Player(String setName){
        this.name = setName;
    }

    public Coords makeMove(int x, int y){
        return new Coords(x,y,"p");
    }
}
