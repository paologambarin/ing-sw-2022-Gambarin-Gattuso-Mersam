package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.awt.*;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class LancillottoTest {
    @Test
    public void testLancillotto(){
        Game game = new Game(3, true);
        String nick1 = "Franco";
        String nick2 = "Giovanni";
        String nick3 = "Raviolo";
        Game.newPlayer(nick1, game);
        Game.newPlayer(nick2, game);
        Game.newPlayer(nick3, game);
        Game.players.get(0).towerSpace.colorTower = ColorTower.BLACK;
        Game.players.get(1).towerSpace.colorTower = ColorTower.WHITE;
        Game.players.get(2).towerSpace.colorTower = ColorTower.GREY;
        ProfTable.setGreenProf(0);
        ProfTable.setRedProf(0);
        ProfTable.setYellowProf(1);
        ProfTable.setPinkProf(2);
        ProfTable.setBlueProf(-1);
        Game.islands.get(0).setGreenPawn(3);
        Game.islands.get(0).setRedPawn(2);
        Game.islands.get(0).setYellowPawn(4);
        Game.islands.get(0).setPinkPawn(3);
        Game.islands.get(0).setBluePawn(0);
        Lancillotto lancillotto = new Lancillotto();
        CharacterCard card1 = new CharacterCard(lancillotto);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        card1.useEffect.useEffect(game, 2,Game.islands.get(0),Game.players.get(0),colorPawn);
        assertEquals(ColorTower.WHITE, Game.islands.get(0).getColorTower());
    }

}