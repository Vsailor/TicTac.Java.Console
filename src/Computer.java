import java.util.Random;

public class Computer extends Mark {

    public void go(Square square) {
        Mark computerMark = new Mark();

        computerMark.setMark(MARK_O);

        if (!weWillHaveWinnerInTheNextStep(square, computerMark)) {

            computerMark.setMark(MARK_X);

            if (!weWillHaveWinnerInTheNextStep(square, computerMark)) {

                computerMark.setMark(MARK_O);

                if (canPutMarkInCenterOfTheMatrix(square)) {

                    putMarkInCenterOfTheMatrix(square, computerMark);

                } else if (canPutMarkInTheConner(square)) {

                    putMarkInTheConnerOfTheMatrix(square, computerMark);

                } else {

                    putMarkInRandomPlace(square);

                }
            }

        }

    }

    private void putMarkInCenterOfTheMatrix (Square square, Mark mark) {

        mark.setLeftCoord('2');
        mark.setTopCoord('b');

        if (square.emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

            mark.putMark();


        }

    }

    private void putMarkInTheConnerOfTheMatrix (Square square, Mark mark) {

        Random rand = new Random(System.currentTimeMillis());

        do {
            switch (rand.nextInt(4)) {

                case 0:
                    mark.setLeftCoord('1');
                    mark.setTopCoord('a');
                    break;
                case 1:
                    mark.setLeftCoord('1');
                    mark.setTopCoord('c');
                    break;
                case 2:
                    mark.setLeftCoord('3');
                    mark.setTopCoord('a');
                    break;
                case 3:
                    mark.setLeftCoord('3');
                    mark.setTopCoord('c');
                    break;
                default:
            }

        } while (!mark.canChooseCell());

        mark.putMark();

    }

    private boolean canPutMarkInTheConner (Square square) {

        if (square.emptyCell('1','a') || square.emptyCell('1','c') || square.emptyCell('3','a') || square.emptyCell('3','c')) {

            return true;

        } else {

            return false;

        }

    }


    private boolean canPutMarkInCenterOfTheMatrix (Square square) {

        if (square.emptyCell('2', 'b')) {

            return true;

        } else {

            return false;

        }

    }

    private void putMarkInRandomPlace (Square square) {

        Mark computerMark = new Mark();
        computerMark.setMark(MARK_O);

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


    private boolean weWillHaveWinnerInTheNextStep(Square square, Mark computerMark) {

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {

                computerMark.setLeftCoord(i);
                computerMark.setTopCoord(j);

                if (computerMark.canChooseCell()) {

                    computerMark.putMark();

                    if (square.winner(computerMark)) {

                        square.clearCell(computerMark.getLeftCoord(), computerMark.getTopCoord());
                        computerMark.setMark(MARK_O);
                        computerMark.putMark();
                        return true;

                    } else {

                        square.clearCell(computerMark.getLeftCoord(), computerMark.getTopCoord());

                    }


                }


            }
        }
        computerMark.setMark(MARK_O);
        return false;

    }




}