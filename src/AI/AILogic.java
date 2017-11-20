package AI;

import core.gameCore;

/**
 * Analyse which block is the closest to win
 */
public class AILogic {
    private gameCore gameMap;   // Set as class variable as may use as comparing previous data later
    private char selfSymbol;
    private char opponentSymbol;

    public AILogic(final char selfSymbol, final char opponentSymbol)
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
    public AIBlock [] all_AvailableBlock_chance(final char target)
    {
        AIBlock [] logic = new AIBlock[9];
        int logicCount = 0;
        for(int i = 1; i <= 3; i++)
            for(int j = 1; j <= 3; j++)
            {
                if(gameMap.checkBoxEmpty(i,j))
                {
                    System.out.println(logicCount);
                    logic[logicCount] = new AIBlock();
                    logic[logicCount].setAll(i, j, chanceCalculator( i, j, target));
                    logicCount += 1;
                }
            }
        AIBlock [] output = new AIBlock[logicCount+1];
        for(int i = 0; i<=logicCount; i++)
        {
            output[i] = new AIBlock();
            output[i] = logic[i];
        }
        return output;
    }
    // Find empty position chance
    // Pre: Position must be empty
    public int chanceCalculator(final int x, final int y, final char target) {
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
