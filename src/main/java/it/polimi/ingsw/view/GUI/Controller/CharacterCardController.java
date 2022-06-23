package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class CharacterCardController {
    @FXML
    public Pane characterCards;
    ArrayList<ColorPawn> colori = new ArrayList<>();
    int island = -1;
    Gui gui;
    GameTableController gameTableController;

    public Pane getCharacterCards(){return characterCards;}

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    public void setCharacterCards(){
        setInvisibleAll();
        setDisableAll();
        showCharacter();
    }
    
    public void setDisableAll() {
        for (Node character : characterCards.getChildren()) {
            character.setDisable(true);
        }
    }

    public void setInvisibleAll(){
        for (Node character : characterCards.getChildren()) {
            character.setVisible(false);
        }
    }


    public void showCharacter(){
        for(int i = 0; i < gui.getLightGame().getCharacterCards().size(); i++){
                for(Node character : characterCards.getChildren()){
                    if(character.getId().equals(i + "characterCard" + gui.getLightGame().getCharacterCards().get(i).getNumCard()))
                        character.setVisible(true);
                }
            }
        }

    public void setDisable(int n, boolean disable) {
        String name = "#characterCard" + n;
        characterCards.lookup(name).setDisable(disable);
    }

    public void setVisible(int n, boolean visible) {
        String name = "#characterCard" + n;
        characterCards.lookup(name).setVisible(visible);
    }

    public void setColorCharacterVisible(int color, int character, boolean visible) {
        String name;
        String text;
        if (color == 0) {
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textGreenCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 1) {
            name = "#redCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textRedCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 2) {
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textYellowCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 3) {
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textPinkCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        } else if (color == 4) {
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setVisible(visible);
            text = "#textBlueCharacter" + character;
            characterCards.lookup(text).setVisible(visible);
        }
    }


    public void setColorDisabled(int color, int character, boolean disabled) {
        String name;
        if (color == 0) {
            name = "#greenCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 1) {
            name = "#redCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 2) {
            name = "#yellowCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 3) {
            name = "#pinkCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        } else if (color == 4) {
            name = "#blueCharacter" + character;
            characterCards.lookup(name).setDisable(disabled);
        }
    }

    public void setCoinVisible(int character, boolean visible) {
        String name = "#coin" + character;
        characterCards.lookup(name).setVisible(visible);
    }

    public void character0Select(MouseEvent mouseEvent) {
        int player = -1;
        for (int i = 0; i < gui.getLightGame().getNumPlayers(); i++) {
            if (gui.getLightGame().getPlayers().get(i).getNickname().equals(gui.getSocketNetworkHandler().getNicknameThisPlayer()))
                player = i;
        }
        if (gui.getLightGame().getCharacterCards().get(0).getNumCard() == 0) {
                for(int i = 0; i < 3; i++)
                    setDisable(i, true);
                characterCards.lookup("greenCharacter0").setDisable(false);
                characterCards.lookup("redCharacter0").setDisable(false);
                characterCards.lookup("yellowCharacter0").setDisable(false);
                characterCards.lookup("pinkCharacter0").setDisable(false);
                characterCards.lookup("blueCharacter0").setDisable(false);
            }
        }


    public void moveGreenCharacter0(MouseEvent mouseEvent) {
        colori.add(ColorPawn.GREEN);
        if (gui.getLightGame().getCharacterCards().get(0).getNumCard() == 0) {
            characterCards.lookup("greenCharacter0").setDisable(true);
            characterCards.lookup("redCharacter0").setDisable(true);
            characterCards.lookup("yellowCharacter0").setDisable(true);
            characterCards.lookup("pinkCharacter0").setDisable(true);
            characterCards.lookup("blueCharacter0").setDisable(true);
            gameTableController.setAllIslands(true, false);
        }
    }

    public void character2Select(MouseEvent mouseEvent) {
    }

    public void character1Select(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter0(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter0(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter0(MouseEvent mouseEvent) {
    }

    public void moveGreenCharacter1(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter1(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter1(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter0(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter2(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter2(MouseEvent mouseEvent) {
    }

    public void moveYellowCharacter2(MouseEvent mouseEvent) {
    }

    public void moveRedCharacter2(MouseEvent mouseEvent) {
    }

    public void moveGreenCharacter2(MouseEvent mouseEvent) {
    }

    public void movePinkCharacter1(MouseEvent mouseEvent) {
    }

    public void moveBlueCharacter1(MouseEvent mouseEvent) {
    }
}
