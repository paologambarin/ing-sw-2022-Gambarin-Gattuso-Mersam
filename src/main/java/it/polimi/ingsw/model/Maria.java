package it.polimi.ingsw.model;

import java.awt.*;
import java.util.ArrayList;

public class Maria extends UseEffect{
    private int coinPrice;
    Maria(){
        coinPrice=1;
    }
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int k;
        for(k=0; k<colorPawn.size(); k++)
            if(k<colorPawn.size()/2)
                player.diningRoom.removePawnFromDiningRoom(colorPawn.get(k), player, player.entrance);
            else
                player.diningRoom.addPawnToDiningRoom(colorPawn.get(k), player, player.entrance);
        coinPrice++;
    }


}
