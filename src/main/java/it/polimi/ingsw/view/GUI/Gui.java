package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;


public class Gui extends Application implements View {


    @Override
    public void startGame() {

    }

    @Override
    public void requestNickname() {

    }

    @Override
    public void requestNumPlayersIsExpert() {

    }

    @Override
    public void requestMovePawnToDiningRoom(int pawn) {
    }

    @Override
    public void requestMovePawnToIsland(int pawn) {
    }

    @Override
    public void requestMovePawn(String nickname, int numPawnMoved) {

    }

    @Override
    public void requestMotherNatureMove(String nickname) {

    }

    @Override
    public void requestCloud(String nickname) {

    }

    @Override
    public void requestCharacterCard(String nickname, boolean bool) {

    }

    @Override
    public void displayNick() {

    }

    @Override
    public void displayNumPlayers() {

    }

    @Override
    public void displayIsExpert() {

    }

    @Override
    public void displayAssistantCard(int player) {

    }

    @Override
    public void displayCloud() {

    }

    @Override
    public void displayIslands() {

    }

    @Override
    public void displaySchoolBoard() {

    }

    @Override
    public void sendNick(String nickname) {

    }

    @Override
    public void displayCharacterCard() {

    }

    @Override
    public void displayWinner(String nickname) {

    }

    @Override
    public void displayNetError() {

    }

    @Override
    public void displayWrongNickname() {

    }

    @Override
    public void displayWrongTurn() {

    }

    @Override
    public void displayStartTurn() {

    }

    @Override
    public void displayEndRound() {

    }

    @Override
    public void displayResponseMessage() {

    }


    @Override
    public void updateAll(LightGame object) {

    }

    @Override
    public void displayAll() {

    }

    @Override
    public void selectCloud(String nickname) {

    }

    @Override
    public void selectAssistantCard(String nickname) {

    }

    @Override
    public void requestMoveMotherNature(String nickname) {

    }

    @Override
    public void registerClient() {

    }

    @Override
    public void waitOtherPlayers() {

    }

    @Override
    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {

    }

    @Override
    public void playerWait() {

    }

    @Override
    public void newGameStart() {

    }

    @Override
    public void lobbyFull() {

    }

    @Override
    public void turnOrder(ArrayList<String> players) {

    }

    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {

    }

    @Override
    public void displayDisconnection(String playerDisconnected) {

    }

    @Override
    public void displayOnePlayerBoard(String nickname) {

    }

    @Override
    public void start(Stage primaryStage) throws IOException {
        Parent root = FXMLLoader.load(
                getClass().getResource("FXML/NumOfPlayerIsExpert.fxml"));
        Scene sc = new Scene(root);
        primaryStage.setScene(sc);
        primaryStage.sizeToScene();
        primaryStage.show();
    }
}
