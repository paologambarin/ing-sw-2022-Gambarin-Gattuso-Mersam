package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.model.ColorTower;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCharacterCardMessage;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseCloudMessage;
import it.polimi.ingsw.network.Message.ClientToServer.MoveMotherNatureMessage;
import it.polimi.ingsw.network.Message.ClientToServer.MovePawnToIslandMessage;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import java.util.ArrayList;

import static java.lang.Integer.parseInt;

public class GameTableController {
    @FXML Button useCC;
    @FXML Button endTurn;
    @FXML Button number0;
    @FXML Button number1;
    @FXML Button number2;
    @FXML Button number3;
    @FXML Text whatToDo;//Testo bianco da poter cambiare
    @FXML BorderPane showSchool1;
    @FXML BorderPane showSchool2;
    @FXML BorderPane showSchool3;
    @FXML BorderPane showSchool0;
    @FXML BorderPane showAssistant;
    @FXML BorderPane showCharacterCard;
    @FXML Button CharacterCardButton;
    @FXML ChoiceBox<String> SchoolBoard;
    @FXML Button AssistantCardButton;
    @FXML Button diningButton;
    @FXML Button characterButton;
    @FXML Button islandButton;
    @FXML Pane messagesActions;
    @FXML Text textRed0;
    @FXML Text textBlue0;
    @FXML Text textYellow11;
    @FXML Text textGreen11;
    @FXML Text textBlue11;
    @FXML Text textRed11;
    @FXML Text textPink11;
    @FXML Text textPink10;
    @FXML Text textYellow10;
    @FXML Text textGreen10;
    @FXML Text textBlue10;
    @FXML Text textRed10;
    @FXML Text textPink9;
    @FXML Text textYellow9;
    @FXML Text textGreen9;
    @FXML Text textBlue9;
    @FXML Text textRed9;
    @FXML Text textPink8;
    @FXML Text textYellow8;
    @FXML Text textGreen8;
    @FXML Text textBlue8;
    @FXML Text textRed8;
    @FXML Text textYellow7;
    @FXML Text textGreen7;
    @FXML Text textBlue7;
    @FXML Text textPink7;
    @FXML Text textRed7;
    @FXML Text textYellow6;
    @FXML Text textPink6;
    @FXML Text textGreen6;
    @FXML Text textBlue6;
    @FXML Text textRed6;
    @FXML Text textYellow5;
    @FXML Text textGreen5;
    @FXML Text textBlue5;
    @FXML Text textRed5;
    @FXML Text textPink5;
    @FXML Text textYellow4;
    @FXML Text textPink4;
    @FXML Text textGreen4;
    @FXML Text textBlue4;
    @FXML Text textRed4;
    @FXML Text textPink3;
    @FXML Text textYellow3;
    @FXML Text textGreen3;
    @FXML Text textBlue3;
    @FXML Text textRed3;
    @FXML Text textPink2;
    @FXML Text textYellow2;
    @FXML Text textGreen2;
    @FXML Text textBlue2;
    @FXML Text textRed2;
    @FXML Text textPink1;
    @FXML Text textYellow1;
    @FXML Text textGreen1;
    @FXML Text textBlue1;
    @FXML Text textRed1;
    @FXML Text textPink0;
    @FXML Text textYellow0;
    @FXML Text textGreen0;
    Gui gui;
    @FXML
    Pane gameTable;


    @FXML Text turnOf;
    @FXML Text messages;
    FXMLLoader fxmlLoader;
    SchoolBoard0Controller schoolBoard0Controller;
    AssistantCardController assistantCardController;
    CharacterCardController characterCardController;
    SchoolBoard1Controller schoolBoard1Controller;
    SchoolBoard2Controller schoolBoard2Controller;
    SchoolBoard3Controller schoolBoard3Controller;
    public BorderPane getShowSchool0(){return showSchool0;}
    public BorderPane getShowSchool1(){return showSchool1;}
    public BorderPane getShowSchool2(){return showSchool2;}
    public BorderPane getShowSchool3(){return showSchool3;}

    public BorderPane getShowAssistant(){return showAssistant;}
    public BorderPane getShowCharacterCard(){return showCharacterCard;}
    public Pane getGameTablePane(){return gameTable;}

    public Text getWhatToDo(){return this.whatToDo;}

    public Button getUseCC(){return this.useCC;}
    public Button getEndTurn(){return this.endTurn;}

    public void setGui(Gui gui) {
        this.gui = gui;
    }
//SETCLOUDDISABLE SERVE DOPO CHE SCEGLIE E CHE INVII IL MESSAGGIO CON LA CLOUD SCELTA!
    //Setta l'ordine del turno in alto a sinistra
    public void setTurnOf(ArrayList<String> player) {
        int i;
        turnOf.setText("TURN ORDER:\n"+player.get(0)+"\n");
        for (i = 1; i < player.size(); i++)
            turnOf.setText(turnOf.getText()+player.get(i) + "\n");
    }
    public void setMessages(String messages) {
        this.messages.setText(messages);
    }

    public void setAllIslands(boolean disabled) {
        for (int i = 0; i < gui.getLightGame().getIslands().size(); i++) {
            String name = "#island" + i;
            gameTable.lookup(name).setVisible(true);
            gameTable.lookup(name).setDisable(disabled);
        }
    }

