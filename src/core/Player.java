package core;

import game.insertItem;

public abstract class Player {
    private char symbol;
    private insertItem item = new insertItem();

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

    public insertItem getItem()
    {
        return item;
    }

    public abstract insertItem setInput(gameCore game);

    public abstract void setOpponentSymbol(char opponentSymbol);



}
