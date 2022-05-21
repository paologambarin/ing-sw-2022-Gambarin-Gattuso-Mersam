package it.polimi.ingsw.network.Message;

public class ChooseCloudMessage extends ClientToServer {
    private static final long serialVersionUID = -2263736350397053763L;
    private final int cloud;

    public ChooseCloudMessage(int cloud) {
        this.cloud = cloud;
    }

    public int getCloud() {
        return cloud;
    }
}
