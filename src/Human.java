import java.util.Scanner;

public class Human extends Form implements IPlayer {

    private char mark;

    public Human (char mark) {

        setMark(mark);

    }

    public void setMark (char mark) {

        this.mark = mark;

    };

    public void go (Square square) {

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



    public String playerName = "N/A";

}