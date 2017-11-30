package AI;

import java.util.ArrayList;

public class AIGame {

    public AIBlock findLargestChanceOpponent(ArrayList<AIBlock> input)
    {
        AIBlock largest = input.get(0);
        for (AIBlock eachBlock : input)
        {
            if (eachBlock.getChance() > largest.getChance())
                largest = eachBlock;
        }
        System.out.println("HI"+largest.toString());
        return largest;
    }
}
