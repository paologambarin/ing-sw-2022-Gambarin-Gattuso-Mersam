package it.polimi.ingsw.model;


import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DiningRoomTest {
    @Test
    public void testDiningRoom(){
        Game game = new Game(2, true);
        game.newPlayer("Ezechiel",game);
        game.newPlayer("Candace",game);
        assertEquals(0, game.players.get(1).diningRoom.getNumYellow());
        assertEquals(0, game.players.get(1).diningRoom.getNumBlue());
        assertEquals(0, game.players.get(0).diningRoom.getNumPink());
    }

    @Test
    public void testAddPawnToDiningRoom(){
        Game game = new Game(2, true);
        game.newPlayer("Abner", game);
        game.newPlayer("Tamar", game);
        game.players.get(1).entrance.setNumPawn(7);
        game.players.get(1).entrance.setRedPawn(3);
        game.players.get(1).diningRoom.setNumRed(2);
        game.players.get(1).setNumCoin(4);
        game.players.get(1).diningRoom.addPawnToDiningRoom(ColorPawn.RED,  game.players.get(1), game);
        assertEquals(3, game.players.get(1).diningRoom.getNumRed());
        assertEquals(2, game.players.get(1).entrance.getRedPawn());
        assertEquals(5, game.players.get(1).getNumCoin());
    }

    @Test
    public void testAddPawn(){
        Game game = new Game(2, true);
        game.newPlayer("Ezra", game);
        game.newPlayer("Joshua", game);
        ArrayList<ColorPawn> colorPawn = new ArrayList<>(3);
        colorPawn.add(ColorPawn.BLUE);
        colorPawn.add(ColorPawn.YELLOW);
        colorPawn.add(ColorPawn.BLUE);
        game.players.get(1).diningRoom.setNumYellow(0);
        game.players.get(1).diningRoom.setNumBlue(2);
        int m = 3;
        game.players.get(1).diningRoom.addPawn(m, colorPawn, game.players.get(1), game);
        assertEquals(1, game.islands.get(4).getBluePawn());
        assertEquals(4, game.islands.get(4).getYellowPawn());
    }

    @Test
    public void testRemovePawnFromDiningRoom(){
        Game game = new Game(2, true);
        game.newPlayer("Ezra", game);
        game.newPlayer("Joshua", game);
        game.players.get(1).diningRoom.setNumPink(8);
        game.studentBag.setPinkNum(20);
        game.studentBag.setNum(98);
        game.players.get(1).diningRoom.removePawnFromDiningRoom(ColorPawn.PINK,  game.players.get(1), game);
        assertEquals(7, game.players.get(1).diningRoom.getNumPink());
        assertEquals(21, game.studentBag.getPinkNum());
        assertEquals(99, game.studentBag.getNum());
    }
    @Test
    public void testRemovePawnFromDiningRoom2(){
        Game game = new Game(2, true);
        game.newPlayer("Ezra", game);
        game.newPlayer("Joshua", game);
        game.players.get(1).diningRoom.setNumPink(8);
        game.players.get(1).entrance.setPinkPawn(1);
        game.players.get(1).entrance.setNumPawn(4);
        game.players.get(1).diningRoom.removePawnFromDiningRoom(ColorPawn.PINK,  game.players.get(1), game, game.players.get(1).entrance);
        assertEquals(7, game.players.get(1).diningRoom.getNumPink());
        assertEquals(2, game.players.get(1).entrance.getPinkPawn());
        assertEquals(5, game.players.get(1).entrance.getNumPawn());
    }

}