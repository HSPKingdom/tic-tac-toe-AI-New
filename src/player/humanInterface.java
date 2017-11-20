package player;

import core.Player;
import core.gameCore;
import game.insertItem;

import java.util.Scanner;

public class humanInterface extends Player {
    public insertItem setInput(final gameCore game)
    {
        int x = 0 ,y = 0;
        boolean checkBox = false;
        Scanner scanner = new Scanner(System.in);

        while( checkBox == false ) {
            System.out.println("Player " + getSymbol() + ":");
            System.out.println("Please Enter X-axis:");
            x = scanner.nextInt();
            System.out.println("Please Enter Y-axis");
            y = scanner.nextInt();

            if(!(x>0 && x<4) || !(y>0 && y<4))
            {
                System.out.println("Wrong X-axis and Y-axis");
            }
            else if (game.checkBoxEmpty(x,y) == false)
            {
                System.out.println("The Place is occupied!");
            }
            else {
                checkBox = true;
                setItem(x, y);
            }
        }
        return getItem();
    }
    public void setOpponentSymbol(char opponentSymbol)
    {

    }

}
