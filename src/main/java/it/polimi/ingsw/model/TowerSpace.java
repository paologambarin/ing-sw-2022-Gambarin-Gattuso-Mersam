package it.polimi.ingsw.model;

public class TowerSpace {
    protected ColorTower colorTower;
    private int numTower;

    //modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali
    public void setNumTowerIniziale(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numTower = 8;
        else if(Game.totPlayer == 3) numTower = 6;
    }

    public int getNumTower() {
        return numTower;
    }  // esiste qualche metodo che sposta le torri decrementandole da qui?
}