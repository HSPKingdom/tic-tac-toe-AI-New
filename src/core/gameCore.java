package core;

import game.insertItem;

public class gameCore {

	private char game_map[][] = new char[4][4];
	private int count = 0;

	public gameCore(){
	    for(int i=1; i<=3; i++)
            for(int j=1; j<=3; j++)
                game_map[i][j] = ' ';

    }

    public boolean checkBoxEmpty(int x, int y)
    {
        if(game_map[x][y] == ' ') {
            return true;
        }
        return false;
    }

    /**
     * Set the position to insertItem
     * @param x     X - axis
     * @param y     Y - axis
     * @param item  Identifier X or O
     */
    public void setPosition(int x, int y, char item)
    {
        game_map[x][y] = item;
        count += 1;
    }

    public void setPosition(insertItem input)
    {
        game_map[input.getX()][input.getY()] = input.getSymbol();
        count += 1;
    }

    /**
     * Get how many insertItem insert in the map
     * @return  number
     */
    public int getCount() {
        return count;
    }

    /**
     * Get the insertItem from the position
     * @param x     X - axis
     * @param y     Y - axis
     * @return  insertItem
     */
    public char getPosition(int x, int y)
    {
        return game_map[x][y] ;
    }
    /**
     * Print the gamemap
     * @return game_map string
     */
    public String get_gameMapString()
    {
        String output = "";
        for(int i=1; i<=3; i++)
        {
            output += "|\t\t|\t\t|\t\t|\n|";
            for (int j = 1; j <= 3; j++)
            {
                output += "\t" + game_map[i][j] + "\t|";
            }
            output += "\n|\t\t|\t\t|\t\t|\n";
            output += "=========================\n";

        }
        return output;
    }

    public char[][] getGame_map() {
        return game_map;
    }
}
