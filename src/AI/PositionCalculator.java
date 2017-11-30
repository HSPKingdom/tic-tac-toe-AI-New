package AI;

import core.gameCore;

import java.util.ArrayList;

/**
 * Analyse which block is the closest to win
 */
public class PositionCalculator {
    private gameCore gameMap;   // Set as class variable as may use as comparing previous data later
    private char selfSymbol;
    private char opponentSymbol;

    public PositionCalculator(final char selfSymbol, final char opponentSymbol)
    {
        this.selfSymbol = selfSymbol;
        this.opponentSymbol = opponentSymbol;
    }

    // Update the game map
    public void update_gameMap(gameCore gameMap)
    {
        this.gameMap = gameMap;
    }

    // Check all the Chances of Wining for Empty Block
    // Input Opponent Symbol: Check what is the possible opponent next move
    // Input Self Symbol: Check the highest win rate of the next move
    public ArrayList<AIBlock> all_AvailableBlock_chance(final char target)
    {
        ArrayList<AIBlock> logic = new ArrayList<>();
        for(int i = 1; i <= 3; i++)
            for(int j = 1; j <= 3; j++)
            {
                if(gameMap.checkBoxEmpty(i,j))
                {
                    AIBlock temp = new AIBlock(i, j, chanceCalculator(i, j, target));
                    logic.add(temp);
                }
            }
        return logic;
    }

    public int chanceCalculator(final int x, final int y, final char target)
    {
        int score = 0;
        int straightCount = 0, sideCount = 0, slashCount = 0;
        //Straight Case
        for(int i = 1; i <= 3; i++)
        {
            if(i != x && gameMap.getPosition(i, y) == target)
                straightCount += 1;

            if(i != y && gameMap.getPosition(x, i) == target)
                sideCount += 1;
        }

        score += (straightCount*2) + (sideCount*2);


        // Slash case
        if( (y == 2 && x != 2)||( x == 2 && y != 2))
        {

        }
        else if (x == 2 && y == 2)
        {
            if(gameMap.getPosition(1,1) == target)
                slashCount += 1;
            if(gameMap.getPosition(3,3) == target)
                slashCount += 1;
            score += slashCount*2;

            // Another Direction
            slashCount = 0;
            if(gameMap.getPosition(1,3) == target)
                slashCount += 1;
            if(gameMap.getPosition(3,1) == target)
                slashCount += 1;
            score += slashCount*2;
        }
        else
        {
            int moveX = 0, moveY = 0, tempX = x, tempY = y;
            if(x == 1)
                moveX = 1;
            else if(x == 3)
                moveX = -1;
            if(y == 1)
                moveY = 1;
            else if(y == 3)
                moveY = -1;

            for(int i = 0; i <= 1; i++)
            {
                tempX += moveX;
                tempY += moveY;
                if(gameMap.getPosition(tempX, tempY) == target)
                {
                    slashCount += 1;
                }
            }

        }

        score += (slashCount*2);
        return score;
    }
    // Find empty position chance
    // Pre: Position must be empty
    public int oldchanceCalculator(final int x, final int y, final char target) {
        int chance = 0;

        // If Case in center
        if (x == 2 && y == 2) {
            for (int i = 1; i <= 3; i++)
                for (int j = 1; j <= 3; j++) {
                    if (gameMap.getPosition(i, j) == target)
                        chance += 1;
                }
        }
        else {

            int exceptionX1 = -1, exceptionX2 = -1, exceptionY1 = -1, exceptionY2 = -1;
            // The Diagonal Cases
            if (x == 3 && y == 1) {
                exceptionX1 = x - 1 ;
                exceptionY1 = y + 2 ;
                exceptionX2 = x - 2 ;
                exceptionY2 = y + 1 ;
            } else if (x == 3 && y == 3) {
                exceptionX1 = x - 2 ;
                exceptionY1 = y - 1 ;
                exceptionX2 = x - 1 ;
                exceptionY2 = y - 2 ;
            } else if (x == 1 && y == 1) {
                exceptionX1 = x + 1 ;
                exceptionY1 = y + 2 ;
                exceptionX2 = x + 2 ;
                exceptionY2 = y + 1 ;
            } else if (x == 1 && y == 3) {
                exceptionX1 = x + 2;
                exceptionY1 = y - 1 ;
                exceptionX2 = x + 1 ;
                exceptionY2 = y - 2 ;
            }
            if(exceptionX1 != -1)
            {
                for(int i = 1; i <= 3; i++)
                    for(int j = 1; j <= 3; j++)
                    {
                        if (!( (i == exceptionX1 && j == exceptionY1) || (i == exceptionX2 && j == exceptionY2) ))
                        {
                            if ((i != x || i != y) && gameMap.getPosition(i,j) == target)
                                chance += 1;
                        }
                    }
            }
            else{
                for (int i = 1; i <= 3; i++) {
                    if (i != x && gameMap.getPosition(i, y) == target)
                        chance += 1;
                    if (i != y && gameMap.getPosition(x, i) == target)
                        chance += 1;
                }
            }
        }
        System.out.println("Log:        Wining rate of Target >>>" + target + "<<< in location [" + x + ", " + y + "] is --> " + chance);
        return chance;
    }
}
