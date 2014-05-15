import java.util.Random;

public class Computer extends Form implements IPlayer {

    private char mark;

    public Computer (char mark) {

        setMark(mark);

    }

    public Computer () {}

    private boolean canPutMarkInTheCenterOfTheMatrix (Square square) {

        if (square.emptyCell('2', 'b')) {

            return true;

        } else {

            return false;

        }

    }

    private void putMarkInCenterOfTheMatrix (Square square, Mark mark) {

        mark.setLeftCoord('2');
        mark.setTopCoord('b');

        if (square.emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

            square.putMark(mark);

        }

    }


    private boolean canPutMarkInTheConnerOfTheMatrix (Square square) {

        if (square.emptyCell('1','a') || square.emptyCell('1','c') || square.emptyCell('3','a') || square.emptyCell('3','c')) {

            return true;

        } else {

            return false;

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

        } while (!square.emptyCell(mark.getLeftCoord(),mark.getTopCoord()));

        square.putMark(mark);

    }



    private void putMarkInTheRandomPlace (Square square, Mark mark) {

        Random rand = new Random(System.currentTimeMillis());

        do {

            switch (rand.nextInt(3)) {

                case 0:
                    mark.setLeftCoord('1');
                    break;
                case 1:
                    mark.setLeftCoord('2');
                    break;
                case 2:
                    mark.setLeftCoord('3');
                    break;
                default:
            }

            switch (rand.nextInt(3)) {

                case 0:
                    mark.setTopCoord('a');
                    break;
                case 1:
                    mark.setTopCoord('b');
                    break;
                case 2:
                    mark.setTopCoord('c');
                    break;
                default:
            }
        } while (!square.emptyCell(mark.getLeftCoord(),mark.getTopCoord()));

        square.putMark(mark);

    }


    private boolean playerWillBeWinnerInTheNextStep (Square square, IPlayer player) {

        Mark mark = new Mark(player.getMark());

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {

                mark.setLeftCoord(i);
                mark.setTopCoord(j);

                if (square.emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

                    square.putMark(mark);

                    if (square.winner(player)) {

                        square.clearCell(mark.getLeftCoord(), mark.getTopCoord());

                        return true;

                    } else {

                        square.clearCell(mark.getLeftCoord(), mark.getTopCoord());

                    }


                }


            }
        }

        return false;

    }

    private void blockCellThatPlayerWillNotBeWinnerInTheNextStep (Square square, Human human) {

        Mark mark = new Mark(human.getMark());

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {

                mark.setLeftCoord(i);
                mark.setTopCoord(j);

                if (square.emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

                    square.putMark(mark);

                    if (square.winner(human)) {

                        square.clearCell(mark.getLeftCoord(), mark.getTopCoord());

                        if (human.getMark() == MARK_X) {

                            mark.setMark(MARK_O);

                        } else {

                            mark.setMark(MARK_X);

                        }


                        square.putMark(mark);

                        return;


                    } else {

                        square.clearCell(mark.getLeftCoord(), mark.getTopCoord());

                    }


                }


            }
        }

    }


    private void chooseCellToWinInTheNextStep (Square square, IPlayer player) {

        Mark mark = new Mark(player.getMark());

        for (char i=FIRST_LEFT_COORD; i<FIRST_LEFT_COORD + STRINGS_MATRIX_COUNT; i++) {

            for (char j=FIRST_TOP_COORD; j<FIRST_TOP_COORD + STRINGS_MATRIX_COUNT; j++) {

                mark.setLeftCoord(i);
                mark.setTopCoord(j);

                if (square.emptyCell(mark.getLeftCoord(), mark.getTopCoord())) {

                    square.putMark(mark);

                    if (!square.winner(player)) {

                        square.clearCell(mark.getLeftCoord(), mark.getTopCoord());

                    } else {

                        return;

                    }


                }


            }
        }

    }


    public void setMark (char mark) {

        this.mark = mark;

    }

    public char getMark () {

        return mark;

    };

    public void go (Square square, Human human) {

        Mark humanMark = new Mark(human.getMark());

        Mark computerMark = new Mark(this.getMark());

        if (playerWillBeWinnerInTheNextStep(square, this)) {

            chooseCellToWinInTheNextStep(square, this);
            return;

        }

        if (playerWillBeWinnerInTheNextStep(square, human)) {

            blockCellThatPlayerWillNotBeWinnerInTheNextStep(square, human);
            return;

        }

        computerMark.setLeftCoord('2');
        computerMark.setTopCoord('b');

        if (square.emptyCell(computerMark.getLeftCoord(), computerMark.getTopCoord())) {

            square.putMark(computerMark);

            return;

        }

        if (square.emptyCell('1', 'a') || square.emptyCell('1', 'c') || square.emptyCell('3', 'a') || square.emptyCell('3', 'c')) {

            putMarkInTheConnerOfTheMatrix(square, computerMark);
            return;

        }

        putMarkInTheRandomPlace(square, computerMark);


    }

}