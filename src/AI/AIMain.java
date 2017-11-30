package AI;

import core.gameCore;

import java.util.ArrayList;

public class AIMain {

    PositionCalculator logic;
    AIGame choice;
    char selfSymbol, opponentSymbol;

    public void setUp(char selfSymbol, char opponentSymbol)
    {
        this.selfSymbol = selfSymbol;
        this.opponentSymbol = opponentSymbol;
        logic =  new PositionCalculator(selfSymbol, opponentSymbol);

    }

    /*
    Set Next move by
    using PositionCalculator to Calculate each empty space chance
    Use AIGame to decide which space is chosen
     */
    public AIBlock setNextMove(final gameCore gameMap)
    {
        logic.update_gameMap(gameMap);
        ArrayList<AIBlock> allChances = logic.all_AvailableBlock_chance(opponentSymbol);
        System.out.println(allChances.toString());
        System.out.println(allChances.get(1).getChance());

        return findLargestChanceOpponent(allChances);

    }
    public AIBlock findLargestChanceOpponent(ArrayList<AIBlock> input)
    {
        AIBlock largest = input.get(0);
        for (AIBlock eachBlock : input)
        {
            if (eachBlock.getChance() > largest.getChance())
                largest = eachBlock;
        }
        return largest;
    }
}
