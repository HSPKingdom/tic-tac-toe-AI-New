package AI;

import core.gameCore;
import game.insertItem;

public class AIMain {

    AILogic logic;
    AIGame choice;
    char selfSymbol, opponentSymbol;

    public void setUp(char selfSymbol, char opponentSymbol)
    {
        this.selfSymbol = selfSymbol;
        this.opponentSymbol = opponentSymbol;
        logic =  new AILogic(selfSymbol, opponentSymbol);

    }

    /*
    Set Next move by
    using AILogic to Calculate each empty space chance
    Use AIGame to decide which space is chosen
     */
    public AIBlock setNextMove(final gameCore gameMap)
    {
        logic.update_gameMap(gameMap);
        choice.updateOpponentChance(logic.all_AvailableBlock_chance(opponentSymbol));


        return choice.findLargestChanceOpponent();

    }
}
