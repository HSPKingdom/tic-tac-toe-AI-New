package AI;

public class AIGame {

    private AIBlock[] opponentChance;

    public void updateOpponentChance(AIBlock opponentChance[])
    {
        this.opponentChance = opponentChance;
    }

    public AIBlock findLargestChanceOpponent()
    {
        AIBlock largest = opponentChance[0];
        for (AIBlock eachBlock : opponentChance)
        {
            if (eachBlock.getChance() > largest.getChance())
                largest = eachBlock;
        }
        return largest;
    }
}
