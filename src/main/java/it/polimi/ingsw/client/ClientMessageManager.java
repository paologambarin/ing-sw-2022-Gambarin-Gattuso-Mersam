package it.polimi.ingsw.client;

import it.polimi.ingsw.network.Message.Ping;
import it.polimi.ingsw.network.Message.ServerToClient.*;
import it.polimi.ingsw.network.Message.UpdateMessage.AllUpdateMessage;
import it.polimi.ingsw.view.View;

import java.io.IOException;

public class ClientMessageManager {
    private final View view;

    public ClientMessageManager(View view) {
        this.view = view;
    }

    /**It contains all the type of message the Client can receive
     *
     * @param object the Message
     * @param socketNetworkHandler the Client
     * @throws InterruptedException
     * @throws IOException
     */
    public void manageInputToClient(Object object, SocketNetworkHandler socketNetworkHandler) throws InterruptedException, IOException {
        if (object instanceof WaitMessage) {
            socketNetworkHandler.getView().waitOtherPlayers();
        } else if (object instanceof SetNumPlayersIsExpertMessage) {
            socketNetworkHandler.getView().requestNumPlayersIsExpert();
        } else if (object instanceof SetNickMessage) {
            socketNetworkHandler.getView().requestNickname();
        } else if (object instanceof ClientAcceptedMessage) {
            socketNetworkHandler.getView().registerClient();
        } else if (object instanceof WinnerMessage message) {
            socketNetworkHandler.getView().displayWinner(message.getNickname());
        } else if (object instanceof GameStartedMessage) {
            socketNetworkHandler.getView().newGameStart();
        } else if (object instanceof WrongNicknameMessage) {
            socketNetworkHandler.getView().displayWrongNickname();
        } else if (object instanceof WrongTurnMessage) {
            socketNetworkHandler.getView().displayWrongTurn();
        } else if (object instanceof AllUpdateMessage m) {
            socketNetworkHandler.getView().updateAll(m.getLightGame());
        } else if (object instanceof LoginAcceptedMessage) {
            socketNetworkHandler.getView().playerWait();
        } else if (object instanceof SetAssistantMessage) {
            socketNetworkHandler.getView().selectAssistantCard(((SetAssistantMessage) object).getNickname());
        }else if(object instanceof SetMovePawnMessage) {
            socketNetworkHandler.getView().requestMovePawn(((SetMovePawnMessage) object).getNickname(),((SetMovePawnMessage) object).getNumPawnMoved());
        } else if (object instanceof SetMoveMotherNature) {
           socketNetworkHandler.getView().requestMoveMotherNature(((SetMoveMotherNature) object).getNickname());
        } else if (object instanceof SetCloudMessage) {
           socketNetworkHandler.getView().selectCloud(((SetCloudMessage) object).getNickname());
        } else if (object instanceof EndTurnMessage) {
           socketNetworkHandler.getView().startTurn(((EndTurnMessage) object).getPlayers(),((EndTurnMessage) object).getActualPlayer());
        }else if(object instanceof WrongNumPlayerIsExpertMessage){
             socketNetworkHandler.getView().displayWrongNickname();
        }else if(object instanceof WrongSameAssistantMessage){
           socketNetworkHandler.getView().wrongSameAssistantMessage();
        }else if(object instanceof WaitLoginMessage){
            socketNetworkHandler.getView().sendNick(((WaitLoginMessage) object).getNickname());
        }else if(object instanceof LobbyFullMessage){
            socketNetworkHandler.getView().lobbyFull();
        }else if(object instanceof Ping){
        }else if(object instanceof TurnOrderMessage){
            socketNetworkHandler.getView().turnOrder(((TurnOrderMessage) object).getPlayersOrder());
        }else if(object instanceof SetCharacterCardMessage){
            socketNetworkHandler.getView().requestCharacterCard(((SetCharacterCardMessage) object).getNickname(),((SetCharacterCardMessage) object).isBool());
        }else if(object instanceof UpdateIslandsMessage){
            socketNetworkHandler.getView().displayIslands();
        }else if(object instanceof UpdateDiningMessage){
            socketNetworkHandler.getView().displaySchoolBoard();
        }else if(object instanceof UpdateDiningOnePlayerMessage){
            socketNetworkHandler.getView().displayOnePlayerBoard(((UpdateDiningOnePlayerMessage) object).getNickname());
        }else if(object instanceof DisconnectionMessage){
            socketNetworkHandler.getView().disconnectionAll(((DisconnectionMessage) object).getPlayerDisconnected());
        }
        else throw new IllegalArgumentException();
    }
}