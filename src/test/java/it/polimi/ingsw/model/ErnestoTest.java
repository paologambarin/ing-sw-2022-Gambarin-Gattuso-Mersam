package it.polimi.ingsw.model;

import org.junit.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class ErnestoTest {
    @Test
    public void TestNotInfluence() {
        int contr = 0;
        Game game = new Game(3, true);
        game.start(game);
        while (contr == 0) {
            if (game.getCharacterCards().get(0).getNumCard()==4) {
                contr = 1;
            }
            if (contr == 0) {
                game = new Game(3, true);
                game.start(game);
            }
        }
        String nick1 = "Rebeca";
        String nick2 = "Paolo";
        String nick3 = "Antonino";
        game.newPlayer(nick1, game);
        game.newPlayer(nick2, game);
        game.newPlayer(nick3, game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(1);
        colorPawn.add(ColorPawn.GREEN);
        game.getProfTable().setGreenProf(0);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(1);
        game.getProfTable().setBlueProf(-1);
        game.islands.get(9).setGreenPawn(6);
        game.islands.get(9).setRedPawn(2);
        game.islands.get(9).setYellowPawn(3);
        game.islands.get(9).setPinkPawn(2);
        game.islands.get(9).setBluePawn(0);
        game.islands.get(9).setTower(true);
        game.islands.get(9).setColorTower(ColorTower.BLACK);
        game.getCharacterCards().get(0).getUseEffect().useEffect(game, 5, game.islands.get(9), game.players.get(0), colorPawn);
        game.topInfluence(game.islands.get(9), game);
        assertEquals(ColorTower.BLACK, game.islands.get(9).getColorTower());
    }
}