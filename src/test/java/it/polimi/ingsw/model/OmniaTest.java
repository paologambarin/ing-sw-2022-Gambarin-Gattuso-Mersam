package it.polimi.ingsw.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class OmniaTest {
    @Test
    public void testUseEffectOmnia(){
        Game game = new Game(4, true);
        game.start(game);
        Game.newPlayer("Johnny", game);
        Game.newPlayer("Frank", game);
        Game.newPlayer("Sibilla", game);
        Game.newPlayer("Ruperta", game);
        game.players.get(0).diningRoom.position[0][0] = 1;
        game.players.get(0).diningRoom.position[0][1] = 1;
        game.players.get(0).diningRoom.position[0][2] = 1;
        game.players.get(0).diningRoom.position[0][3] = 1;
        game.players.get(0).diningRoom.setNumGreen(4);
        game.players.get(0).diningRoom.position[2][0] = 1;
        game.players.get(0).diningRoom.position[2][1] = 1;
        game.players.get(0).diningRoom.setNumYellow(3);
        ArrayList<ColorPawn> colorPawns = new ArrayList<>();
        colorPawns.add(ColorPawn.GREEN);
        Omnia omnia = new Omnia();
        CharacterCard card = new CharacterCard(omnia);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
        card.useEffect.useEffect(game, 1, game.islands.get(0), game.players.get(0), colorPawns);
        System.out.println(game.players.get(0).diningRoom.getNumGreen());
    }
}