package it.polimi.ingsw.network.Message.ClientToServer;


import it.polimi.ingsw.model.ColorPawn;

import java.io.Serial;
import java.util.ArrayList;

public class MovePawnToDiningMessage extends ClientToServer {
    @Serial
    private static final long serialVersionUID = -2605058722239890514L;
    public final int num;
    public final ArrayList<ColorPawn> arrayPawn;

    public MovePawnToDiningMessage(int num, ArrayList<ColorPawn> arrayPawn) {
        this.num = num;
        this.arrayPawn=arrayPawn;
    }
    public int getNumPawn() {
        return num;
    }
    public ArrayList<ColorPawn> getArrayPawn(){
        return this.arrayPawn;
    }
}
