import java.util.Scanner;

public class Square extends Form {

    public Square() {

        for (int i=0; i< SIZE_OF_MATRIX; i++) {

            eraseLine(i);

        }

        setBorder();

    }

    private void eraseLine (int line_number) {

        for (int i=0; i< SIZE_OF_MATRIX; i++){
            matrix[line_number][i] = EMPTY_CELL;
        }

    }

    private boolean winnerScore (int count) {

        if (count == WINNER_SCORE) {

            return true;

        } else {

            return false;

        }

    }

    private void setBorder() {

        for (int i=TOP_AND_LEFT_BORDER_SIZE-1; i< SIZE_OF_MATRIX; i+=2) {

            for (int k=TOP_AND_LEFT_BORDER_SIZE-1; k< SIZE_OF_MATRIX; k++) {

                matrix[i][k] = BORDER_MATERIAL;

            }

            for (int k=TOP_AND_LEFT_BORDER_SIZE; k< SIZE_OF_MATRIX; k++) {

                matrix[k][i] = BORDER_MATERIAL;

            }

        }

        char topCoord = FIRST_TOP_COORD;

        for (int i=TOP_AND_LEFT_BORDER_SIZE; i< SIZE_OF_MATRIX; i+=2) {

            matrix[0][i] = topCoord;
            topCoord++;

        }

        char leftCoord = FIRST_LEFT_COORD;

        for (int i=TOP_AND_LEFT_BORDER_SIZE; i< SIZE_OF_MATRIX; i+=2) {

            matrix[i][0] = leftCoord;
            leftCoord++;

        }

    }

    public int countOfMarks (char mark) {

        int count = 0;


        for (int i=0; i<SIZE_OF_MATRIX; i++) {

            for (int k=0; k<SIZE_OF_MATRIX; k++) {

                if (matrix[i][k] == mark) {

                    count++;

                }



            }
        }

        return count;

    }

    private boolean checkWinInHorizontalAndVerticalLines (IPlayer player) {

        int leftLineCount = 0;

        int topLineCount = 0;

        for (int i=0; i<SIZE_OF_MATRIX; i++) {

            for (int k=0; k<SIZE_OF_MATRIX; k++) {

                if (matrix[i][k] == player.getMark()) {

                    leftLineCount++;

                }

                if (matrix[k][i] == player.getMark()) {

                    topLineCount++;

                }

                if (winnerScore(leftLineCount) || winnerScore(topLineCount)) {

                    return true;

                }

            }

            leftLineCount = 0;

            topLineCount = 0;
        }

        return false;

    }


    private boolean checkWinInDiagonalLines (IPlayer player) {

        int count1 = 0;

        for (int i=0; i<SIZE_OF_MATRIX; i++) {

            if (matrix[i][i] == player.getMark()) {

                count1++;

            }

        }

        int count2 = 0;

        for (int i=SIZE_OF_MATRIX-DOWN_AND_RIGHT_BORDER_SIZE, j=TOP_AND_LEFT_BORDER_SIZE-1; i>=TOP_AND_LEFT_BORDER_SIZE; i--, j++) {

            if (matrix[i][j] == player.getMark()) {

                count2++;

            }

        }


        if (count1 == WINNER_SCORE || count2 == WINNER_SCORE) {

            return true;

        }   else {

            return false;

        }
    }

    private boolean playerWillBeWinnerInTheNextStep (IPlayer player) {

        Mark mark = new Mark(player.getMark());

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {


                mark.setLeftCoord(i);
                mark.setTopCoord(j);


                if (emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

                    putMark(mark);

                    if (winner(player)) {

                        clearCell(mark.getLeftCoord(), mark.getTopCoord());

                        return true;

                    } else {

                        clearCell(mark.getLeftCoord(), mark.getTopCoord());

                    }


                }


            }
        }

        return false;

    }


    private void showMatrixLine (int line_number) {

        for (int i=0; i< SIZE_OF_MATRIX; i++) {

            System.out.print(matrix[line_number][i]);

        }

    }


    public void showMatrix () {

        for (int i=0; i< SIZE_OF_MATRIX; i++) {

            showMatrixLine(i);
            System.out.println();

        }

    }

    public void winMessage (IPlayer player) {

        System.out.print(player.getPlayerName() + " is winner!");

    }


    public boolean winner (IPlayer player) {

        if (checkWinInHorizontalAndVerticalLines(player) || checkWinInDiagonalLines(player)) {

            return true;

        } else {

            return false;

        }

    }

    public boolean belongs (Mark mark, char leftCoord, char topCoord) {

        if (matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == mark.getMark()) {

            return true;

        }
        return false;


    }

    public boolean endWithoutWinner () {

        for (int i=TOP_AND_LEFT_BORDER_SIZE; i<SIZE_OF_MATRIX; i++) {

            for (int k=TOP_AND_LEFT_BORDER_SIZE; k<SIZE_OF_MATRIX; k++) {

                if (matrix[i][k] == EMPTY_CELL) {

                    return false;

                }

            }


        }

        return true;

    }


    public void endWithoutWinnerMessage () {

        System.out.println("Game over. Winner is absent.");

    }


    public boolean emptyCell (char leftCoord, char topCoord) {

        if (matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == EMPTY_CELL) {

            return true;

        } else {

            return false;

        }
    }


    public void clearCell(char leftCoord, char topCoord) {

        matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] = EMPTY_CELL;

    }


    public void putMark (Mark mark) {

        if (matrix[(mark.getLeftCoord()-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(mark.getTopCoord()-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == EMPTY_CELL) {

            matrix[(mark.getLeftCoord()-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(mark.getTopCoord()-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] = mark.getMark();

        }

    }

}