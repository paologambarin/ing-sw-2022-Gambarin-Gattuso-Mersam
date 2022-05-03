package it.polimi.ingsw.model;
import java.util.ArrayList;
import java.util.Objects;
public class DiningRoom {
    //modifiche all'UML: array di array: in cui gli elementi sono 0 o 1;
    //5 int che tengono conto di quante pedine di ogni colore sono presenti nella sala
    int[][] position = new int[5][10];
    private int numGreen;
    private int numRed;
    private int numYellow;
    private int numPink;
    private int numBlue;

    public int getNumGreen() {
        return numGreen;
    }
    public int getNumRed() {
        return numRed;
    }
    public int getNumYellow() {
        return numYellow;
    }
    public int getNumPink() {
        return numPink;
    }
    public int getNumBlue() {
        return numBlue;
    }
    public void setNumGreen(int numGreen) {
        this.numGreen = numGreen;
    }
    public void setNumRed(int numRed) {
        this.numRed = numRed;
    }
    public void setNumYellow(int numYellow) {
        this.numYellow = numYellow;
    }
    public void setNumPink(int numPink) {
        this.numPink = numPink;
    }
    public void setNumBlue(int numBlue) {
        this.numBlue = numBlue;
    }

     public DiningRoom() {
        int i,j;
        for(i=0;i<10;i++){
            for(j=0;j<5;j++){
                position[j][i]=0;
            }
        }
        numGreen = 0;
        numRed = 0;
        numYellow = 0;
        numPink = 0;
        numBlue = 0;
    }

    public void addPawnToDiningRoom(ColorPawn colorPawn, Player player, Game game) {
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) && player.entrance.getGreenPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[0][j] != 1) {
                    player.diningRoom.position[0][j] = 1;
                    player.diningRoom.setNumGreen(j+1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1)) && player.entrance.getRedPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[1][j] != 1) {
                    player.diningRoom.position[1][j] = 1;
                    player.diningRoom.setNumRed(j+1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2)) && player.entrance.getYellowPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[2][j] != 1) {
                    player.diningRoom.position[2][j] = 1;
                    player.diningRoom.setNumYellow(j+1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3)) && player.entrance.getPinkPawn() > 0) {
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[3][j] != 1) {
                    player.diningRoom.position[3][j] = 1;
                    player.diningRoom.setNumPink(j+1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4)) && player.entrance.getBluePawn() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 0; j < 10; j++) {
                if (player.diningRoom.position[4][j] != 1) {
                    player.diningRoom.position[4][j] = 1;
                    player.diningRoom.setNumBlue(j+1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() - 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() - 1);
                    if (game.isExpert && ( j == 2 || j == 5 || j == 8))
                        player.setNumCoin(player.getNumCoin() + 1);
                    break;
                }
            }
        }
    }
    public void addPawn(int m, ArrayList<ColorPawn> colorPawn, Player player, Game game) {
        if ((game.totPlayer == 2 || game.totPlayer == 4) && (m > 0 && m < 4)) {
            while (m > 0) {
                addPawnToDiningRoom(colorPawn.get(m - 1), player, game);
                m--;
            }
        }
        if (game.totPlayer == 3 && (m > 0 && m < 5)) {
            while (m > 0) {
                addPawnToDiningRoom(colorPawn.get(m - 1), player, game);
                m--;
            }
        }
    }
    public void removePawnFromDiningRoom(ColorPawn colorPawn, Player player, Game game) { //le sposta da dining al sacchetto
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) ) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[0][j] != 0) {
                    player.diningRoom.position[0][j] = 0;
                    player.diningRoom.setNumGreen(player.diningRoom.getNumGreen() - 1);
                    game.studentBag.setGreenNum(game.studentBag.getGreenNum() + 1);
                    game.studentBag.setNum(game.studentBag.getNum() + 1);
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1))) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[1][j] != 0) {
                        player.diningRoom.position[1][j] = 0;
                        player.diningRoom.setNumRed(player.diningRoom.getNumRed() - 1);
                        game.studentBag.setRedNum(game.studentBag.getRedNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2))) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[2][j] != 0) {
                        player.diningRoom.position[2][j] = 0;
                        player.diningRoom.setNumYellow(player.diningRoom.getNumYellow() - 1);
                        game.studentBag.setYellowNum(game.studentBag.getYellowNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3))) {
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[3][j] != 0) {
                        player.diningRoom.position[3][j] = 0;
                        player.diningRoom.setNumPink(player.diningRoom.getNumPink() - 1);
                        game.studentBag.setPinkNum(game.studentBag.getPinkNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4))) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
                for (j = 9; j > -1; j--) {
                    if (player.diningRoom.position[4][j] != 0) {
                        player.diningRoom.position[4][j] = 0;
                        player.diningRoom.setNumBlue(player.diningRoom.getNumBlue() - 1);
                        game.studentBag.setBlueNum(game.studentBag.getBlueNum() + 1);
                        game.studentBag.setNum(game.studentBag.getNum() + 1);
                        break;
                    }
                }
        }
    }
    public void removePawnFromDiningRoomToEntrance(ColorPawn colorPawn, Player player, Game game) {//le sposta da dining all'entrance
        int j; //variabile che serve a iterare dentro le righe della sala
        if (Objects.equals(colorPawn.toString(), game.m.get(0)) && player.diningRoom.getNumGreen() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[0][j] != 0) {
                    player.diningRoom.position[0][j] = 0;
                    player.diningRoom.setNumGreen(player.diningRoom.getNumGreen() - 1);
                    player.entrance.setGreenPawn(player.entrance.getGreenPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(1)) && player.diningRoom.getNumRed() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[1][j] != 0) {
                    player.diningRoom.position[1][j] = 0;
                    player.diningRoom.setNumRed(player.diningRoom.getNumRed() - 1);
                    player.entrance.setRedPawn(player.entrance.getRedPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(2)) && player.diningRoom.getNumYellow() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[2][j] != 0) {
                    player.diningRoom.position[2][j] = 0;
                    player.diningRoom.setNumYellow(player.diningRoom.getNumYellow() - 1);
                    player.entrance.setYellowPawn(player.entrance.getYellowPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(3))&& player.diningRoom.getNumPink() > 0) {
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[3][j] != 0) {
                    player.diningRoom.position[3][j] = 0;
                    player.diningRoom.setNumPink(player.diningRoom.getNumPink() - 1);
                    player.entrance.setPinkPawn(player.entrance.getPinkPawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        } else if (Objects.equals(colorPawn.toString(), game.m.get(4)) && player.diningRoom.getNumBlue() > 0) { //metodo toString restituisce la rappresentazione di stringa delle costanti enum
            for (j = 9; j > -1; j--) {
                if (player.diningRoom.position[4][j] != 0) {
                    player.diningRoom.position[4][j] = 0;
                    player.diningRoom.setNumBlue(player.diningRoom.getNumBlue() - 1);
                    player.entrance.setBluePawn(player.entrance.getBluePawn() + 1);
                    player.entrance.setNumPawn(player.entrance.getNumPawn() + 1);
                    break;
                }
            }
        }
    }
}