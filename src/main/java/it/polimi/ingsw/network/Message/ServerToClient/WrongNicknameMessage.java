package it.polimi.ingsw.network.Message.ServerToClient;

import java.io.Serial;
import java.io.Serializable;

/**
 * Message sent by the server to client when the nickname is wrong
 */
public class WrongNicknameMessage extends ServerToClient implements Serializable {
    @Serial
    private static final long serialVersionUID = 2478035688175931596L;
}
