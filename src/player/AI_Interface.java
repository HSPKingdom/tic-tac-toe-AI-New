package player;

import AI.AIBlock;
import AI.AIMain;
import core.Player;
import core.gameCore;
import game.insertItem;

public class AI_Interface extends Player{

    AIMain ai = new AIMain();

    public void setOpponentSymbol(char opponentSymbol)
    {
        ai.setUp(getSymbol(), opponentSymbol);
    }
    public insertItem setInput(final gameCore game)
    {
        insertItem AI_output = new insertItem();
        AIBlock result = ai.setNextMove(game);
        AI_output.setItem(result.getX(), result.getY(), getSymbol());
        return AI_output;
    }
}
