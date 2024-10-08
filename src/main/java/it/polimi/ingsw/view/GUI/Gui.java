package it.polimi.ingsw.view.GUI;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
import it.polimi.ingsw.network.Message.ClientToServer.ReadyTodisconnection;
import it.polimi.ingsw.network.Message.ClientToServer.RequestNicknameAfterFirstLoginMessage;
import it.polimi.ingsw.view.GUI.Controller.*;
import it.polimi.ingsw.view.View;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Objects;

public class Gui extends Application implements View {


    private ButtonAction buttonClicked;
    private ArrayList<ColorPawn> colorPawns = new ArrayList<>();
    private int islandSelected = -1;
    private int numPawns = -1;
    private int numPawnsCount = -1;
    private int pedineDaSpostare;

    private LightGame lightGame;
    private Stage stage;
    private static String addressSock;
    private SocketNetworkHandler socketNetworkHandler;
    private GameTableController gameTable;
    private AssistantCardController assistantCardController;
    private CharacterCardController characterCardController;
    private RequestNickPlayersController requestNickPlayersController;
    private FXMLLoader fxmlLoader;

    private int numPawnMove;
    private boolean endGame=false;
    private SchoolBoard0Controller schoolBoard0Controller;
    private SchoolBoard1Controller schoolBoard1Controller;
    private SchoolBoard2Controller schoolBoard2Controller;
    private SchoolBoard3Controller schoolBoard3Controller;
    private WarningNicknameController warningNicknameController;
    private FXMLLoader fxmlSchool0;
    private FXMLLoader fxmlAssistant;
    private FXMLLoader fxmlCharacter;
    private FXMLLoader fxmlSchool1;
    private FXMLLoader fxmlSchool2;
    private FXMLLoader fxmlSchool3;
    private boolean var=false;

    public Gui() {
    }

    public void setVar(boolean var) {
        this.var = var;
    }
    public boolean getVar(){
        return this.var;
    }
    public ButtonAction getButtonClicked(){return this.buttonClicked;}
    public ArrayList<ColorPawn> getColorPawns(){return this.colorPawns;}
    public int getIslandSelected(){return this.islandSelected;}
    public int getNumPawns(){return this.numPawns;}
    public int getPedineDaSpostare(){return this.pedineDaSpostare;}

    public int getNumPawnMove() {
        return numPawnMove;
    }

    public int getNumPawnsCount() {return numPawnsCount;}

    public void setNumPawnsCount(int numPawnsCount) {this.numPawnsCount = numPawnsCount;}

    public void setButtonClicked(ButtonAction buttonClicked){this.buttonClicked = buttonClicked;}
    public void setColorPawns(ArrayList<ColorPawn> colorPawns){this.colorPawns = colorPawns;}
    public void setIslandSelected(int islandSelected){this.islandSelected = islandSelected;}
    public void setNumPawns(int numpawns){this.numPawns = numpawns;}
    public void setPedineDaSpostare(int pedineDaSpostare){this.pedineDaSpostare = pedineDaSpostare;}

    public AssistantCardController getAssistantCardController() {
        return assistantCardController;
    }

    public GameTableController getGameTable() {
        return gameTable;
    }
    public CharacterCardController getCharacterCardController() {
        return characterCardController;
    }
    public SchoolBoard0Controller getSchoolBoard0Controller() {
        return schoolBoard0Controller;
    }
    public SchoolBoard1Controller getSchoolBoard1Controller() {
        return schoolBoard1Controller;
    }
    public SchoolBoard2Controller getSchoolBoard2Controller() {
        return schoolBoard2Controller;
    }
    public SchoolBoard3Controller getSchoolBoard3Controller() {
        return schoolBoard3Controller;
    }
    public LightGame getLightGame(){return this.lightGame;}

    @Override
    public void start(Stage stage) throws Exception {
        this.stage=stage;
        startGame();
    }

    /**
     * is used to create and start socketNetworkHandler
     */
    @Override
    public void startGame() {
        socketNetworkHandler=new SocketNetworkHandler(this);
        socketNetworkHandler.updateConnection(addressSock, String.valueOf(4000));
        socketNetworkHandler.run();
    }

