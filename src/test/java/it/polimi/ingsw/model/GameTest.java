package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {

    @Test
    public void testGame(){
        Game game = new Game(4, true);
        game.start(game);
        assertEquals(4, game.getTotPlayer());
        assertEquals(12, game.islands.size());
        int i;
        for(i=0; !game.islands.get(i).getMotherNature(); i++);
        System.out.println("Madre natura è sull'isola " + i);
        int s = i+1;
        if(s==12) s = 0;
        int r = game.islands.get(s).getRedPawn();
        System.out.println("Sull'isola " + s + " ci sono " + r + " pedine rosse");
        assertEquals(4, game.clouds.size());

    }
    @Test
    public void testCreateArrayPawn(){
        Game game = new Game(4, true);
        game.start(game);
        ArrayList<ColorPawn> a = Game.createArrayPawn(game.studentBag);
        System.out.println(a);
    }
    @Test
    public void testMoveMotherNature(){
        Game game = new Game(4, true);
        game.start(game);
        int i;
        for(i=0; !game.islands.get(i).getMotherNature(); i++);
        assertTrue(game.islands.get(i).getMotherNature());
        int j = i+3;
        if(j>=game.islands.size()) j = j - game.islands.size();
        assertFalse(game.islands.get(j).getMotherNature());
        game.moveMotherNature(game.islands.get(3));
        assertFalse(game.islands.get(i).getMotherNature());
        assertTrue(game.islands.get(3).getMotherNature());
    }
    @Test
    public void testCheckIsland(){
        Game game = new Game(3, true);
        game.start(game);
        game.islands.get(0).setTower(true);
        game.islands.get(0).setColorTower(ColorTower.BLACK);
        game.islands.get(1).setTower(true);
        game.islands.get(1).setColorTower(ColorTower.BLACK);
        game.islands.get(2).setTower(true);
        game.islands.get(2).setColorTower(ColorTower.BLACK);
        assertTrue(Game.checkIsland(1, 0, game));
        assertTrue(Game.checkIsland(1, 2, game));
    }
    @Test
    public void testUnifyIsland(){
        Game game = new Game(4, true);
        game.start(game);
        game.newPlayer("ciao",game);
        game.newPlayer("hei",game);
        game.newPlayer("ou",game);
        game.newPlayer("4",game);
        System.out.println(game.islands.size());
        game.getPlayers().get(1).getDiningRoom().setNumGreen(4);
        game.getPlayers().get(1).getDiningRoom().setNumBlue(3);
        game.getPlayers().get(0).getDiningRoom().setNumBlue(4);
        game.getPlayers().get(0).getDiningRoom().setNumRed(4);
        game.getPlayers().get(0).getDiningRoom().setNumYellow(4);
        game.moveProf();
        game.islands.get(0).setTower(true);
        game.islands.get(0).setColorTower(ColorTower.BLACK);
        game.islands.get(1).setTower(true);
        game.islands.get(1).setColorTower(ColorTower.BLACK);
        game.islands.get(2).setTower(true);
        game.islands.get(2).setColorTower(ColorTower.BLACK);
        game.moveMotherNature(game.getIslands().get(1));
        game.topInfluence(game.getIslands().get(1),game);
        System.out.println(game.islands.size());
        assertEquals(3, game.islands.get(0).getTotIsland());
    }

    @Test
    public void testTopInfluence(){
        Game game = new Game(3, true);
        game.start(game);
        String nick1 = "Franco";
        String nick2 = "Giovanni";
        String nick3 = "Raviolo";
        game.newPlayer(nick1, game);
        game.newPlayer(nick2, game);
        game.newPlayer(nick3, game);
        game.players.get(0).towerSpace.colorTower = ColorTower.BLACK;
        game.getProfTable().setGreenProf(0);
        game.getProfTable().setRedProf(0);
        game.getProfTable().setYellowProf(1);
        game.getProfTable().setPinkProf(2);
        game.getProfTable().setBlueProf(-1);
        game.islands.get(0).setGreenPawn(3);
        game.islands.get(0).setRedPawn(2);
        game.islands.get(0).setYellowPawn(4);
        game.islands.get(0).setPinkPawn(3);
        game.islands.get(0).setBluePawn(0);
        game.topInfluence(game.islands.get(0), game);
        assertEquals(ColorTower.BLACK, game.islands.get(0).getColorTower());
    }

    @Test
    public void testMoveProf(){
        Game game = new Game(3, true);
        game.start(game);
        String nick1 = "Franco";
        String nick2 = "Giovanni";
        String nick3 = "Raviolo";
        game.newPlayer(nick1, game);
        game.newPlayer(nick2, game);
        game.newPlayer(nick3, game);
        game.players.get(0).diningRoom.setNumGreen(3);
        game.players.get(0).diningRoom.setNumYellow(2);
        game.players.get(1).diningRoom.setNumGreen(2);
        game.players.get(1).diningRoom.setNumBlue(2);
        game.players.get(2).diningRoom.setNumPink(1);
        game.moveProf();
        assertEquals(0, game.getProfTable().getGreenProf());
        assertEquals(-1, game.getProfTable().getRedProf());
        assertEquals(0, game.getProfTable().getYellowProf());
        assertEquals(2, game.getProfTable().getPinkProf());
        assertEquals(1, game.getProfTable().getBlueProf());
    }
    @Test
    public void testNewPlayer(){
        Game game = new Game(4, true);
        game.start(game);
        int i;
        for(i=0; i < game.getTotPlayer(); i++){
            game.newPlayer("Franco", game);
        }
        assertEquals(4, game.players.size());
        assertEquals(10, game.players.get(0).deckAssistant.size());
    }
    @Test
    public void testSetCharacterCard(){
        Game game = new Game(4, true);
        game.start(game);
        game.setCharacterCards(game);
        int i;
        for(i=0; i<3; i++)
            System.out.println(game.characterCards.get(i).useEffect);
        assertEquals(6, game.characterCards.size());
    }
}