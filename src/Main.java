import java.util.Scanner;

public class Main extends Form {
    public static void main(String[] args) {

        Round round;

        do {
            round = new Round();
            Square square = new Square();
            round.hello();
            IPlayer player1 = new Human();
            IPlayer player2;
            if (round.getTypeOfGame() == '2') {

                player2 = new Computer();

            } else {

                player2 = new Human();

            }
            round.registration(player1,player2);
            round.setMarksForPlayers(player1, player2);

            if (round.start == 1) {
                player1.setMark(MARK_X);
                player2.setMark(MARK_O);

            } else {

                player1.setMark(MARK_O);
                player2.setMark(MARK_X);

            }
            square.showMatrix();
            while (true) {

                if (round.start == 1) {
                    player1.go(square,round);
                    square.showMatrix();
                    if (square.winner(player1)) {

                        square.winMessage(player1);
                        break;
                    }

                    if (square.endWithoutWinner()) {

                        square.endWithoutWinnerMessage();
                        break;

                    }
                    round.start = 2;
                } else {
                    player2.go(square, round);
                    square.showMatrix();
                    if (square.winner(player2)) {

                        square.winMessage(player2);
                        break;
                    }

                    if (square.endWithoutWinner()) {

                        square.endWithoutWinnerMessage();
                        break;

                    }
                    round.start = 1;
                }


            }
        } while (round.restartGame());
    }
}