    public void setIslandForMotherNature(int steps){
        int mn, i=0;
        for(mn = 0; mn<gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(mn).getMotherNature(); mn++);
        setAllIslands(true);
        while(i<steps){
            mn++;
            if(mn == 12)
                mn = 0;
            gameTable.lookup("#island" + mn).setDisable(false);
            i++;
        }
        /*for(int j = mn; j<12-i; j++){
            mn++;
            if(mn==12)
                mn=0;
            gameTable.lookup("#island" + mn).setOpacity(0.5);
        }*/
        whatToDo.setText("Select new MN Island");
    }


    public void setButtonOff(){
        useCC.setDisable(true);
        useCC.setVisible(false);
        endTurn.setDisable(true);
        endTurn.setVisible(false);

        number0.setDisable(true);
        number0.setVisible(false);
        number1.setDisable(true);
        number1.setVisible(false);
        number2.setDisable(true);
        number2.setVisible(false);
        number3.setVisible(false);
        number3.setDisable(true);
        islandButton.setDisable(true);
        islandButton.setVisible(false);
        characterButton.setVisible(false);
        characterButton.setDisable(true);
        diningButton.setDisable(true);
        diningButton.setVisible(false);
        messagesActions.setVisible(false);
        messagesActions.setDisable(true);
    }
    public void setAssistantSchoolBoardCharacter(){
        AssistantCardButton.setDisable(false);
        AssistantCardButton.setVisible(true);
        CharacterCardButton.setVisible(true);
        CharacterCardButton.setDisable(false);
        SchoolBoard.setVisible(true);
        int i;
        for(i=0;i<gui.getLightGame().getPlayers().size();i++) {
            SchoolBoard.getItems().add("Board "+gui.getLightGame().getPlayers().get(i).getNickname());
            // if the item of the list is changed
            SchoolBoard.getSelectionModel().selectedIndexProperty().addListener((ov, value, new_value) -> {
                // set the SchoolBoard for the selected item
                if((int)new_value == 0){
                    schoolBoard0Controller= gui.getSchoolBoard0Controller();
                    schoolBoard0Controller.setSchoolBoard0();
                    showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
                    showSchool0.setVisible(true);
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 1){
                    schoolBoard1Controller= gui.getSchoolBoard1Controller();
                    schoolBoard1Controller.setSchoolBoard1();
                    showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(true);
                    showSchool2.setVisible(false);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 2){
                    schoolBoard2Controller= gui.getSchoolBoard2Controller();
                    schoolBoard2Controller.setSchoolBoard2();
                    showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(true);
                    showSchool3.setVisible(false);
                }
                else if((int)new_value == 3){
                    schoolBoard3Controller= gui.getSchoolBoard3Controller();
                    schoolBoard3Controller.setSchoolBoard3();
                    showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
                    showSchool3.setVisible(true);
                    showAssistant.setVisible(false);
                    showCharacterCard.setVisible(false);
                    showSchool0.setVisible(false);
                    showSchool1.setVisible(false);
                    showSchool2.setVisible(false);
                }

            });
        }
    }
    public void setChooseViewOff(){
        Platform.runLater(()->{
        SchoolBoard.setDisable(true);
        AssistantCardButton.setDisable(true);
        CharacterCardButton.setDisable(true);
    });
    }

    public void setChooseViewOn(){
        SchoolBoard.setDisable(false);
        AssistantCardButton.setDisable(false);
        CharacterCardButton.setDisable(false);
    }

