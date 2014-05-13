
public class Mark extends Form {

    protected char mark = 'X';

    private char leftCoord;

    private char topCoord;

    public char getTopCoord() {
        return topCoord;
    }

    public char getLeftCoord() {
        return leftCoord;
    }

    public void setLeftCoord(char leftCoord) {

        if (leftCoord>=FIRST_LEFT_COORD && leftCoord<=FIRST_LEFT_COORD+SIZE_OF_MATRIX/2-TOP_AND_LEFT_BORDER_SIZE) {

            this.leftCoord = leftCoord;

        }
    }

    public void setTopCoord(char topCoord) {

        if (topCoord>=FIRST_TOP_COORD && topCoord<=FIRST_TOP_COORD+SIZE_OF_MATRIX/2-TOP_AND_LEFT_BORDER_SIZE){
            this.topCoord = topCoord;
        }

    }

    public char getMark() {
        return mark;
    }

    public void setMark(char mark) {

        if (mark == MARK_X || mark == MARK_O) {

            this.mark = mark;

        } else {
            System.out.println("Wrong mark input.");
        }

    }
    public boolean canChooseCell() {

        if (matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == EMPTY_CELL) {

            return true;

        } else {

            return false;

        }

    }

    public void putMark() {

        if (matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] == EMPTY_CELL) {

            matrix[(leftCoord-FIRST_LEFT_COORD)*2+TOP_AND_LEFT_BORDER_SIZE][(topCoord-FIRST_TOP_COORD)*2+TOP_AND_LEFT_BORDER_SIZE] = mark;

        }
    }

    public void consoleInput(String str) {

        char []string = str.toCharArray();

        setTopCoord(string[0]);

        setLeftCoord(string[1]);

    }

    public boolean cinGood(String str) {
        char []string = str.toCharArray();
        if (str.length()==2) {
            if (string[0] >= FIRST_TOP_COORD && string[0] <= FIRST_TOP_COORD+SIZE_OF_MATRIX/2-TOP_AND_LEFT_BORDER_SIZE) {

                if (string[1] >= FIRST_LEFT_COORD && string[1] <= FIRST_LEFT_COORD+SIZE_OF_MATRIX/2-DOWN_AND_RIGHT_BORDER_SIZE) {

                    return true;

                } else {

                    System.out.println("Wrong input. Please, repeat your input:");
                    return false;

                }
            } else {

                System.out.println("Wrong input. Please, repeat your input:");
                return false;
            }

        } else {

            System.out.println("Wrong input. Please, repeat your input:");
            return false;
        }


    }

}