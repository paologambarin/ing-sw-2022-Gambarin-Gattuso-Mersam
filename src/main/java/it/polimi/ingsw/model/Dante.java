package it.polimi.ingsw.model;
import java.io.Serializable;
import java.util.ArrayList;
public class Dante extends UseEffect implements Serializable {
    private int coinPrice;
    public Dante() {
        coinPrice = 1;
    }

    public void useEffect(Game game, int i, Island island, Player player, ArrayList<ColorPawn> colorPawn) {
        int step;
        step = player.getCurrentAssistant().getStep() + 2;
        player.getCurrentAssistant().setStep(step);
        setCoinPrice(2);
    }

    public void setCoinPrice(int coinPrice) {
        this.coinPrice = coinPrice;
    }
    public int getCoinPrice() {
        return coinPrice;
    }
}