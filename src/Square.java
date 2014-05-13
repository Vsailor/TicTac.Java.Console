
import java.util.Scanner;

public class Square extends Form {

    private void eraseLine(int line_number) {

        for (int i=0; i< SIZE_OF_MATRIX; i++){
            matrix[line_number][i] = EMPTY_CELL;
        }

    }

    private boolean playerIsWinner(Mark mark, int count) {

        if (count == WINNER_SCORE) {

            return true;

        } else {

            return false;

        }

    }

    private boolean checkWinInHorisontalAndVerticalLines(Mark mark) {

        int leftLineCount = 0;

        int topLineCount = 0;

        for (int i=0; i<SIZE_OF_MATRIX; i++) {

            for (int k=0; k<SIZE_OF_MATRIX; k++) {

                if (matrix[i][k] == mark.getMark()) {

                    leftLineCount++;

                }

                if (matrix[k][i] == mark.getMark()) {

                    topLineCount++;

                }

                if (playerIsWinner(mark, leftLineCount) || playerIsWinner(mark, topLineCount)) {

                    return true;

                }

            }

            leftLineCount = 0;

            topLineCount = 0;
        }

        return false;

    }


    public void showMatrixLine(int line_number) {

        for (int i=0; i< SIZE_OF_MATRIX; i++){
            System.out.print(matrix[line_number][i]);
        }

    }

    public void eraseMatrix() {

        for (int i=0; i< SIZE_OF_MATRIX; i++) {

            eraseLine(i);

        }

    }

    public void setBorder() {

        for (int i=TOP_AND_LEFT_BORDER_SIZE-1; i< SIZE_OF_MATRIX; i+=2) {

            for (int k=TOP_AND_LEFT_BORDER_SIZE-1; k< SIZE_OF_MATRIX; k++){

                matrix[i][k] = BORDER_MATERIAL;

            }

            for (int k=1; k< SIZE_OF_MATRIX; k++){

                matrix[k][i] = BORDER_MATERIAL;

            }

        }

        char topCoord = FIRST_TOP_COORD;

        for (int i=2; i< SIZE_OF_MATRIX; i+=2) {

            matrix[0][i] = topCoord;
            topCoord++;

        }

        char leftCoord = FIRST_LEFT_COORD;

        for (int i=2; i< SIZE_OF_MATRIX; i+=2) {

            matrix[i][0] = leftCoord;
            leftCoord++;

        }

    }

    public void showMatrix() {

        for (int i=0; i< SIZE_OF_MATRIX; i++) {
            showMatrixLine(i);
            System.out.println();
        }

    }

    public void winMessage(Mark mark) {

        System.out.println("Player " + mark.getMark() + " is winner!");

    }

    private boolean checkWinInDiagonalLines(Mark mark) {

        int count1 = 0;

        for (int i=0; i<SIZE_OF_MATRIX; i++) {

            if (matrix[i][i] == mark.getMark()) {

                count1++;

            }

        }

        int count2 = 0;

        for (int i=SIZE_OF_MATRIX-DOWN_AND_RIGHT_BORDER_SIZE, j=TOP_AND_LEFT_BORDER_SIZE-1; i>=TOP_AND_LEFT_BORDER_SIZE; i--, j++) {

            if (matrix[i][j] == mark.getMark()) {

                count2++;

            }

        }


        if (count1 == WINNER_SCORE || count2 == WINNER_SCORE) {

            return true;

        }   else {

            return false;

        }
    }

    public boolean winner(Mark mark) {

        if (checkWinInHorisontalAndVerticalLines(mark) || checkWinInDiagonalLines(mark)) {

            return true;

        } else {

            return false;

        }
    }

    public boolean endWithoutWinner() {

        for (int i=TOP_AND_LEFT_BORDER_SIZE; i<SIZE_OF_MATRIX; i++) {

            for (int k=TOP_AND_LEFT_BORDER_SIZE; k<SIZE_OF_MATRIX; k++) {

                if (matrix[i][k] == EMPTY_CELL) {

                    return false;

                }

            }


        }

        return true;

    }

    public void endWithoutWinnerMessage() {

        System.out.println("Game over. Winner is absent.");

    }

    public boolean emptyCell(char leftCoord, char topCoord) {

        if (matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == EMPTY_CELL) {

            return true;

        } else {

            return false;

        }
    }

    public void clearCell(char leftCoord, char topCoord) {

        matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] = EMPTY_CELL;

    }

    public char getTypeOfGame() {
        return typeOfGame;
    }

    private char typeOfGame;
    public void hello() {

        String str;

        System.out.println();
        System.out.println("***************************************************************");
        System.out.println("*                                                             *");
        System.out.println("*                            TIC TAC                          *");
        System.out.println("*                                                             *");
        System.out.println("*                             ALPHA                           *");
        System.out.println("*                                                             *");
        System.out.println("***************************************************************");
        System.out.println();
        System.out.println("Choose the type of the game:");
        System.out.println();
        System.out.println("1. Player VS Player");
        System.out.println("2. Player VS Computer");
        System.out.println();
        Scanner input= new Scanner(System.in);
        do {

            str = input.next();
            if (str.length() == 1) {

                char []var = str.toCharArray();
                typeOfGame = var[0];
                if (!((var[0] == '1' ) || (var[0] == '2'))) {

                    System.out.println("Wrong input. Please repeat:");

                }
            } else {

                System.out.println("Wrong input. Please repeat:");

            }

        } while(!(typeOfGame == '1' || typeOfGame == '2'));


    }

    public boolean restart() {

        Scanner input= new Scanner(System.in);
        System.out.println("Do you want to restart the game?[y/n] ");
        String str;
        char ans = 0;
        do {

            str = input.next();
            if (str.length() == 1) {

                char []var = str.toCharArray();
                ans = var[0];
                if (!((var[0] == 'y' ) || (var[0] == 'n'))) {

                    System.out.println("Wrong input. Please repeat: ");

                }
            } else {

                System.out.println("Wrong input. Please repeat: ");

            }

        } while(!(ans == 'y' || ans == 'n'));

        if (ans == 'y') {

            return true;

        } else {

            return false;

        }


    }



}