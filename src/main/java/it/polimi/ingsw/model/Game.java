package it.polimi.ingsw.model;


import java.util.*;

public class Game {
    private ArrayList<Player> players = new ArrayList<>(4);
    private int totPlayer = 0;
    private ArrayList<Cloud> clouds;
    private ProfTable profTable;
    private final ArrayList<Island> islands = new ArrayList<>(12);
    private boolean isExpert;
    private ArrayList<CharacterCard> cards = new ArrayList<>(3); //cambiato in arraylist;
    private ArrayList<CharacterCard> characterCards = new ArrayList<>(12);//insieme di tutti i characters
    protected Map<Integer, String> m = new HashMap<>();

    public void setTotPlayer(int totPlayer) {
        this.totPlayer = totPlayer;
    }
    public int getTotPlayer(){
        return totPlayer;
    }
    public void setExpert(boolean isExpert){
        this.isExpert = isExpert;
    }
    public boolean getExpert(){
        return isExpert;
    }

    public Game(int totPlayer, boolean isExpert) {
        this.totPlayer = totPlayer;
        this.isExpert = isExpert;
        int i;
        StudentBag studentBag= new StudentBag();
        ProfTable profTable = new ProfTable();
//creazione isole
        for (i = 0; i < 12; i++) {
            Island island = new Island();
            islands.add(island);
        }
//mappa che associa numeri a colori ("m.get(int)" per ricevere il colore in base al numero inserito in int)
        m.put(0, "GREEN");
        m.put(1, "RED");
        m.put(2, "YELLOW");
        m.put(3, "PINK");
        m.put(4, "BLUE");
//randomizza madre natura
        Random rnd = new Random();
        int n = rnd.nextInt(12);
        islands.get(n).setMotherNature(true);
//randomizza pedine per ogni isola iniziale
        int g = 2;
        int r = 2;
        int y = 2;
        int p = 2;
        int b = 2; //conteggio 2 pedine per colore
//arraylist per ogni colore
        ArrayList<String> startingPawn = new ArrayList<>(5);
        startingPawn.add(m.get(0));
        startingPawn.add(m.get(1));
        startingPawn.add(m.get(2));
        startingPawn.add(m.get(3));
        startingPawn.add(m.get(4));
        for (i = n + 1; !islands.get(i).getMotherNature(); i++) {
            if (i == 12) i = 0;
            if ((i == n + 6) || (i == n - 6)) i++;
            int random = rnd.nextInt(startingPawn.size());
            if (Objects.equals(startingPawn.get(random), m.get(0))) {
                g--;
                islands.get(i).setGreenPawn(islands.get(i).getGreenPawn() + 1);
                if (g == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(1))) {
                r--;
                islands.get(i).setRedPawn(islands.get(i).getRedPawn() + 1);
                if (r == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(2))) {
                y--;
                islands.get(i).setYellowPawn(islands.get(i).getYellowPawn() + 1);
                if (y == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(3))) {
                p--;
                islands.get(i).setPinkPawn(islands.get(i).getPinkPawn() + 1);
                if (p == 0) startingPawn.remove(random);
            } else if (Objects.equals(startingPawn.get(random), m.get(4))) {
                b--;
                islands.get(i).setBluePawn(islands.get(i).getBluePawn() + 1);
                if (b == 0) startingPawn.remove(random);
            }
        }
        // creazione nuvole e inizializzazione
        clouds = new ArrayList<>();
        for (i = 0; i < totPlayer; i++) {
            Cloud cloud = new Cloud();
            cloud.refillCloud();
            clouds.add(cloud);
        }
        //aggiunta di pedine all'entrata di ogni player
        for (i = 0; i < totPlayer; i++) {
            Player player= new Player("nick",i);
            int j =  player.entrance.numPawn;   //che cosa restituisce? numPawn si modifica nel tempo
            while (j > 0) {
                ArrayList<String> entrancePawn = createArrayPawn();
                int z = StudentBag.getNum();
                if (StudentBag.getNum() > 0) {
                    int random = rnd.nextInt(entrancePawn.size());
                    if (Objects.equals(entrancePawn.get(random), m.get(0))) {//verde
                        player.entrance.greenPawn++;
                        player.entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.greenNum--;
                        if (StudentBag.greenNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(1))) {//rosso
                        player.entrance.redPawn++;
                        player.entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.redNum--;
                        if (StudentBag.redNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(2))) {//giallo
                        player.entrance.yellowPawn++;
                        player.entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.yellowNum--;
                        if (StudentBag.yellowNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(3))) {//rosa
                        player.entrance.pinkPawn++;
                        player.entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.pinkNum--;
                        if (StudentBag.pinkNum == 0) entrancePawn.remove(random);
                    } else if (Objects.equals(entrancePawn.get(random), m.get(4))) {//blu
                        player.entrance.bluePawn++;
                        player.entrance.numPawn++;
                        StudentBag.num--;
                        StudentBag.blueNum--;
                        if (StudentBag.blueNum == 0) entrancePawn.remove(random);
                    }
                    players.add(player);
                    j--;
                }
            }
        }
        //creazione arraylist con tutte i personaggi
        Antonio antonio = new Antonio();
        Barbara barbara = new Barbara();
        Ciro ciro = new Ciro();
        Dante dante = new Dante();
        Ernesto ernesto = new Ernesto();
        Felix felix = new Felix();
        Giuseppe giuseppe = new Giuseppe();
        Ivan ivan = new Ivan();
        Lancillotto lancillotto = new Lancillotto();
        Maria maria = new Maria();
        Nicola nicola = new Nicola();
        Omnia omnia = new Omnia();
        characterCards.add(antonio);
        characterCards.add(barbara);
        characterCards.add(ciro);
        characterCards.add(dante);
        characterCards.add(ernesto);
        characterCards.add(felix);
        characterCards.add(giuseppe);
        characterCards.add(ivan);
        characterCards.add(lancillotto);
        characterCards.add(maria);
        characterCards.add(nicola);
        characterCards.add(omnia);
    }