    public static void setAddress(String address){
        addressSock=address;
    }

    /**
     * set the nickname through RequestNickPlayersController
     * @see RequestNickPlayersController
     */
    @Override
    public void requestNickname() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/RequestNickPlayers.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            requestNickPlayersController = fxmlLoader.getController();
            requestNickPlayersController.setGui(this);
            requestNickPlayersController.setJoinButtonAble();
            stage.show();
        });
    }

    /**
     * Requests to the first player the number of players and if the game is expert
     * @see NumOfPlayerIsExpertController
     */
    @Override
    public void requestNumPlayersIsExpert() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/NumOfPlayerIsExpert.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            NumOfPlayerIsExpertController numOfPlayerIsExpertController=new NumOfPlayerIsExpertController();
            numOfPlayerIsExpertController=fxmlLoader.getController();
            numOfPlayerIsExpertController.setGui(this);
            numOfPlayerIsExpertController.setNumPlayerIsExpert();
            stage.show();
        });
    }
    public SocketNetworkHandler getSocketNetworkHandler() {
        return socketNetworkHandler;
    }
    /**
     * You have to choose if you want to move the pawn or to use a CharacterCard(in expert mode)
     */
    @Override
    public void requestMovePawn(String nickname, int numPawnMoved) {
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())) {
                schoolBoard1Controller.setSchoolBoard1();
                schoolBoard0Controller.setSchoolBoard0();
                if(schoolBoard2Controller!=null)
                    schoolBoard2Controller.setSchoolBoard2();
                if(schoolBoard3Controller!=null)
                    schoolBoard3Controller.setSchoolBoard3();
                gameTable.setMessages("CHOOSE YOUR ACTION");
                gameTable.setButtonForRequestMovePawn();
            }else{
                gameTable.setMessages(nickname+" IS IN MOVE PAWN PHASE");
            }
        });
    }
    /**
     * Check which CharacterCard a player has decided to use
     */
    @Override
    public void requestCharacterCard(String nickname, boolean bool) {
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())) {
                if(lightGame.getIsExpert()&&!var) {
                    gameTable.setLastCCMessage();
                }else{
                    gameTable.getMessagesActions().setVisible(false);
                    gameTable.getMessagesActions().setDisable(true);
                    ArrayList<ColorPawn> colorPawns=null;
                    socketNetworkHandler.sendMessage(new ChooseCharacterCardMessage(0,0,0,colorPawns,false));
                }
            }else{
                gameTable.setMessages(nickname+" IS IN CHOOSING PHASE");
            }
        });
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
        if(nickname !=null){
            socketNetworkHandler.sendMessage(new RequestNicknameAfterFirstLoginMessage(nickname));
        }
    }

    @Override
    public void displayCharacterCard() {
    }
    /**
     * display when player win
     * @see ReadyTodisconnection
     * @see WinnerSceneController
     */
    @Override
    public void displayWinner(String nickname) throws IOException {
        int i;
        int j;
        for (i = 0; !Objects.equals(lightGame.getPlayers().get(i).getNickname(), nickname); i++) ;
        if (lightGame.getPlayers().size() == 4) {
            for (j = (i+1); lightGame.getPlayers().get(i).getTowerSpace().getColorTower() != lightGame.getPlayers().get(j).getTowerSpace().getColorTower(); j++);
            nickname=lightGame.getPlayers().get(i).getNickname()+" and "+lightGame.getPlayers().get(j).getNickname();
        }
        String finalNickname = nickname;
        Platform.runLater(() -> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/WinnerScene.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            WinnerSceneController winnerScene = fxmlLoader.getController();
            winnerScene.setGui(this);
            winnerScene.setNicknameWinner(finalNickname);
            winnerScene.setWinnerScene(true);
            stage.show();
        });
        socketNetworkHandler.getOut().reset();
        socketNetworkHandler.getOut().flush();
        socketNetworkHandler.sendMessage(new ReadyTodisconnection());
        socketNetworkHandler.closeConnection();
    }

    @Override
    public void displayNetError() {
        Platform.runLater(()->{
            gameTable.setMessages("NET ERROR");
        });
    }

    @Override
    public void displayWrongNickname() {
        Platform.runLater(() -> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/WarningNickname.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            warningNicknameController= fxmlLoader.getController();
            warningNicknameController.setGui(this);
            warningNicknameController.setOkButton();
            warningNicknameController.setWarningNickname(true);
            stage.setScene(scene);
            stage.show();
        });
    }

    @Override
    public void displayWrongTurn() {
        Platform.runLater(()-> {
            gameTable.setMessages("IT'S NOT YOUT TURN");
        });
    }

    /**
     * is used to update the lightGame and the controllers
     * @param object lightGame
     */
    @Override
    public void updateAll(LightGame object) {
        this.lightGame=object;
        int i;
        int c=0;
        for(i=0;i<lightGame.getNumPlayers();i++){
            c++;
        }
        if(numPawnMove!=0){
            if(c==0){
                displayStartRound();
            }
        }
        if(assistantCardController!=null) {
            Platform.runLater(() -> {
                if (schoolBoard1Controller != null) {
                    schoolBoard1Controller.setSchoolBoard1();
                    schoolBoard0Controller.setSchoolBoard0();
                }
                if (schoolBoard2Controller != null) {
                    schoolBoard2Controller.setSchoolBoard2();
                }
                if (schoolBoard3Controller != null) {
                    schoolBoard3Controller.setSchoolBoard3();
                }
                assistantCardController.setAssistantCards(socketNetworkHandler.getNicknameThisPlayer());
                if (lightGame.getIsExpert()) characterCardController.setCharacterCards();
                gameTable.setMotherNatureVisible();
                gameTable.setPawnVisible();
                gameTable.setTowers();
                gameTable.setAllIslands(true);
                gameTable.setProfessor();
                gameTable.setCloudVisible();
                gameTable.setChooseViewOn();
            });
        }
    }
    @Override
    public void displayStartRound() {
    }

    /**
     *function to set button: cloud or CharacterCard
     */
    @Override
    public void selectCloud(String nickname) {
        Platform.runLater(()->{
            if(Objects.equals(nickname, socketNetworkHandler.getNicknameThisPlayer())) {
                if(lightGame.getIsExpert()&& !var) {
                    gameTable.setButtonOff();
                    gameTable.getMessagesActions().setDisable(false);
                    gameTable.getMessagesActions().setVisible(true);
                    gameTable.getCloudButton().setVisible(true);
                    gameTable.getCloudButton().setDisable(false);
                    gameTable.getUseCC().setDisable(false);
                    gameTable.getUseCC().setVisible(true);
                }else {
                    gameTable.CloudButton();
                }
            }else{
                gameTable.setMessages(nickname+" CHOOSE CLOUD");
            }
        });
    }
    /**
     *function for choose an Assistant
     */
    @Override
    public void selectAssistantCard(String nickname) {
        Platform.runLater(()-> {
            if(Objects.equals(nickname,socketNetworkHandler.getNicknameThisPlayer())){
                gameTable.setChooseViewOff();
                gameTable.setShowAssistant();
                gameTable.setMessages("CHOOSE AN ASSISTANT");

            }else{
                gameTable.setMessages(nickname+" IS CHOOSING AN ASSISTANT");
            }
        });
    }

    /**
     * function for set the button: useCC moveMotherNature
     */
    @Override
    public void requestMoveMotherNature(String nickname) {
        Platform.runLater(()->{
            if(Objects.equals(socketNetworkHandler.getNicknameThisPlayer(), nickname)){
                if(lightGame.getIsExpert()&&!var) {
                    gameTable.getUseCC().setDisable(false);
                    gameTable.getMoveMnButton().setDisable(false);
                    gameTable.getUseCC().setVisible(true);
                    gameTable.getMoveMnButton().setVisible(true);
                    gameTable.getMessagesActions().setVisible(true);
                    gameTable.getMessagesActions().setDisable(false);
                }else {
                    gameTable.moveMnButton();
                }
            }else{
                gameTable.setMessages(nickname + " IS IN MOVE MOTHER NATURE PHASE");
            }
        });
    }

    @Override
    public void registerClient() {

    }
    public void assistantSelected(){
        Platform.runLater(()-> {
            assistantCardController.setDisableAll();
            gameTable.initializeBorderPane();
            gameTable.setChooseViewOn();
        });
    }

    /**
     * Function to display the WaitingPlayersController
     * @see WaitingPlayersController
     */
    @Override
    public void waitOtherPlayers() {
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/WaitingPlayers.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            WaitingPlayersController waitingPlayersController=fxmlLoader.getController();
            waitingPlayersController.setGui(this);
            waitingPlayersController.setWaitingPlayers(true);
            requestNickPlayersController.setJoinButtonAble();
            stage.show();

        });


    }

    @Override
    public void setSocketNetworkHandler(SocketNetworkHandler socketNetworkHandler) {
        this.socketNetworkHandler=socketNetworkHandler;
    }

    @Override
    //va bene vuota
    public void playerWait() {

    }

    @Override
    public void stop(){
        try {
            System.exit(0);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public void closeAll(){
        try {
            socketNetworkHandler.getOut().reset();
            socketNetworkHandler.getOut().flush();
            socketNetworkHandler.sendMessage(new ReadyTodisconnection());
            System.out.println("c'è stata una disconnessione improvvisa. La lobby è stata chiusa");
            socketNetworkHandler.closeConnection();
            Platform.exit();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    /**
     * Initialize the pawns, inform all that the game started and initialize controllers
     * @see SchoolBoard3Controller
     * @see SchoolBoard2Controller
     * @see SchoolBoard1Controller
     * @see SchoolBoard0Controller
     * @see GameStartedController
     * @see CharacterCardController
     * @see AssistantCardController
     */
    @Override
    public void newGameStart() {
        if (lightGame.getNumPlayers() == 2 || lightGame.getNumPlayers() == 4) {
            pedineDaSpostare = 3;
            numPawnMove = 3;
        } else {
            pedineDaSpostare = 4;
            numPawnMove = 4;

        }
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GameStarted.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            GameStartedController gameStartedController=fxmlLoader.getController();
            gameStartedController.setGui(this);
            gameStartedController.setGameText(true);
            stage.show();
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/GameTable.fxml"));;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            gameTable=fxmlLoader.getController();
            gameTable.setGui(this);
            gameTable.setPawnVisible();
            gameTable.setMotherNatureVisible();
            gameTable.setAllIslands(false);
            gameTable.setCloudVisible();
            gameTable.setTowers();
            gameTable.setButtonOff();
            gameTable.setProhibited();
            gameTable.setAssistantSchoolBoardCharacter();
            gameTable.initializeBorderPane();
            stage.setScene(scene);
            stage.show();
        });

        Platform.runLater(()-> {
            fxmlSchool0= new FXMLLoader();
            fxmlSchool0.setLocation(getClass().getResource("/SchoolBoard0.fxml"));
            try {
                fxmlSchool0.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            schoolBoard0Controller=fxmlSchool0.getController();
            schoolBoard0Controller.setGui(this);
            schoolBoard0Controller.setSchoolBoard0();
            fxmlSchool1= new FXMLLoader();
            fxmlSchool1.setLocation(getClass().getResource("/SchoolBoard1.fxml"));
            try {
                fxmlSchool1.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            schoolBoard1Controller=fxmlSchool1.getController();
            schoolBoard1Controller.setGui(this);
            schoolBoard1Controller.setSchoolBoard1();
            if(lightGame.getNumPlayers()>2) {
                fxmlSchool2 = new FXMLLoader();
                fxmlSchool2.setLocation(getClass().getResource("/SchoolBoard2.fxml"));
                try {
                    fxmlSchool2.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                schoolBoard2Controller = fxmlSchool2.getController();
                schoolBoard2Controller.setGui(this);
                schoolBoard2Controller.setSchoolBoard2();
            }
            if(lightGame.getNumPlayers()>3) {
                fxmlSchool3 = new FXMLLoader();
                fxmlSchool3.setLocation(getClass().getResource("/SchoolBoard3.fxml"));
                try {
                    fxmlSchool3.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                schoolBoard3Controller = fxmlSchool3.getController();
                schoolBoard3Controller.setGui(this);
                schoolBoard3Controller.setSchoolBoard3();
            }
            fxmlAssistant= new FXMLLoader();
            fxmlAssistant.setLocation(getClass().getResource("/AssistantCard.fxml"));
            try {
                fxmlAssistant.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            assistantCardController = fxmlAssistant.getController();
            assistantCardController.setGui(this);
            assistantCardController.setAssistantCards(this.getSocketNetworkHandler().getNicknameThisPlayer());
            gameTable.getShowAssistant().setCenter(assistantCardController.getAssistantCards());
            gameTable.getShowAssistant().getCenter().setVisible(true);
            gameTable.getShowSchool0().setCenter(schoolBoard0Controller.getSchoolBoard0());
            gameTable.getShowSchool0().getCenter().setVisible(true);
            if(lightGame.getIsExpert()) {
                fxmlCharacter = new FXMLLoader();
                fxmlCharacter.setLocation(getClass().getResource("/CharacterCard.fxml"));
                try {
                    fxmlCharacter.load();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                if (lightGame.getIsExpert()) {
                    characterCardController = fxmlCharacter.getController();
                    characterCardController.setGui(this);
                    characterCardController.setCharacterCards();
                    gameTable.getShowCharacterCard().setCenter(characterCardController.getCharacterCards());
                    gameTable.getShowCharacterCard().getCenter().setVisible(true);
                }
            }
        });

    }

    /**If someone try to join but the lobby is full
     *
     */
    @Override
    public void lobbyFull(){
        Platform.runLater(()-> {
            fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("/LobbyIsFull.fxml"));
            Scene scene;
            try {
                scene = new Scene(fxmlLoader.load());
            } catch (IOException e) {
                e.printStackTrace();
                scene = new Scene(new Label("Error"));
            }
            stage.setScene(scene);
            stage.show();
        });
        socketNetworkHandler.closeConnection();
    }

    public Stage getStage() {
        return stage;
    }

    /**Show the order of that turn
     *
     * @param players
     */
    @Override
    public void turnOrder(ArrayList<String> players) {
        Platform.runLater(()-> {
            gameTable.setTurnOf(players);
        });
        var=false;
    }

    /**Show the current player that it's his turn
     *
     * @param players
     * @param actualPlayer
     */
    @Override
    public void startTurn(ArrayList<String> players, String actualPlayer) {
        Platform.runLater(()->{
            if (Objects.equals(actualPlayer, socketNetworkHandler.getNicknameThisPlayer())) {
                gameTable.setMessages("YOUR TURN IS FINISHED");
            }
            int i;
            int j;
            for (j = 0; !Objects.equals(players.get(j), actualPlayer); j++) ;
            if (j< players.size()-1) {
                for (i = j; Objects.equals(players.get(i), actualPlayer); i++) ;
                if (Objects.equals(players.get(i), socketNetworkHandler.getNicknameThisPlayer())) {
                    gameTable.setMessages("IT'S YOUR TURN");
                } else {
                    gameTable.setMessages(players.get(i) + " START YOUR TURN");
                }
            }else {
                gameTable.setMessages("ROUND FINISHED, A NEW ONE BEGINS");
            }
        });
    }
    @Override
    public void displayOnePlayerBoard(String nickname) {
    }


    @Override
    public void disconnectionAll(String playerDisconnected) throws IOException {
        if(!endGame){
            gameTable.setMessages(playerDisconnected+ " DISCONNECTED FROM THE GAME.");
        }
        closeAll();
    }


    @Override
    public void wrongSameAssistantMessage() {
        gameTable.setMessages("ASSISTANTCARD ALREADY SELECTED BY ANOTHER PLAYER");
        selectAssistantCard(socketNetworkHandler.getNicknameThisPlayer());
    }
}
