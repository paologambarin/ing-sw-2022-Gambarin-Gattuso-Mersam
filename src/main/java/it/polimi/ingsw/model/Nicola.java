package it.polimi.ingsw.model;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Random;

public class Nicola extends CharacterCard{
    private static int greenPawn;
    private static int redPawn;
    private static int yellowPawn;
    private static int pinkPawn;
    private static int bluePawn;
    Nicola(){
        Random rnd = new Random();
        ArrayList<String> cards = Game.createArrayPawn();
        if (StudentBag.getNum() > 0) {
            int random = rnd.nextInt(cards.size());
            if (Objects.equals(cards.get(random), Game.m.get(0))) {//verde
                setGreenPawn(getGreenPawn() + 1);
                StudentBag.setNum(StudentBag.getNum() - 1);
                StudentBag.setGreenNum(StudentBag.getGreenNum() - 1);
                if (StudentBag.getGreenNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(1))) {//rosso
                setRedPawn(getRedPawn() + 1);
                StudentBag.setNum(StudentBag.getNum() - 1);
                StudentBag.setRedNum(StudentBag.getRedNum() - 1);
                if (StudentBag.getRedNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(2))) {//giallo
                setYellowPawn(getYellowPawn() + 1);
                StudentBag.setNum(StudentBag.getNum() - 1);
                StudentBag.setYellowNum(StudentBag.getYellowNum() - 1);
                if (StudentBag.getYellowNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), m.get(3))) {//rosa
                setPinkPawn(getPinkPawn() + 1);
                StudentBag.setNum(StudentBag.getNum() - 1);
                StudentBag.setPinkNum(StudentBag.getPinkNum() - 1);
                if (StudentBag.getPinkNum() == 0) cards.remove(random);
            } else if (Objects.equals(cards.get(random), Game.m.get(4))) {//blu
                setBluePawn(getBluePawn() + 1);
                StudentBag.setNum(StudentBag.getNum() - 1);
                StudentBag.setBlueNum(StudentBag.getBlueNum() - 1);
                if (StudentBag.getBlueNum() == 0) cards.remove(random);
            }
        }
        coinPrice=2;
    }
    public static void setGreenPawn(int i){
        greenPawn = i;
    }
    public static int getGreenPawn(){
        return greenPawn;
    }
    public static void setRedPawn(int i){
        redPawn = i;
    }
    public static int getRedPawn(){
        return redPawn;
    }
    public static void setYellowPawn(int i){
        yellowPawn = i;
    }
    public static int getYellowPawn(){
        return yellowPawn;
    }
    public void setPinkPawn(int i){
        pinkPawn = i;
    }
    public static int getPinkPawn(){
        return pinkPawn;
    }
    public static void setBluePawn(int i){
        bluePawn = i;
    }
    public static int getBluePawn() {
        return bluePawn;
    }


    public void refillNicola(){

    }
}
