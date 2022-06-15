package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
public class Maria extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= 2764414852422197504L;
    private int coinPrice;
    Maria(){
        coinPrice=1;
    }
    public void setCoinPrice(int coinPrice){this.coinPrice = coinPrice;}
    public int getCoinPrice(){return coinPrice;}

    /**CharacterCard 10: you can swap at most 2 students from your Entrance and your DiningRoom
     *
     * @param game
     * @param i
     * @param island
     * @param player
     * @param colorPawn
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn){
        int k;
        for(k=0; k<colorPawn.size(); k++)
            if(k<colorPawn.size()/2)
                player.diningRoom.addPawnToDiningRoom(colorPawn.get(k), player, game);
            else
                player.diningRoom.removePawnFromDiningRoomToEntrance(colorPawn.get(k), player, game);
        setCoinPrice(2);
    }


}