    public void setButtonForRequestMovePawn(){
        Platform.runLater(()-> {
            whatToDo.setVisible(true);
            islandButton.setDisable(false);
            islandButton.setVisible(true);
            diningButton.setVisible(true);
            diningButton.setDisable(false);
            if (gui.getLightGame().getIsExpert()) {
                characterButton.setVisible(true);
                characterButton.setDisable(false);
                messagesActions.setVisible(true);
                messagesActions.setDisable(false);
            }
        });
    }
    public void setShowAssistant() {
        showSchool0.setVisible(false);
        showCharacterCard.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()-> {
            assistantCardController = gui.getAssistantCardController();
            assistantCardController.setAssistantCards(gui.getSocketNetworkHandler().getNicknameThisPlayer());
            assistantCardController.setAsssistantsAble(gui.getSocketNetworkHandler().getNicknameThisPlayer());
            showAssistant.setCenter(assistantCardController.getAssistantCards());
            showAssistant.setVisible(true);
        });
    }

    public void setPawnVisible() {
        int n;
        int i;
        int num;
        for (n = 0; n < gui.getLightGame().getIslands().size(); n++) {
            String str="#island"+ n;
            gameTable.lookup(str).setVisible(true);
            for (i = 0; i < 5; i++) {
                if (i == 0) {
                    str="#textGreen"+n;
                    gameTable.lookup(str).setVisible(true);
                    num = gui.getLightGame().getIslands().get(n).getGreenPawn();
                    switch (n) {
                        case 0 -> textGreen0.setText(String.valueOf(num));
                        case 1 -> textGreen1.setText(String.valueOf(num));
                        case 2 -> textGreen2.setText(String.valueOf(num));
                        case 3 -> textGreen3.setText(String.valueOf(num));
                        case 4 -> textGreen4.setText(String.valueOf(num));
                        case 5 -> textGreen5.setText(String.valueOf(num));
                        case 6 -> textGreen6.setText(String.valueOf(num));
                        case 7 -> textGreen7.setText(String.valueOf(num));
                        case 8 -> textGreen8.setText(String.valueOf(num));
                        case 9 -> textGreen9.setText(String.valueOf(num));
                        case 10 -> textGreen10.setText(String.valueOf(num));
                        case 11 -> textGreen11.setText(String.valueOf(num));
                    }
                } else if (i == 1) {
                    num = gui.getLightGame().getIslands().get(n).getRedPawn();
                    switch (n) {
                        case 0 -> textRed0.setText(String.valueOf(num));
                        case 1 -> textRed1.setText(String.valueOf(num));
                        case 2 -> textRed2.setText(String.valueOf(num));
                        case 3 -> textRed3.setText(String.valueOf(num));
                        case 4 -> textRed4.setText(String.valueOf(num));
                        case 5 -> textRed5.setText(String.valueOf(num));
                        case 6 -> textRed6.setText(String.valueOf(num));
                        case 7 -> textRed7.setText(String.valueOf(num));
                        case 8 -> textRed8.setText(String.valueOf(num));
                        case 9 -> textRed9.setText(String.valueOf(num));
                        case 10 -> textRed10.setText(String.valueOf(num));
                        case 11 -> textRed11.setText(String.valueOf(num));
                    }
                } else if (i == 2) {
                    num = gui.getLightGame().getIslands().get(n).getYellowPawn();
                    switch (n) {
                        case 0 -> textYellow0.setText(String.valueOf(num));
                        case 1 -> textYellow1.setText(String.valueOf(num));
                        case 2 -> textYellow2.setText(String.valueOf(num));
                        case 3 -> textYellow3.setText(String.valueOf(num));
                        case 4 -> textYellow4.setText(String.valueOf(num));
                        case 5 -> textYellow5.setText(String.valueOf(num));
                        case 6 -> textYellow6.setText(String.valueOf(num));
                        case 7 -> textYellow7.setText(String.valueOf(num));
                        case 8 -> textYellow8.setText(String.valueOf(num));
                        case 9 -> textYellow9.setText(String.valueOf(num));
                        case 10 -> textYellow10.setText(String.valueOf(num));
                        case 11 -> textYellow11.setText(String.valueOf(num));
                    }
                } else if (i == 3) {
                    num = gui.getLightGame().getIslands().get(n).getPinkPawn();
                    switch (n) {
                        case 0 -> textPink0.setText(String.valueOf(num));
                        case 1 -> textPink1.setText(String.valueOf(num));
                        case 2 -> textPink2.setText(String.valueOf(num));
                        case 3 -> textPink3.setText(String.valueOf(num));
                        case 4 -> textPink4.setText(String.valueOf(num));
                        case 5 -> textPink5.setText(String.valueOf(num));
                        case 6 -> textPink6.setText(String.valueOf(num));
                        case 7 -> textPink7.setText(String.valueOf(num));
                        case 8 -> textPink8.setText(String.valueOf(num));
                        case 9 -> textPink9.setText(String.valueOf(num));
                        case 10 -> textPink10.setText(String.valueOf(num));
                        case 11 -> textPink11.setText(String.valueOf(num));
                    }
                } else if (i == 4) {
                    num = gui.getLightGame().getIslands().get(n).getBluePawn();
                    switch (n) {
                        case 0 -> textBlue0.setText(String.valueOf(num));
                        case 1 -> textBlue1.setText(String.valueOf(num));
                        case 2 -> textBlue2.setText(String.valueOf(num));
                        case 3 -> textBlue3.setText(String.valueOf(num));
                        case 4 -> textBlue4.setText(String.valueOf(num));
                        case 5 -> textBlue5.setText(String.valueOf(num));
                        case 6 -> textBlue6.setText(String.valueOf(num));
                        case 7 -> textBlue7.setText(String.valueOf(num));
                        case 8 -> textBlue8.setText(String.valueOf(num));
                        case 9 -> textBlue9.setText(String.valueOf(num));
                        case 10 -> textBlue10.setText(String.valueOf(num));
                        case 11 -> textBlue11.setText(String.valueOf(num));
                    }
                }
            }
        }
    }
    public void setCloudVisible() {
        int n;
        int i;
        int k=0;
        if(gui.getLightGame().getPlayers().size()==3){
            gameTable.lookup("#cloud3").setVisible(false);
        }else if(gui.getLightGame().getPlayers().size()==2){
            gameTable.lookup("#cloud3").setVisible(false);
            gameTable.lookup("#cloud2").setVisible(false);
        }
        for (i = 0; i <4; i++) {
            int j;
            for(j=0;j<4;j++) {
                gameTable.lookup("#greenCloud" + i + j).setVisible(false);
                gameTable.lookup("#redCloud" + i + j).setVisible(false);
                gameTable.lookup("#yellowCloud" + i + j).setVisible(false);
                gameTable.lookup("#pinkCloud" + i + j).setVisible(false);
                gameTable.lookup("#blueCloud" + i + j).setVisible(false);
            }
        }
        for (i = 0; i < gui.getLightGame().getPlayers().size(); i++) {
            if ((gui.getLightGame().getClouds().get(i).getGreenPawn() + gui.getLightGame().getClouds().get(i).getPinkPawn() + gui.getLightGame().getClouds().get(i).getRedPawn() + gui.getLightGame().getClouds().get(i).getBluePawn() + gui.getLightGame().getClouds().get(i).getYellowPawn()) > 0) {
                k = 0;
                String name = "#cloud" + i;
                gameTable.lookup(name).setVisible(true);
                gameTable.lookup(name).setDisable(true);
                n = gui.getLightGame().getClouds().get(i).getGreenPawn();
                while (n > 0) {
                    gameTable.lookup("#greenCloud" + i + k).setVisible(true);
                    k++;
                    n--;
                }
                n = gui.getLightGame().getClouds().get(i).getRedPawn();
                while (n > 0) {
                    gameTable.lookup("#redCloud" + i + k).setVisible(true);
                    k++;
                    n--;
                }
                n = gui.getLightGame().getClouds().get(i).getYellowPawn();
                while (n > 0) {
                    gameTable.lookup("#yellowCloud" + i + k).setVisible(true);
                    k++;
                    n--;
                }
                n = gui.getLightGame().getClouds().get(i).getPinkPawn();
                while (n > 0) {
                    gameTable.lookup("#pinkCloud" + i + k).setVisible(true);
                    k++;
                    n--;
                }
                n = gui.getLightGame().getClouds().get(i).getBluePawn();
                while (n > 0) {
                    gameTable.lookup("#blueCloud" + i + k).setVisible(true);
                    k++;
                    n--;
                }
            }
        }
    }
    public void setCloudAble(){
        Platform.runLater(()-> {
            int i;
            for (i = 0; i < gui.getLightGame().getClouds().size(); i++) {
                if ((gui.getLightGame().getClouds().get(i).getGreenPawn() + gui.getLightGame().getClouds().get(i).getPinkPawn() + gui.getLightGame().getClouds().get(i).getRedPawn() + gui.getLightGame().getClouds().get(i).getBluePawn() + gui.getLightGame().getClouds().get(i).getYellowPawn()) > 0) {
                    gameTable.lookup("#cloud" + i).setDisable(false);
                }
            }
        });
    }
    public void setCloudDisable(){
        Platform.runLater(()->{
        int i;
        for(i=0;i<gui.getLightGame().getClouds().size();i++) {
            gameTable.lookup("#cloud" + i).setDisable(false);
        }
        });
    }
    public void setMotherNatureVisible() {
        int i;
        for (i = 0; i < gui.getLightGame().getIslands().size(); i++) {
            if (gui.getLightGame().getIslands().get(i).getMotherNature()) {
                gameTable.lookup("#motherNature" + i).setVisible(true);
            } else {
                gameTable.lookup("#motherNature" + i).setVisible(false);
            }
        }
    }
    public void setProhibited(){
        int i;
        for(i=0;i<gui.getLightGame().getIslands().size();i++){
            if(gui.getLightGame().getIslands().get(i).getProhibited()){
                gameTable.lookup("#prohibited"+ i).setVisible(true);
            }else{
                gameTable.lookup("#prohibited"+i).setVisible(false);
            }
        }
    }
    public void setTowers() {
        int i;
        String name=null;
        for (i = 0; i < gui.getLightGame().getIslands().size(); i++) {
            String text = "#textIsland" + String.valueOf(i);
            if (gui.getLightGame().getIslands().get(i).getTower()) {
                if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.BLACK) {
                    name = "#blackTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.WHITE) {
                    name = "#whiteTower" + String.valueOf(i);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
                } else if (gui.getLightGame().getIslands().get(i).getColorTower() == ColorTower.GREY) {
                    name = "#greyTower" + String.valueOf(i);
                    gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                    gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                }
                gameTable.lookup(name).setVisible(true);
            } else {
                gameTable.lookup("#whiteTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#blackTower" + String.valueOf(i)).setVisible(false);
                gameTable.lookup("#greyTower" + String.valueOf(i)).setVisible(false);
            }
            gameTable.lookup(text).setVisible(true);
        }
    }

    public void switchToAssistantCard() {
        showCharacterCard.setVisible(false);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()-> {
            assistantCardController = gui.getAssistantCardController();
            assistantCardController.setAssistantCards(gui.getSocketNetworkHandler().getNicknameThisPlayer());
            showAssistant.setCenter(assistantCardController.getAssistantCards());
            showAssistant.setVisible(true);
        });
    }
    public void switchToCharacterCard(MouseEvent mouseEvent) {
        showAssistant.setVisible(false);
        showSchool0.setVisible(false);
        showSchool1.setVisible(false);
        showSchool2.setVisible(false);
        showSchool3.setVisible(false);
        Platform.runLater(()-> {
            characterCardController=gui.getCharacterCardController();
            characterCardController.setCharacterCards();
            showCharacterCard.setCenter(characterCardController.getCharacterCards());
            showCharacterCard.setVisible(true);
        });
    }



    public void initializeBorderPane(){
        Platform.runLater(()->{
            assistantCardController=gui.getAssistantCardController();
            showAssistant.setCenter(assistantCardController.getAssistantCards());
            showAssistant.setVisible(false);
            characterCardController= gui.getCharacterCardController();
            showCharacterCard.setCenter(characterCardController.getCharacterCards());
            showCharacterCard.setVisible(false);
            schoolBoard0Controller= gui.getSchoolBoard0Controller();
            showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
            showSchool0.setVisible(false);
            schoolBoard1Controller=gui.getSchoolBoard1Controller();
            showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
            showSchool1.setVisible(false);
            if(gui.getLightGame().getNumPlayers()>2){
                schoolBoard2Controller= gui.getSchoolBoard2Controller();
                showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
                showSchool2.setVisible(false);
            }
            if(gui.getLightGame().getNumPlayers()>3){
                schoolBoard3Controller= gui.getSchoolBoard3Controller();
                showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
                showSchool3.setVisible(false);
            }
        });
    }

    public void cloud0select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud0").setDisable(true);

        gameTable.lookup("#cloud1").setDisable(true);
        gameTable.lookup("#cloud2").setDisable(true);
        gameTable.lookup("#cloud3").setDisable(true);

        for(int i = 0; i<4; i++) {
            gameTable.lookup("#greenCloud0"+i).setVisible(false);
            gameTable.lookup("#greenCloud0"+i).setDisable(true);
            gameTable.lookup("#redCloud0"+i).setVisible(false);
            gameTable.lookup("#redCloud0"+i).setDisable(true);
            gameTable.lookup("#yellowCloud0"+i).setVisible(false);
            gameTable.lookup("#yellowCloud0"+i).setDisable(true);
            gameTable.lookup("#pinkCloud0"+i).setVisible(false);
            gameTable.lookup("#pinkCloud0"+i).setDisable(true);
            gameTable.lookup("#blueCloud0"+i).setVisible(false);
            gameTable.lookup("#blueCloud0"+i).setDisable(true);
        }

        gui.getSocketNetworkHandler().sendMessage(new ChooseCloudMessage(0));
    }
    public void cloud1select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud1").setDisable(true);

        gameTable.lookup("#cloud0").setDisable(true);
        gameTable.lookup("#cloud2").setDisable(true);
        gameTable.lookup("#cloud3").setDisable(true);

        for(int i = 0; i<4; i++) {
            gameTable.lookup("#greenCloud1"+i).setVisible(false);
            gameTable.lookup("#greenCloud1"+i).setDisable(true);
            gameTable.lookup("#redCloud1"+i).setVisible(false);
            gameTable.lookup("#redCloud1"+i).setDisable(true);
            gameTable.lookup("#yellowCloud1"+i).setVisible(false);
            gameTable.lookup("#yellowCloud1"+i).setDisable(true);
            gameTable.lookup("#pinkCloud1"+i).setVisible(false);
            gameTable.lookup("#pinkCloud1"+i).setDisable(true);
            gameTable.lookup("#blueCloud1"+i).setVisible(false);
            gameTable.lookup("#blueCloud1"+i).setDisable(true);
        }

        gui.getSocketNetworkHandler().sendMessage(new ChooseCloudMessage(1));
    }
    public void cloud2select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud2").setDisable(true);

        gameTable.lookup("#cloud0").setDisable(true);
        gameTable.lookup("#cloud1").setDisable(true);
        gameTable.lookup("#cloud3").setDisable(true);

        for(int i = 0; i<4; i++) {
            gameTable.lookup("#greenCloud2"+i).setVisible(false);
            gameTable.lookup("#greenCloud2"+i).setDisable(true);
            gameTable.lookup("#redCloud2"+i).setVisible(false);
            gameTable.lookup("#redCloud2"+i).setDisable(true);
            gameTable.lookup("#yellowCloud2"+i).setVisible(false);
            gameTable.lookup("#yellowCloud2"+i).setDisable(true);
            gameTable.lookup("#pinkCloud2"+i).setVisible(false);
            gameTable.lookup("#pinkCloud2"+i).setDisable(true);
            gameTable.lookup("#blueCloud2"+i).setVisible(false);
            gameTable.lookup("#blueCloud2"+i).setDisable(true);
        }

        gui.getSocketNetworkHandler().sendMessage(new ChooseCloudMessage(2));
    }
    public void cloud3select(MouseEvent mouseEvent) {
        gameTable.lookup("#cloud3").setDisable(true);

        gameTable.lookup("#cloud0").setDisable(true);
        gameTable.lookup("#cloud2").setDisable(true);
        gameTable.lookup("#cloud1").setDisable(true);

        for(int i = 0; i<4; i++) {
            gameTable.lookup("#greenCloud3"+i).setVisible(false);
            gameTable.lookup("#greenCloud3"+i).setDisable(true);
            gameTable.lookup("#redCloud3"+i).setVisible(false);
            gameTable.lookup("#redCloud3"+i).setDisable(true);
            gameTable.lookup("#yellowCloud3"+i).setVisible(false);
            gameTable.lookup("#yellowCloud3"+i).setDisable(true);
            gameTable.lookup("#pinkCloud3"+i).setVisible(false);
            gameTable.lookup("#pinkCloud3"+i).setDisable(true);
            gameTable.lookup("#blueCloud3"+i).setVisible(false);
            gameTable.lookup("#blueCloud3"+i).setDisable(true);
        }

        gui.getSocketNetworkHandler().sendMessage(new ChooseCloudMessage(3));
    }

    public void setGreenProfessorTable(boolean bool){
        gameTable.lookup("#greenProf").setVisible(bool);
    }
    public void setRedProfessorTable(boolean bool){
        gameTable.lookup("#redProf").setVisible(bool);
    }
    public void setYellowProfessorTable(boolean bool){
        gameTable.lookup("#yellowProf").setVisible(bool);
    }
    public void setPinkProfessorTable(boolean bool){
        gameTable.lookup("#pinkProf").setVisible(bool);
    }
    public void setBlueProfessorTable(boolean bool){
        gameTable.lookup("#blueProf").setVisible(bool);
    }

    public void setProfessorTable(int numColor, boolean bool){
        if(numColor == 0)
            setGreenProfessorTable(bool);
        if(numColor == 1)
            setRedProfessorTable(bool);
        if(numColor == 2)
            setYellowProfessorTable(bool);
        if(numColor == 3)
            setPinkProfessorTable(bool);
        if(numColor == 4)
            setBlueProfessorTable(bool);

    }

    public void setProfessor(){
        int color;
        int prof = -1;
        for(color = 0; color< 5; color++){
            if(color==0) prof = gui.getLightGame().getProfTable().getGreenProf();
            else if(color==1) prof = gui.getLightGame().getProfTable().getRedProf();
            else if(color==2) prof = gui.getLightGame().getProfTable().getYellowProf();
            else if(color==3) prof = gui.getLightGame().getProfTable().getPinkProf();
            else if(color==4) prof = gui.getLightGame().getProfTable().getBlueProf();

            switch(prof){
                case -1 -> {
                    setProfessorTable(color, true);
                    gui.getSchoolBoard0Controller().setProfessor0(color, false);
                    gui.getSchoolBoard1Controller().setProfessor1(color, false);
                    if (schoolBoard2Controller!=null)  gui.getSchoolBoard2Controller().setProfessor2(color, false);
                    if (schoolBoard3Controller!=null) gui.getSchoolBoard3Controller().setProfessor3(color, false);

                }
                case 0 -> {
                    setProfessorTable(color, false);
                    gui.getSchoolBoard0Controller().setProfessor0(color,true);
                    gui.getSchoolBoard1Controller().setProfessor1(color, false);
                    if (schoolBoard2Controller!=null) gui.getSchoolBoard2Controller().setProfessor2(color,false);
                    if (schoolBoard3Controller!=null) gui.getSchoolBoard3Controller().setProfessor3(color, false);
                }
                case 1 -> {
                    setProfessorTable(color, false);
                    gui.getSchoolBoard0Controller().setProfessor0(color, false);
                    gui.getSchoolBoard1Controller().setProfessor1(color, true);
                    if (schoolBoard2Controller!=null) gui.getSchoolBoard2Controller().setProfessor2(color, false);
                    if (schoolBoard3Controller!=null) gui.getSchoolBoard3Controller().setProfessor3(color, false);
                }
                case 2 -> {
                    if (schoolBoard2Controller!=null) {
                        setProfessorTable(color, false);
                        gui.getSchoolBoard0Controller().setProfessor0(color, false);
                        gui.getSchoolBoard1Controller().setProfessor1(color, false);
                        if (schoolBoard2Controller!=null) gui.getSchoolBoard2Controller().setProfessor2(color, true);
                        if (schoolBoard3Controller!=null) gui.getSchoolBoard3Controller().setProfessor3(color,false);
                    }
                }
                case 3 -> {
                    if (schoolBoard3Controller!=null) {
                        setProfessorTable(color,false);
                        gui.getSchoolBoard0Controller().setProfessor0(color, false);
                        gui.getSchoolBoard1Controller().setProfessor1(color, false);
                        if (schoolBoard2Controller!=null) gui.getSchoolBoard2Controller().setProfessor2(color, false);
                        if (schoolBoard3Controller!=null) gui.getSchoolBoard3Controller().setProfessor3(color, true);
                    }
                }
            }
        }
    }

    public void number0Button(MouseEvent mouseEvent) {
        number0.setVisible(false);
        number0.setDisable(true);
        number1.setVisible(false);
        number1.setDisable(true);
        number2.setVisible(false);
        number2.setDisable(true);
        number3.setVisible(false);
        number3.setDisable(true);

        if(gui.getButtonClicked().equals(ButtonAction.ISLAND))
            whatToDo.setText("Choose Island Pawns");
        else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM))
            whatToDo.setText("Choose DiningRoom Pawns");

        gui.setNumPawns(parseInt(number0.getText()));
        gui.setNumPawnsCount(parseInt(number0.getText()));

        if(gui.getLightGame().getPlayers().get(0).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard0Controller = gui.getSchoolBoard0Controller();
            schoolBoard0Controller.setEntrance0Clickable();
            showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
            showSchool0.setVisible(true);

        }
        else if(gui.getLightGame().getPlayers().get(1).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard1Controller = gui.getSchoolBoard1Controller();
            schoolBoard1Controller.setEntrance1Clickable();
            showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
            showSchool1.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(2).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard2Controller = gui.getSchoolBoard2Controller();
            schoolBoard2Controller.setEntrance2Clickable();
            showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
            showSchool2.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(3).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard3Controller = gui.getSchoolBoard3Controller();
            schoolBoard3Controller.setEntrance3Clickable();
            showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
            showSchool3.setVisible(true);
        }
    }

    public void number1Button(MouseEvent mouseEvent) {
        number0.setVisible(false);
        number0.setDisable(true);
        number1.setVisible(false);
        number1.setDisable(true);
        number2.setVisible(false);
        number2.setDisable(true);
        number3.setVisible(false);
        number3.setDisable(true);

        if(gui.getButtonClicked().equals(ButtonAction.ISLAND))
            whatToDo.setText("Choose Island Pawns");
        else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM))
            whatToDo.setText("Choose DiningRoom Pawns");

        gui.setNumPawns(parseInt(number1.getText()));
        gui.setNumPawnsCount(parseInt(number1.getText()));

        if(gui.getLightGame().getPlayers().get(0).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard0Controller = gui.getSchoolBoard0Controller();
            schoolBoard0Controller.setEntrance0Clickable();
            showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
            showSchool0.setVisible(true);

        }
        else if(gui.getLightGame().getPlayers().get(1).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard1Controller = gui.getSchoolBoard1Controller();
            schoolBoard1Controller.setEntrance1Clickable();
            showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
            showSchool1.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(2).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard2Controller = gui.getSchoolBoard2Controller();
            schoolBoard2Controller.setEntrance2Clickable();
            showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
            showSchool2.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(3).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard3Controller = gui.getSchoolBoard3Controller();
            schoolBoard3Controller.setEntrance3Clickable();
            showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
            showSchool3.setVisible(true);
        }
    }

    public void number2Button(MouseEvent mouseEvent) {
        number0.setVisible(false);
        number0.setDisable(true);
        number1.setVisible(false);
        number1.setDisable(true);
        number2.setVisible(false);
        number2.setDisable(true);
        number3.setVisible(false);
        number3.setDisable(true);

        if(gui.getButtonClicked().equals(ButtonAction.ISLAND))
            whatToDo.setText("Choose Island Pawns");
        else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM))
            whatToDo.setText("Choose DiningRoom Pawns");

        gui.setNumPawns(parseInt(number2.getText()));
        gui.setNumPawnsCount(parseInt(number2.getText()));

        if(gui.getLightGame().getPlayers().get(0).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard0Controller = gui.getSchoolBoard0Controller();
            schoolBoard0Controller.setEntrance0Clickable();
            showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
            showSchool0.setVisible(true);

        }
        else if(gui.getLightGame().getPlayers().get(1).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard1Controller = gui.getSchoolBoard1Controller();
            schoolBoard1Controller.setEntrance1Clickable();
            showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
            showSchool1.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(2).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard2Controller = gui.getSchoolBoard2Controller();
            schoolBoard2Controller.setEntrance2Clickable();
            showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
            showSchool2.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(3).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard3Controller = gui.getSchoolBoard3Controller();
            schoolBoard3Controller.setEntrance3Clickable();
            showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
            showSchool3.setVisible(true);
        }
    }

    public void number3Button(MouseEvent mouseEvent) {
        number0.setVisible(false);
        number0.setDisable(true);
        number1.setVisible(false);
        number1.setDisable(true);
        number2.setVisible(false);
        number2.setDisable(true);
        number3.setVisible(false);
        number3.setDisable(true);

        if(gui.getButtonClicked().equals(ButtonAction.ISLAND))
            whatToDo.setText("Choose Island Pawns");
        else if(gui.getButtonClicked().equals(ButtonAction.DININGROOM))
            whatToDo.setText("Choose DiningRoom Pawns");

        gui.setNumPawns(parseInt(number3.getText()));
        gui.setNumPawnsCount(parseInt(number3.getText()));


        if(gui.getLightGame().getPlayers().get(0).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard0Controller = gui.getSchoolBoard0Controller();
            schoolBoard0Controller.setEntrance0Clickable();
            showSchool0.setCenter(schoolBoard0Controller.getSchoolBoard0());
            showSchool0.setVisible(true);

        }
        else if(gui.getLightGame().getPlayers().get(1).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard1Controller = gui.getSchoolBoard1Controller();
            schoolBoard1Controller.setEntrance1Clickable();
            showSchool1.setCenter(schoolBoard1Controller.getSchoolBoard1());
            showSchool1.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(2).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard2Controller = gui.getSchoolBoard2Controller();
            schoolBoard2Controller.setEntrance2Clickable();
            showSchool2.setCenter(schoolBoard2Controller.getSchoolBoard2());
            showSchool2.setVisible(true);
        }
        else if(gui.getLightGame().getPlayers().get(3).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer())){
            schoolBoard3Controller = gui.getSchoolBoard3Controller();
            schoolBoard3Controller.setEntrance3Clickable();
            showSchool3.setCenter(schoolBoard3Controller.getSchoolBoard3());
            showSchool3.setVisible(true);
        }
    }

    public void island0Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(0);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }
        else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(0).setMotherNature(true);
            int step = 0;
            while(i!=0){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island1Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(1);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(1).setMotherNature(true);
            int step = 0;
            while(i!=1){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island2Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(2);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(2).setMotherNature(true);
            int step = 0;
            while(i!=2){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island3Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(3);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(3).setMotherNature(true);
            int step = 0;
            while(i!=3){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island4Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(4);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(4).setMotherNature(true);
            int step = 0;
            while(i!=4){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island5Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(5);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(5).setMotherNature(true);
            int step = 0;
            while(i!=5){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island6Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(6);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(6).setMotherNature(true);
            int step = 0;
            while(i!=6){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island7Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(7);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(7).setMotherNature(true);
            int step = 0;
            while(i!=7){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island8Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(8);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(8).setMotherNature(true);
            int step = 0;
            while(i!=8){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island9Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(9);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(9).setMotherNature(true);
            int step = 0;
            while(i!=9){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island10Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(10);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(10).setMotherNature(true);
            int step = 0;
            while(i!=10){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }

    public void island11Select(MouseEvent mouseEvent) {
        if(gui.getButtonClicked().equals(ButtonAction.ISLAND)){
            gui.setIslandSelected(11);
            gui.getSocketNetworkHandler().sendMessage(new MovePawnToIslandMessage(gui.getIslandSelected(), gui.getNumPawns(), gui.getColorPawns()));
            gui.setPedineDaSpostare(gui.getPedineDaSpostare()- gui.getNumPawns());
        }else if(gui.getButtonClicked().equals(ButtonAction.MOTHERNATURE)){
            int i;
            for(i = 0; i < gui.getLightGame().getIslands().size() && !gui.getLightGame().getIslands().get(i).getMotherNature(); i++);
            gui.getLightGame().getIslands().get(i).setMotherNature(false);
            gui.getLightGame().getIslands().get(11).setMotherNature(true);
            int step = 0;
            while(i!=11){
                step++;
                i++;
                if(i==12)
                    i=0;
            }
            gui.getSocketNetworkHandler().sendMessage(new MoveMotherNatureMessage(step));
        }
    }


    public void islandButtonClicked(MouseEvent mouseEvent) {
        diningButton.setVisible(false);
        diningButton.setDisable(true);
        characterButton.setVisible(false);
        characterButton.setDisable(true);
        islandButton.setVisible(false);
        islandButton.setDisable(true);

        whatToDo.setText("Choose Pawns: ");

        gui.setButtonClicked(ButtonAction.ISLAND);

        for(int i = 0; i < gui.getPedineDaSpostare(); i++){
            if(i == 0){
                number0.setText("1");
                number0.setVisible(true);
                number0.setDisable(false);
            }
            else if(i == 1){
                number1.setText("2");
                number1.setVisible(true);
                number1.setDisable(false);
            }
            else if(i == 2){
                number2.setText("3");
                number2.setVisible(true);
                number2.setDisable(false);
            }
            else if(i == 3){
                number3.setText("4");
                number3.setVisible(true);
                number3.setDisable(false);
            }
        }

        whatToDo.setText("Choose Num to Island: ");
        whatToDo.setVisible(true);
    }

    public void characterButtonClicked(MouseEvent mouseEvent) {
    }

    public void diningButtonClicked(MouseEvent mouseEvent) {
        diningButton.setVisible(false);
        diningButton.setDisable(true);
        characterButton.setVisible(false);
        characterButton.setDisable(true);
        islandButton.setVisible(false);
        islandButton.setDisable(true);

        gui.setButtonClicked(ButtonAction.DININGROOM);

        for(int i = 0; i < gui.getPedineDaSpostare(); i++){
            if(i == 0){
                number0.setText("1");
                number0.setVisible(true);
                number0.setDisable(false);
            }
            else if(i == 1){
                number1.setText("2");
                number1.setVisible(true);
                number1.setDisable(false);
            }
            else if(i == 2){
                number2.setText("3");
                number2.setVisible(true);
                number2.setDisable(false);
            }
            else if(i == 3){
                number3.setText("4");
                number3.setVisible(true);
                number3.setDisable(false);
            }
        }

        whatToDo.setText("Choose Num to DiningRoom: ");
        whatToDo.setVisible(true);
    }

    public void useCCButton(MouseEvent mouseEvent) {
        setMessages("Choose CC");

        useCC.setVisible(false);
        useCC.setDisable(true);
        endTurn.setVisible(false);
        endTurn.setDisable(true);

        characterCardController.setDisable(0, false);
        characterCardController.setDisable(1, false);
        characterCardController.setDisable(2, false);
    }

    public void endTurnButton(MouseEvent mouseEvent) {
        ArrayList<ColorPawn>  color=new ArrayList<>();
        gui.getSocketNetworkHandler().sendMessage(new ChooseCharacterCardMessage(0,0,0,color,false));
    }

    public void setLastCCMessage(){
        Platform.runLater(()-> {
            messagesActions.setVisible(true);
            messagesActions.setDisable(false);
            messages.setText("LAST PHASE");
            whatToDo.setText("Do you want to:");
            whatToDo.setVisible(true);
            useCC.setVisible(true);
            useCC.setDisable(false);
            endTurn.setVisible(true);
            endTurn.setDisable(false);
        });
    }
}