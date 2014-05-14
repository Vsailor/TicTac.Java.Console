import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Square square = new Square();
        square.eraseMatrix();
        square.setBorder();

        Mark mark = new Mark();

        mark.setMark('X');

        Scanner input= new Scanner(System.in);
        String str;
        Computer computer = new Computer();
        computer.setMark('O');

        square.hello();
        square.showMatrix();
        while (true) {

            while (true) {

                do {

                    do {
                        System.out.println(mark.getMark() +" is expected. Type the cell:");
                        str = input.next();

                    } while (!mark.cinGood(str));

                    mark.consoleInput(str);
                    if (!mark.canBeChoosen()) {

                        System.out.println("This cell isn't empty");

                    }
                } while (!mark.canBeChoosen());

                mark.putMark();


                if (square.endWithoutWinner()) {
                    square.showMatrix();
                    square.endWithoutWinnerMessage();
                    break;

                }

                if (square.winner(mark)) {
                    square.showMatrix();
                    square.winMessage(mark);
                    break;

                }

                if (square.getTypeOfGame() == '1') {
                    if (mark.getMark() == 'X') {

                        mark.setMark('O');

                    }   else {

                        mark.setMark('X');

                    }
                } else {

                    computer.go(square);

                    if (square.endWithoutWinner()) {
                        square.showMatrix();
                        square.endWithoutWinnerMessage();

                        break;

                    }

                    if (square.winner(computer)) {

                        square.showMatrix();
                        square.winMessage(computer);

                        break;

                    }
                }

                square.showMatrix();

            }

            if(!square.restartGame()) {

                System.out.println("Good bye!");
                return;

            } else {
                square.hello();
                square.eraseMatrix();
                square.setBorder();

                mark = new Mark();

                mark.setMark('X');
                computer = new Computer();
                computer.setMark('O');
                square.showMatrix();

            }

        }


    }
}