import java.util.Random;

public class Computer extends Mark {

    public void go(Square square) {

        putMarkForCheck(square);

    }

    private void putMarkForCheck(Square square) {

        Mark computerMark = new Mark();
        computerMark.setMark(MARK_X);

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {

                computerMark.setLeftCoord(i);
                computerMark.setTopCoord(j);

                if (computerMark.canChooseCell()) {

                    computerMark.putMark();

                    if (square.winner(computerMark)) {

                        square.clearCell(computerMark.getLeftCoord(), computerMark.getTopCoord());
                        computerMark.setMark('O');
                        computerMark.putMark();
                        return;

                    } else {

                        square.clearCell(computerMark.getLeftCoord(), computerMark.getTopCoord());

                    }


                }


            }
        }

        Random rand = new Random(System.currentTimeMillis());
        do {

            switch (rand.nextInt(3)) {

                case 0:
                    computerMark.setLeftCoord('1');
                    break;
                case 1:
                    computerMark.setLeftCoord('2');
                    break;
                case 2:
                    computerMark.setLeftCoord('3');
                    break;
                default:
            }

            switch (rand.nextInt(3)) {

                case 0:
                    computerMark.setTopCoord('a');
                    break;
                case 1:
                    computerMark.setTopCoord('b');
                    break;
                case 2:
                    computerMark.setTopCoord('c');
                    break;
                default:
            }
        } while(!computerMark.canChooseCell());

        computerMark.setMark(MARK_O);
        computerMark.putMark();


    }




}