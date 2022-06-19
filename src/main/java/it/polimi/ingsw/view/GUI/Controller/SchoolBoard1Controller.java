package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard1Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){this.gui=gui;}

    public void setLightGame(LightGame lightGame){this.lightGame=lightGame;}

    @FXML Pane schoolBoard1;

    public void setSchoolBoard1(){
        setAllInvisible();
        setEntrance1();
        setDiningRoom1();
        setTower1();
        setCoin1();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard1.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
        }
    }

    public void setEntrance1Clickable(){
        setEntrance1();
        int green = lightGame.getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=1; i<green; i++){
            schoolBoard1.lookup("entranceGreen1" + i).setDisable(false);
        }
        int red = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard1.lookup("entranceRed1" + i).setDisable(false);
        }
        int yellow = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard1.lookup("entranceYellow1" + i).setDisable(false);
        }
        int pink = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard1.lookup("entrancePink1" + i).setDisable(false);
        }
        int blue = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard1.lookup("entranceBlue1" + i).setDisable(false);
        }
    }

    public void setEntrance1(){
        int green = lightGame.getPlayers().get(1).getEntrance().getGreenPawn();
        for(int i=1; i<green; i++){
            schoolBoard1.lookup("entranceGreen1" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard1.lookup("entranceRed1" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(1).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard1.lookup("entranceYellow1" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard1.lookup("entrancePink1" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(1).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard1.lookup("entranceBlue1" + i).setVisible(true);
        }
    }

    public void setDiningRoom1(){
        int green = lightGame.getPlayers().get(1).getDiningRoom().getNumGreen();
        for(int i=1; i<green; i++){
            schoolBoard1.lookup("schoolGreen1" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(1).getDiningRoom().getNumRed();
        for(int i=1; i<red; i++){
            schoolBoard1.lookup("schoolRed1" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(1).getDiningRoom().getNumYellow();
        for(int i=1; i<yellow; i++){
            schoolBoard1.lookup("schoolYellow1" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(1).getDiningRoom().getNumPink();
        for(int i=1; i<pink; i++){
            schoolBoard1.lookup("schoolPink1" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(1).getDiningRoom().getNumBlue();
        for(int i=1; i<blue; i++){
            schoolBoard1.lookup("schoolBlue1" + i).setVisible(true);
        }
    }

    public void setProfessor1(){
        if(lightGame.getProfTable().getGreenProf() == 1)
            schoolBoard1.lookup("schoolGreenProf1").setVisible(true);
        if(lightGame.getProfTable().getRedProf() == 1)
            schoolBoard1.lookup("schoolRedProf1").setVisible(true);
        if(lightGame.getProfTable().getYellowProf() == 1)
            schoolBoard1.lookup("schoolYellowProf1").setVisible(true);
        if(lightGame.getProfTable().getPinkProf() == 1)
            schoolBoard1.lookup("schoolPinkProf1").setVisible(true);
        if(lightGame.getProfTable().getBlueProf() == 1)
            schoolBoard1.lookup("schoolBlueProf1").setVisible(true);
    }

    public void setTower1(){
        for(int i = 1; i<lightGame.getPlayers().get(1).getTowerSpace().getNumTower(); i++)
            schoolBoard1.lookup("blackTowerSchool" + i).setVisible(true);
    }

    public void setCoin1() {
        for (int i = 1; i < lightGame.getPlayers().get(1).getNumCoin(); i++)
            schoolBoard1.lookup("coin" + i).setVisible(true);
    }


    public ColorPawn green10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen1").setVisible(false);
        schoolBoard1.lookup("entranceGreen1").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen11").setVisible(false);
        schoolBoard1.lookup("entranceGreen11").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen12").setVisible(false);
        schoolBoard1.lookup("entranceGreen12").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen13").setVisible(false);
        schoolBoard1.lookup("entranceGreen13").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen14").setVisible(false);
        schoolBoard1.lookup("entranceGreen14").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen15").setVisible(false);
        schoolBoard1.lookup("entranceGreen15").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen16").setVisible(false);
        schoolBoard1.lookup("entranceGreen16").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen17").setVisible(false);
        schoolBoard1.lookup("entranceGreen17").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceGreen18").setVisible(false);
        schoolBoard1.lookup("entranceGreen18").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn red10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed1").setVisible(false);
        schoolBoard1.lookup("entranceRed1").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed11").setVisible(false);
        schoolBoard1.lookup("entranceRed11").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed12").setVisible(false);
        schoolBoard1.lookup("entranceRed12").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed13").setVisible(false);
        schoolBoard1.lookup("entranceRed13").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed14").setVisible(false);
        schoolBoard1.lookup("entranceRed14").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed15").setVisible(false);
        schoolBoard1.lookup("entranceRed15").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed16").setVisible(false);
        schoolBoard1.lookup("entranceRed16").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed17").setVisible(false);
        schoolBoard1.lookup("entranceRed17").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceRed18").setVisible(false);
        schoolBoard1.lookup("entranceRed18").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn yellow10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow1").setVisible(false);
        schoolBoard1.lookup("entranceYellow1").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow11").setVisible(false);
        schoolBoard1.lookup("entranceYellow11").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow12").setVisible(false);
        schoolBoard1.lookup("entranceYellow12").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow13").setVisible(false);
        schoolBoard1.lookup("entranceYellow13").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow14").setVisible(false);
        schoolBoard1.lookup("entranceYellow14").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow15").setVisible(false);
        schoolBoard1.lookup("entranceYellow15").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow16").setVisible(false);
        schoolBoard1.lookup("entranceYellow16").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow15").setVisible(false);
        schoolBoard1.lookup("entranceYellow15").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceYellow15").setVisible(false);
        schoolBoard1.lookup("entranceYellow15").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn pink10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink1").setVisible(false);
        schoolBoard1.lookup("entrancePink1").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink11").setVisible(false);
        schoolBoard1.lookup("entrancePink11").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink12").setVisible(false);
        schoolBoard1.lookup("entrancePink12").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink13").setVisible(false);
        schoolBoard1.lookup("entrancePink13").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink14").setVisible(false);
        schoolBoard1.lookup("entrancePink14").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink15").setVisible(false);
        schoolBoard1.lookup("entrancePink15").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink16").setVisible(false);
        schoolBoard1.lookup("entrancePink16").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink17").setVisible(false);
        schoolBoard1.lookup("entrancePink17").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entrancePink18").setVisible(false);
        schoolBoard1.lookup("entrancePink18").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn blue10Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue1").setVisible(false);
        schoolBoard1.lookup("entranceBlue1").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue11Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue11").setVisible(false);
        schoolBoard1.lookup("entranceBlue11").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue12Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue12").setVisible(false);
        schoolBoard1.lookup("entranceBlue12").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue13Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue13").setVisible(false);
        schoolBoard1.lookup("entranceBlue13").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue14Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue14").setVisible(false);
        schoolBoard1.lookup("entranceBlue14").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue15Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue15").setVisible(false);
        schoolBoard1.lookup("entranceBlue15").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue16Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue16").setVisible(false);
        schoolBoard1.lookup("entranceBlue16").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue17Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue17").setVisible(false);
        schoolBoard1.lookup("entranceBlue17").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue18Select(MouseEvent mouseEvent) {
        schoolBoard1.lookup("entranceBlue18").setVisible(false);
        schoolBoard1.lookup("entranceBlue18").setDisable(true);
        return ColorPawn.BLUE;
    }
}
