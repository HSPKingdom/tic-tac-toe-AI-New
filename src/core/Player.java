package core;

import game.Item;

public abstract class Player {
    private char symbol;
    private Item item = new Item();

    public Player()
    {
        symbol = ' ';
    }

    public char getSymbol()
    {
        return symbol;
    }

    public void setSymbol(char symbol)
    {
        this.symbol = symbol;
    }

    public void setItem(int x, int y)
    {
        item.setItem(x, y, symbol);
    }

    public Item getItem()
    {
        return item;
    }

    public abstract Item setInput(gameCore game);



}
