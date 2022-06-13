package it.polimi.ingsw.view.GUI;


import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.client.SocketNetworkHandler;
import it.polimi.ingsw.network.Message.ClientToServer.ChooseAssistantCardMessage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Cursor;
import javafx.scene.layout.Pane;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class GameTable {
    private Pane rootFXML;
    private SocketNetworkHandler socketNetworkHandler;
    private LightGame lightGame;

    private final List<ImageView> islands = null;
    private final List<ImageView> motherNature = null;
    private final List<ImageView> greenPawns = null;
    private final List<ImageView> redPawns = null;
    private final List<ImageView> yellowPawns = null;
    private final List<ImageView> pinkPawns = null;
    private final List<ImageView> bluePawns= null;
    private final List<Text> textGreen = null;
    private final List<Text> textRed = null;
    private final List<Text> textYellow = null;
    private final List<Text> textPink = null;
    private final List<Text> textBlue= null;

    private final List<ImageView> blackTowers = null;
    private final List<ImageView> whiteTowers = null;
    private final List<ImageView> greyTowers = null;

    private final List<ImageView> clouds = null;
    private final List<ImageView> greenPawnClouds = null;
    private final List<ImageView> redPawnClouds = null;
    private final List<ImageView> yellowPawnClouds = null;
    private final List<ImageView> pinkPawnClouds = null;
    private final List<ImageView> bluePawnClouds = null;



    public GameTable(){
        try{
            rootFXML = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/FXML/GameTable.fxml")));
        }catch(IOException e){
        e.printStackTrace();
        }

        List<ImageView> buttonAssistants = new ArrayList<>();
        for(int i = 1; i < 11; i++){
            buttonAssistants.add((ImageView) rootFXML.lookup("AssistantCard" + i));
        }
        //quando il cursore arriva su un assistant card diventa a forma di mano
        for(ImageView imageAssistant : buttonAssistants){
            imageAssistant.setOnMouseEntered(mouseEvent -> imageAssistant.setCursor(Cursor.HAND));
            imageAssistant.setOnMouseExited(mouseEvent -> imageAssistant.setCursor(Cursor.DEFAULT));
        }

        //questo devo vedere se metterlo in una funzione e poi richiamarlo dalla GUI
        //o se mettere direttamente nella gui
        boolean alreadySelected = false;
        for(ImageView imageAssistant : buttonAssistants){
            if(!alreadySelected){
                imageAssistant.setOnMouseClicked(mouseEvent -> {
                    int AssistantCard = buttonAssistants.indexOf(imageAssistant);
                    socketNetworkHandler.sendMessage(new ChooseAssistantCardMessage(AssistantCard));
                });
                alreadySelected = true;
            }
        }


        for(int i = 0; i < 12; i++){
            islands.add((ImageView) rootFXML.lookup("island" + i));
            motherNature.add((ImageView) rootFXML.lookup("motherNature" + i));
            //Aggiunge le immagini delle pedine alle liste del colore corrispondenete
            greenPawns.add((ImageView) rootFXML.lookup("green" + i));
            redPawns.add((ImageView) rootFXML.lookup("red" + i));
            yellowPawns.add((ImageView) rootFXML.lookup("yellow" + i));
            pinkPawns.add((ImageView) rootFXML.lookup("pink" + i));
            bluePawns.add((ImageView) rootFXML.lookup("blue" + i));
            //aggiunge le torri del colore corrispondente
            blackTowers.add((ImageView) rootFXML.lookup("blackTower" + i));
            whiteTowers.add((ImageView) rootFXML.lookup("whiteTower" + i));
            greyTowers.add((ImageView) rootFXML.lookup("greyTowers" + i));

            textGreen.add((Text) rootFXML.lookup("textGreen" + i));
            textRed.add((Text) rootFXML.lookup("textRed" + i));
            textYellow.add((Text) rootFXML.lookup("textYellow" + i));
            textPink.add((Text) rootFXML.lookup("textPink" + i));
            textBlue.add((Text) rootFXML.lookup("textBlue" + i));
        }

        //setta tutte le pedine e madre natura invisibili all'inizio
        for(ImageView greenPawn : greenPawns)
            greenPawn.setVisible(false);
        for(ImageView redPawn : redPawns)
            redPawn.setVisible(false);
        for(ImageView yellowPawn : yellowPawns)
            yellowPawn.setVisible(false);
        for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);
        for(ImageView pinkPawn : pinkPawns)
            pinkPawn.setVisible(false);

        for(ImageView mNature : motherNature)
            mNature.setVisible(false);
        //setta le torri non visibili
        for(ImageView blackTower : blackTowers)
            blackTower.setVisible(false);
        for(ImageView whiteTower : whiteTowers)
            whiteTower.setVisible(false);
        for(ImageView greyTower : greyTowers)
            greyTower.setVisible(false);

        //setta il testo delle pedine non visibili
        for(Text greenText : textGreen)
            greenText.setVisible(false);
        for(Text redText : textRed)
            redText.setVisible(false);
        for(Text yellowText : textYellow)
            yellowText.setVisible(false);
        for(Text pinkText : textPink)
            pinkText.setVisible(false);
        for(Text blueText : textBlue)
            blueText.setVisible(false);

        for(int i = 0; i < 4; i++){
            clouds.add((ImageView) rootFXML.lookup("cloud" + i));
            clouds.get(i).setVisible(false);
        }
        for(int i = 0; i < lightGame.getNumPlayers(); i++)
            clouds.get(i).setVisible(true);

        for(int i = 0; i < 4; i++){
            for(int j = 0; j < 3; j++){
                greenPawnClouds.add((ImageView) rootFXML.lookup("greenCloud" + i + j));
                redPawnClouds.add((ImageView) rootFXML.lookup("redCloud" + i + j));
                yellowPawnClouds.add((ImageView) rootFXML.lookup("yellowCloud" + i + j));
                pinkPawnClouds.add((ImageView) rootFXML.lookup("pinkCloud" + i + j));
                bluePawnClouds.add((ImageView) rootFXML.lookup("blueCloud" + i + j));
            }
        }
        for(int i = 0; i < 12; i++){
            greenPawnClouds.get(i).setVisible(false);
            redPawnClouds.get(i).setVisible(false);
            yellowPawnClouds.get(i).setVisible(false);
            pinkPawnClouds.get(i).setVisible(false);
            bluePawnClouds.get(i).setVisible(false);
        }


    }


    //settato nel costruttore le pedine presenti invibili all'inizio
    //poi quando vengono randomizzate le pedine  e MN all'inizio del gioco, vengono settate su visibiili
    //io l'ho fatto poi è da vedere se funziona ;)
    public void displayInitialGameTable(){
         for(int i = 0; i < 12; i++){
             if(lightGame.getIslands().get(i).getGreenPawn()>0){
                 greenPawns.get(i).setVisible(true);
                 textGreen.get(i).setVisible(true);
                 textGreen.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getRedPawn()>0){
                 redPawns.get(i).setVisible(true);
                 textRed.get(i).setVisible(true);
                 textRed.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getYellowPawn()>0){
                 yellowPawns.get(i).setVisible(true);
                 textYellow.get(i).setVisible(true);
                 textYellow.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getPinkPawn()>0){
                 pinkPawns.get(i).setVisible(true);
                 textPink.get(i).setVisible(true);
                 textPink.get(i).setText("1");
             }else if(lightGame.getIslands().get(i).getBluePawn()>0){
                 bluePawns.get(i).setVisible(true);
                 textBlue.get(i).setVisible(true);
                 textBlue.get(i).setText("1");
             }
             if(lightGame.getIslands().get(i).getMotherNature())
                 motherNature.get(i).setVisible(true);
         }
    }
}