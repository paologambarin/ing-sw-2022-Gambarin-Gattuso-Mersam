package it.polimi.ingsw.model;

import it.polimi.ingsw.model.ColorPawn;

public class Entrance {

    protected int numPawn;
    private int greenPawn;
    private int bluePawn;
    private int pinkPawn;
    private int yellowPawn;
    private int redPawn;

    //in Game-start bisogna aggiungere un metodo che mette in Entrance le pedine studenti in base al numero di Player

    //modifiche all'UML:ho aggiunto setter per definire quante sono le torri iniziali, final perché si setta all'inizio
    public final void setNumPawn(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4) numPawn = 9;
        else if(Game.totPlayer == 3) numPawn = 7;
    }

    //modifiche all'UML: il ritorno di check è boolean
    public boolean checkNum(){
        if(Game.totPlayer == 2 || Game.totPlayer == 4 && numPawn > 4)
            return true;
        else if(Game.totPlayer = 3 && numPawn > 5)
            return true;
        else return false;
    }

    public void moveToDining(){


    }

    public void moveToIsland(){

    }

    public void chooseCloud(){

    }
}
