package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the client has to choose a Cloud
 */
public class SetCloudMessage extends ServerToClient implements Serializable {
    @Serial
    private final static long serialVersionUID= 5641881049533251384L;
    private String nickname;
    public SetCloudMessage(String nickname){
        this.nickname=nickname;
    }

    public String getNickname() {
        return nickname;
    }
}
