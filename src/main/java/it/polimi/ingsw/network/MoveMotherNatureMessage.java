package it.polimi.ingsw.network;

public class MoveMotherNatureMessage extends ClientToServer{
    private final int island;

    public MoveMotherNatureMessage(int island) {
        this.island = island;
    }

    public int getIsland() {
        return island;
    }
}