    static ArrayList<String> createArrayPawn() {//crea un array per ogni colore (utilizzato per funzioni random)
        ArrayList<String> arrayPawn = new ArrayList<>();
        if (StudentBag.greenNum != 0)
            arrayPawn.add("GREEN");
        if (StudentBag.redNum != 0)
            arrayPawn.add("RED");
        if (StudentBag.yellowNum != 0)
            arrayPawn.add("YELLOW");
        if (StudentBag.pinkNum != 0)
            arrayPawn.add("PINK");
        if (StudentBag.blueNum != 0)
            arrayPawn.add("BLUE");
        return arrayPawn;
    }

  /*  public static void newPlayer(String nick) {
        int i;
        for(i=0; i<totPlayer; i++) {
            Player player = new Player(nick);//inizializzazione player fatta in player -NINO
            players.add(player);
        }
    }*/
    public void moveMotherNature(int num){
        int i;
        int totIsland = islands.size();
        for(i=0; !islands.get(i).isMotherNature; i++);
        islands.get(i).isMotherNature = false;
        num += i;
        if(num >= totIsland) num -= totIsland;
        islands.get(num).isMotherNature = true;
    }

    public static void unifyIsland(int i){ // si fa sempre dopo aver messo una torre, mettiamo in ingresso l'isola con madre natura
       int j;
       if(islands.get(i).isTower){
           j=i-1;
           if(j<0) j = islands.size();
           checkIsland(i, j);
           j=i+1;
           if(j>= islands.size()) j=0;
           checkIsland(i, j);
       }
    }

