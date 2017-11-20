package game;

import AI.AILogic;
import core.Player;
import core.gameCore;
import player.AI_Interface;
import player.humanInterface;

public class GameManager {
    private gameCore gameMap = new gameCore();
    private Player players[] = new Player[2] ;
    private char current = ' ';

    public GameManager()
    {
        players[0] = new humanInterface();
        //players[1] = new humanInterface();
        players[1] = new AI_Interface();
        players[0].setSymbol('X');
        //players[1].setSymbol('O');
        players[1].setSymbol('O');
        players[1].setOpponentSymbol(players[0].getSymbol());
    }


    public void mainGame()
    {
        int turn = 0;
        while(gameMap.getCount() <9 && checkGameWin() == false)     // And also if game not lose
        {
            current = players[turn].getSymbol();
            gameMap.setPosition(players[turn].setInput(gameMap));
            System.out.println(gameMap.get_gameMapString());
            System.out.println(gameMap.getCount());

            // TEST
            /*
            AILogic ai = new AILogic('X', 'O');
            ai.update_gameMap(gameMap);
            System.out.println("x = 1, y = 2 Chance is :" + ai.chanceCalculator(1,2,'O'));
            */
            // Find is X or O turn reset when O
            if(turn >= 1)
                turn = 0;
            else
                turn += 1;
        }
        if(checkGameWin()==true)
        {
            System.out.println("Winner is " + current);
        }
        else
        {
            System.out.println("Drawn");
        }

    }

    public boolean checkGameWin()
    {
        //Check from the center
        // 12 22 32 * 21 22 23 * 11 22 33 * 13 22 31
        char [][] map = gameMap.getGame_map();
        if( map[2][2] != ' ' &&  ((map[1][2] == map[2][2] && map[2][2] == map[3][2]) || (map[2][1] == map[2][2] && map[2][2] == map[2][3]) ||
                (map[1][1] == map[2][2] && map[2][2] == map[3][3]) || (map[1][3] == map[2][2] && map[2][2] == map[3][1])) )
            return true;
        // 11 21 31 * 11 12 13 * 13 23 33 * 31 32 33
        else if ( (map[1][1]!= ' ' && map[1][1] == map[2][1] && map[2][1] == map[3][1]) || (map[1][1] != ' ' && map[1][1] == map[1][2] && map[1][2] == map[1][3]) ||
                (map[1][3] != ' ' && map[1][3] == map[2][3] && map[2][3] == map[3][3]) || (map[3][1] != ' ' && map[3][1] == map[3][2] && map[3][2] == map[3][3]) )
            return true;
        else return false;

    }


}
