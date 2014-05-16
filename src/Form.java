abstract public class Form {

    protected static final int SIZE_OF_MATRIX = 8;

    protected static final char BORDER_MATERIAL = '#';

    protected static final char EMPTY_CELL = ' ';

    protected static char[][] matrix = new char[SIZE_OF_MATRIX][SIZE_OF_MATRIX];

    protected static final char FIRST_TOP_COORD = 'a';

    protected static final char FIRST_LEFT_COORD = '1';

    protected static final char MARK_X = 'X';

    protected static final char MARK_O = 'O';

    protected static final int WINNER_SCORE = 3;

    protected static final int STRINGS_MATRIX_COUNT = 3;

    protected static final int TOP_AND_LEFT_BORDER_SIZE = 2;

    protected static final int DOWN_AND_RIGHT_BORDER_SIZE = 1;

    protected static final String COMPUTER_NAME = "Computer";

    protected static final void wrongInputMessage () {

        System.out.println("Wrong input. Please, repeat input.");

    }

    protected static final void notEmptyCellMessage () {

        System.out.println("This cell isn't empty. Please, repeat input.");

    }

}