    private static void checkIsland(int i, int j) { //controlla se le due isole si possono unire, nel caso le unisce
        if(islands.get(j).isTower && islands.get(j).colorTower == islands.get(i).colorTower){
            islands.get(i).greenPawn += islands.get(j).greenPawn;
            islands.get(i).redPawn += islands.get(j).redPawn;
            islands.get(i).yellowPawn += islands.get(j).yellowPawn;
            islands.get(i).pinkPawn += islands.get(j).pinkPawn;
            islands.get(i).bluePawn += islands.get(j).bluePawn;
            islands.get(i).totIsland += islands.get(j).totIsland;
            islands.get(i).totIsland++;
            islands.remove(j);
        }
    }



    public static void topInfluence(Island island){
       int i, j, k, n, color, max;;
       boolean notunique = false;
       ArrayList<Integer> influence = new ArrayList<>();
       for(i=0; i<totPlayer; i++) influence.add(0);
       for(color=0; color<5; color++) {
           n = ProfTable.checkProf(color);
           if(color==0 && n!=-1) influence.set(n, influence.get(n) + island.greenPawn);

           else if(color==1 && n!=-1) influence.set(n, influence.get(n) + island.redPawn);

           else if(color==2 && n!=-1)influence.set(n, influence.get(n) + island.yellowPawn);

           else if(color==3 && n!=-1)influence.set(n, influence.get(n) + island.pinkPawn);

           else if(color==4 && n!=-1)influence.set(n, influence.get(n) + island.bluePawn);
       }
       if(totPlayer==4){
           for(i=1; players.get(i).towerSpace.colorTower == players.get(0).towerSpace.colorTower; i++);
           influence.set(0, influence.get(0) + influence.get(i));//ho tutte le pedine di una squadra sommate al player 0
           for(j=1; j<totPlayer && j==i; j++);
           for(k=2; k<totPlayer && (k==i || k==j); k++);
           influence.set(j, influence.get(j) + influence.get(k));//sommo tutte le pedine dell'altra squadra all'indirizzo j
           influence.set(i, 0);
           influence.set(k, 0);
       }

       for(i=0; i<totPlayer; i++){
           if(island.isTower && island.colorTower == players.get(i).towerSpace.colorTower)
               influence.set(i, influence.get(i) + island.totIsland);
       }

       max = Collections.max(influence);

       for(i=0; i<influence.size() && !notunique;i++){
           for(j=i+1; j<influence.size() && !notunique; j++){
               if((influence.get(i).equals(influence.get(j))) && influence.get(i).equals(max) && players.get(i).towerSpace.colorTower != players.get(j).towerSpace.colorTower) notunique = true;
           }
       }
       if(!notunique) island.colorTower = players.get(influence.indexOf(max)).towerSpace.colorTower;
       unifyIsland(islands.indexOf(island));
    }

    public boolean endGame(){
        return StudentBag.num == 0;
    }

    public void setCard() { //posiziona a caso dei personaggi (3)
        int i;
        Random rnd = new Random();
        int random = rnd.nextInt(characterCards.size());
        for (i = 0; i < 3; i++) {
            cards.add(characterCards.get(random));
            characterCards.remove(random);
            random = rnd.nextInt(characterCards.size());
        }
    }

    public static void moveProf(){
        int i, j;
        ArrayList<Integer> maxColor = new ArrayList<>();
        for(i=0; i<5; i++){
            if(i==0) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numGreen);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.greenProf = indexMax;
                maxColor.clear();
            }
            else if (i==1) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numRed);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.redProf = indexMax;
                maxColor.clear();
            }
            else if (i==2) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numYellow);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.yellowProf = indexMax;
                maxColor.clear();
            }
            else if (i==3) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numPink);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.pinkProf = indexMax;
                maxColor.clear();
            }
            else if (i==4) {
                for (j = 0; j < totPlayer; j++) maxColor.add(players.get(j).diningRoom.numBlue);
                int max = Collections.max(maxColor);
                int indexMax = maxColor.indexOf(max);
                maxColor.remove(indexMax);
                if (!maxColor.contains(max)) ProfTable.blueProf = indexMax;
                maxColor.clear();
            }
        }
    }
}