public class Coords {

    private int x;
    private int y;
    private String owner;

    public Coords(int x, int y, String owner){
        this.x = x;
        this.y = y;
        this.owner = owner;
    }

    public String toString(){
        return this.x + ", " + this.y + ", " + owner;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getOwner() {
        return owner;
    }
}
