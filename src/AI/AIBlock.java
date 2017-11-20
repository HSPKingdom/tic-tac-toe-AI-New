package AI;

public class AIBlock {
    private int x;
    private int y;
    private int chance;

    public AIBlock()
    {
        this.x = 0;
        this.y = 0;
        chance = -1;
    }
    public AIBlock(int x, int y, int chance)
    {
        this.x = x;
        this.y = y;
        this.chance = chance;
    }

    public int getX()
    {
        return x;
    }
    public int getY()
    {
        return y;
    }
    public int getChance()
    {
        return chance;
    }

    public void setAll(int x, int y, int chance)
    {
        this.x = x;
        this.y = y;
        this.chance = chance;
    }
}
