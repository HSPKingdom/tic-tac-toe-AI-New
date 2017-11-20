package game;

public class insertItem {
    private int x;
    private int y;
    private char symbol;

    public insertItem(){
        x = -1;
        y = -1;
        symbol = ' ';
    }


    public void setItem(int x, int y, char symbol)
    {
        this.x = x;
        this.y = y;
        this.symbol = symbol;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public char getSymbol() {
        return symbol;
    }
}
