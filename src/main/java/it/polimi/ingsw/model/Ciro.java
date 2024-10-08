package it.polimi.ingsw.model;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
/**
 * the third effect (Ciro because "C" is the third alphabet letter)
 * @see UseEffect
 */
public class Ciro extends UseEffect implements Serializable {
    @Serial
    private static final long serialVersionUID= -3300256130620262852L;
    private int coinPrice;
    Ciro(){
        coinPrice=3;
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }

    /**CharacterCard 3: choose an Island and calculate the influence (like mother nature was on that Island)
     * @param island to calculate the influence
     */
    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {//copia del metodo per calcolare la top influenza
        game.topInfluence(island,game);
         setCoinPrice(4);
    }
}