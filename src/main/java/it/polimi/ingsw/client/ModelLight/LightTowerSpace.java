package it.polimi.ingsw.client.ModelLight;

import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.network.Message.UpdateMessage.TowerSpaceUpdateMessage;

public class LightTowerSpace {
    private ColorTower colorTower;
    private int numTower;


    public LightTowerSpace(ColorTower colorTower,int numTower) {
        this.colorTower=colorTower;
        this.numTower=numTower;
    }

    public ColorTower getColorTower() {
        return colorTower;
    }

    public int getNumTower() {
        return numTower;
    }

    public void update(TowerSpaceUpdateMessage message){
        this.colorTower = message.getTowerSpace().getColorTower();
        this.numTower = message.getTowerSpace().getNumTower();
    }
}
