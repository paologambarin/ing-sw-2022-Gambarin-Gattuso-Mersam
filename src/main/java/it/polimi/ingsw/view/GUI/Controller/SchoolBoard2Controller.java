package it.polimi.ingsw.view.GUI.Controller;

import it.polimi.ingsw.client.ModelLight.LightGame;
import it.polimi.ingsw.model.ColorPawn;
import it.polimi.ingsw.view.GUI.Gui;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;

public class SchoolBoard2Controller {
    Gui gui;
    LightGame lightGame;//da qualche parte ha bisogno di ricevere lightGame

    public void setGui(Gui gui){this.gui=gui;}

    public void setLightGame(LightGame lightGame){this.lightGame=lightGame;}

    @FXML Pane schoolBoard2;

    public void setSchoolBoard2(){
        setAllInvisible();
        setEntrance2();
        setDiningRoom2();
        setTower2();
        setCoin2();
    }

    public void setAllInvisible(){
        for(Node all : schoolBoard2.getChildren()) {
            all.setVisible(false);
            all.setDisable(true);
        }
    }

    public void setEntrance2Clickable(){
        setEntrance2();
        int green = lightGame.getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=2; i<green; i++){
            schoolBoard2.lookup("entranceGreen2" + i).setDisable(false);
        }
        int red = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard2.lookup("entranceRed2" + i).setDisable(false);
        }
        int yellow = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard2.lookup("entranceYellow2" + i).setDisable(false);
        }
        int pink = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard2.lookup("entrancePink2" + i).setDisable(false);
        }
        int blue = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard2.lookup("entranceBlue2" + i).setDisable(false);
        }
    }

    public void setEntrance2(){
        int green = lightGame.getPlayers().get(2).getEntrance().getGreenPawn();
        for(int i=2; i<green; i++){
            schoolBoard2.lookup("entranceGreen2" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + green;
        for(int i=green; i<red; i++){
            schoolBoard2.lookup("entranceRed2" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(2).getEntrance().getRedPawn() + red;
        for(int i=red; i<yellow; i++){
            schoolBoard2.lookup("entranceYellow2" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + yellow;
        for(int i=yellow; i<pink; i++){
            schoolBoard2.lookup("entrancePink2" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(2).getEntrance().getPinkPawn() + pink;
        for(int i=pink; i<blue; i++){
            schoolBoard2.lookup("entranceBlue2" + i).setVisible(true);
        }
    }

    public void setDiningRoom2(){
        int green = lightGame.getPlayers().get(2).getDiningRoom().getNumGreen();
        for(int i=2; i<green; i++){
            schoolBoard2.lookup("schoolGreen2" + i).setVisible(true);
        }
        int red = lightGame.getPlayers().get(2).getDiningRoom().getNumRed();
        for(int i=2; i<red; i++){
            schoolBoard2.lookup("schoolRed2" + i).setVisible(true);
        }
        int yellow = lightGame.getPlayers().get(2).getDiningRoom().getNumYellow();
        for(int i=2; i<yellow; i++){
            schoolBoard2.lookup("schoolYellow2" + i).setVisible(true);
        }
        int pink = lightGame.getPlayers().get(2).getDiningRoom().getNumPink();
        for(int i=2; i<pink; i++){
            schoolBoard2.lookup("schoolPink2" + i).setVisible(true);
        }
        int blue = lightGame.getPlayers().get(2).getDiningRoom().getNumBlue();
        for(int i=2; i<blue; i++){
            schoolBoard2.lookup("schoolBlue2" + i).setVisible(true);
        }
    }

    public void setProfessor2(){
        if(lightGame.getProfTable().getGreenProf() == 2)
            schoolBoard2.lookup("schoolGreenProf2").setVisible(true);
        if(lightGame.getProfTable().getRedProf() == 2)
            schoolBoard2.lookup("schoolRedProf2").setVisible(true);
        if(lightGame.getProfTable().getYellowProf() == 2)
            schoolBoard2.lookup("schoolYellowProf2").setVisible(true);
        if(lightGame.getProfTable().getPinkProf() == 2)
            schoolBoard2.lookup("schoolPinkProf2").setVisible(true);
        if(lightGame.getProfTable().getBlueProf() == 2)
            schoolBoard2.lookup("schoolBlueProf2").setVisible(true);
    }

    public void setTower2(){
        for(int i = 2; i<lightGame.getPlayers().get(2).getTowerSpace().getNumTower(); i++)
            schoolBoard2.lookup("blackTowerSchool" + i).setVisible(true);
    }

    public void setCoin2() {
        for (int i = 2; i < lightGame.getPlayers().get(2).getNumCoin(); i++)
            schoolBoard2.lookup("coin" + i).setVisible(true);
    }


    public ColorPawn green20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen2").setVisible(false);
        schoolBoard2.lookup("entranceGreen2").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen21").setVisible(false);
        schoolBoard2.lookup("entranceGreen21").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen22").setVisible(false);
        schoolBoard2.lookup("entranceGreen22").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen23").setVisible(false);
        schoolBoard2.lookup("entranceGreen23").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen24").setVisible(false);
        schoolBoard2.lookup("entranceGreen24").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen25").setVisible(false);
        schoolBoard2.lookup("entranceGreen25").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen26").setVisible(false);
        schoolBoard2.lookup("entranceGreen26").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen27").setVisible(false);
        schoolBoard2.lookup("entranceGreen27").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn green28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceGreen28").setVisible(false);
        schoolBoard2.lookup("entranceGreen28").setDisable(true);
        return ColorPawn.GREEN;
    }

    public ColorPawn red20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed2").setVisible(false);
        schoolBoard2.lookup("entranceRed2").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed21").setVisible(false);
        schoolBoard2.lookup("entranceRed21").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed22").setVisible(false);
        schoolBoard2.lookup("entranceRed22").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed23").setVisible(false);
        schoolBoard2.lookup("entranceRed23").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed24").setVisible(false);
        schoolBoard2.lookup("entranceRed24").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed25").setVisible(false);
        schoolBoard2.lookup("entranceRed25").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed26").setVisible(false);
        schoolBoard2.lookup("entranceRed26").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed27").setVisible(false);
        schoolBoard2.lookup("entranceRed27").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn red28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceRed28").setVisible(false);
        schoolBoard2.lookup("entranceRed28").setDisable(true);
        return ColorPawn.RED;
    }

    public ColorPawn yellow20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow2").setVisible(false);
        schoolBoard2.lookup("entranceYellow2").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow21").setVisible(false);
        schoolBoard2.lookup("entranceYellow21").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow22").setVisible(false);
        schoolBoard2.lookup("entranceYellow22").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow23").setVisible(false);
        schoolBoard2.lookup("entranceYellow23").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow24").setVisible(false);
        schoolBoard2.lookup("entranceYellow24").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow26").setVisible(false);
        schoolBoard2.lookup("entranceYellow26").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn yellow28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceYellow25").setVisible(false);
        schoolBoard2.lookup("entranceYellow25").setDisable(true);
        return ColorPawn.YELLOW;
    }

    public ColorPawn pink20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink2").setVisible(false);
        schoolBoard2.lookup("entrancePink2").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink21").setVisible(false);
        schoolBoard2.lookup("entrancePink21").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink22").setVisible(false);
        schoolBoard2.lookup("entrancePink22").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink23").setVisible(false);
        schoolBoard2.lookup("entrancePink23").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink24").setVisible(false);
        schoolBoard2.lookup("entrancePink24").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink25").setVisible(false);
        schoolBoard2.lookup("entrancePink25").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink26").setVisible(false);
        schoolBoard2.lookup("entrancePink26").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink27").setVisible(false);
        schoolBoard2.lookup("entrancePink27").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn pink28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entrancePink28").setVisible(false);
        schoolBoard2.lookup("entrancePink28").setDisable(true);
        return ColorPawn.PINK;
    }

    public ColorPawn blue20Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue2").setVisible(false);
        schoolBoard2.lookup("entranceBlue2").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue21Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue21").setVisible(false);
        schoolBoard2.lookup("entranceBlue21").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue22Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue22").setVisible(false);
        schoolBoard2.lookup("entranceBlue22").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue23Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue23").setVisible(false);
        schoolBoard2.lookup("entranceBlue23").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue24Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue24").setVisible(false);
        schoolBoard2.lookup("entranceBlue24").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue25Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue25").setVisible(false);
        schoolBoard2.lookup("entranceBlue25").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue26Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue26").setVisible(false);
        schoolBoard2.lookup("entranceBlue26").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue27Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue27").setVisible(false);
        schoolBoard2.lookup("entranceBlue27").setDisable(true);
        return ColorPawn.BLUE;
    }

    public ColorPawn blue28Select(MouseEvent mouseEvent) {
        schoolBoard2.lookup("entranceBlue28").setVisible(false);
        schoolBoard2.lookup("entranceBlue28").setDisable(true);
        return ColorPawn.BLUE;
    }
}
