package it.polimi.ingsw.view.Cli;

public enum ColorCli {

    //color end string, color reset
    RESET("\033[0m"),
    CLEAR("\033[H\033[2J"),

    //Classici Colori

    GREEN("\033[0;32m"),
    RED("\033[0;31m"),
    YELLOW("\033[0;33m"),
    PINK("\033[0;35m"),
    BLUE("\033[0;34m"),
    BOLDCYAN("\033[1;36m"),
    BOLDWITE("\033[1;37m"),
    BACKGROUND_RED("\033[41m");

    private final String code;

    ColorCli(String code){
        this.code = code;
    }

    @Override
    public String toString(){
        return code;
    }
}