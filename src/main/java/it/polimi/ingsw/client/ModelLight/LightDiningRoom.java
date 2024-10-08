package it.polimi.ingsw.client.ModelLight;

import java.io.Serial;
import java.io.Serializable;

/**
 * LightCloud is the serialized class that contains the DiningRoom information to be sent to the client
 * @see it.polimi.ingsw.model.DiningRoom
 */
public class LightDiningRoom implements Serializable {
    @Serial
    private static final long serialVersionUID= -5630857078178651445L;
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

    public LightDiningRoom(int numBlue,int numGreen,int numPink,int numRed,int numYellow){
        this.numGreen =numGreen;
        this.numRed = numRed;
        this.numYellow =numYellow;
        this.numPink = numPink;
        this.numBlue = numBlue;
    }

    public int getNumBlue() {
        return numBlue;
    }

    public int getNumGreen() {
        return numGreen;
    }

    public int getNumPink() {
        return numPink;
    }

    public int getNumRed() {
        return numRed;
    }

    public int getNumYellow() {
        return numYellow;
    }
}
