import java.util.Scanner;

public class Human extends Form implements IPlayer {

    private String playerName = "Player";

    public void setPlayerName (String playerName) {
        this.playerName = playerName;
    }

    public String getPlayerName () {
        return playerName;
    }

    private char mark;

    public Human (char mark) {

        this.mark = mark;

    }

    public Human () {}

    public void setMark (char mark) {

        this.mark = mark;

    };

    public void go (Square square, Round round) {

        Mark playerMark = new Mark(mark);
        Scanner input= new Scanner(System.in);
        String str;

        do {
            do {

                str = input.next();
                playerMark.consoleInput(str);

            } while(!playerMark.cinGood(str));

            if (!square.emptyCell(playerMark.getLeftCoord(), playerMark.getTopCoord())) {

                notEmptyCellMessage();

            }

        } while (!square.emptyCell(playerMark.getLeftCoord(), playerMark.getTopCoord()));

        square.putMark(playerMark);


    };

    public char getMark () {

        return mark;

    };


}