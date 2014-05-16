import java.util.Scanner;

public class Main extends Form {
    public static void main(String[] args) {

        Round round;

        do {
            round = new Round();
            Square square = new Square();
            round.hello();
            if (round.getTypeOfGame() == '2') {
                Computer computer = new Computer();
                Human human= new Human();
                round.registration(human,computer);
                round.setMarksForPlayers(human, computer);

                if (round.start == 1) {
                    human.setMark(MARK_X);
                    computer.setMark(MARK_O);

                } else {

                    human.setMark(MARK_O);
                    computer.setMark(MARK_X);

                }
                square.showMatrix();
                while (true) {

                    if (round.start == 1) {
                        human.go(square,round);
                        if (square.winner(human)) {

                            square.winMessage(human);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }
                        computer.go(square, round);
                        square.showMatrix();
                        if (square.winner(computer)) {

                            square.winMessage(computer);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }
                    } else {

                        computer.go(square,round);
                        square.showMatrix();
                        if (square.winner(computer)) {

                            square.winMessage(computer);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }
                        human.go(square, round);
                        square.showMatrix();
                        if (square.winner(human)) {

                            square.winMessage(human);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }
                    }


                }

            } else {

                Human player1 = new Human();
                Human player2 = new Human();
                round.registration(player1, player2);
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
                    } else {

                        player2.go(square,round);
                        square.showMatrix();
                        if (square.winner(player2)) {

                            square.winMessage(player2);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }

                        player1.go(square, round);
                        square.showMatrix();
                        if (square.winner(player1)) {

                            square.winMessage(player1);
                            break;
                        }

                        if (square.endWithoutWinner()) {

                            square.endWithoutWinnerMessage();
                            break;

                        }
                    }

                }

            }
        } while (round.restartGame());
    }
}