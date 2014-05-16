import java.util.Scanner;

public class Round extends Form {

    public int start = 0;

    private char typeOfGame;

    public char getTypeOfGame() {
        return typeOfGame;
    }

    public void registration (IPlayer player1, IPlayer player2) {

        Scanner input= new Scanner(System.in);

        if (player1.getPlayerName() == COMPUTER_NAME) {

            System.out.println("Enter your name:");

            player2.setPlayerName(input.next());


        } else if (player2.getPlayerName() == COMPUTER_NAME) {

            System.out.println("Enter your name:");

            player1.setPlayerName(input.next());


        } else {

            System.out.println("Name of first player:");
            player1.setPlayerName(input.next());
            System.out.println("Hello " + player1.getPlayerName() + "!");
            System.out.println("Name of second player:");
            player2.setPlayerName(input.next());
            System.out.println("Hello " + player2.getPlayerName() + "!");

        }

    }

    public void setMarksForPlayers (IPlayer player1, IPlayer player2) {

        Scanner input= new Scanner(System.in);
        String str;
        System.out.println("Who will playing by X?");
        System.out.println();

        if (player1.getPlayerName() == COMPUTER_NAME || player2.getPlayerName() == COMPUTER_NAME) {

            System.out.println("1. Me");
            System.out.println("2. " + COMPUTER_NAME);
            System.out.println();
            char answer = '0';

            do {

                str = input.next();

                if (str.length() == 1) {

                    char []var = str.toCharArray();

                    answer = var[0];

                    if (!((var[0] == '1' ) || (var[0] == '2'))) {

                        wrongInputMessage();

                    }

                    if (answer == '1') {

                        this.start = 1;
                    }
                    if (answer == '2') {

                        this.start = 2;
                    }

                } else {

                    wrongInputMessage();

                }

            } while(!(answer == '1' || answer == '2'));


        } else {

            System.out.println("1. " + player1.getPlayerName());
            System.out.println("2. " + player2.getPlayerName());
            System.out.println();
            char answer = '0';

            do {

                str = input.next();

                if (str.length() == 1) {

                    char []var = str.toCharArray();

                    answer = var[0];

                    if (!((var[0] == '1' ) || (var[0] == '2'))) {

                        wrongInputMessage();

                    }

                    if (answer == '1') {

                        start = 1;
                    } else {

                        start = 2;

                    }

                } else {

                    wrongInputMessage();

                }

            } while(!(answer == '1' || answer == '2'));

        }

    }

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

                    wrongInputMessage();

                }

            } else {

                wrongInputMessage();

            }

        } while(!(typeOfGame == '1' || typeOfGame == '2'));


    }

    public boolean restartGame() {

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

                    wrongInputMessage();

                }
            } else {

                wrongInputMessage();

            }

        } while(!(ans == 'y' || ans == 'n'));

        if (ans == 'y') {

            return true;

        } else {
            System.out.println("Good bye!");

            return false;

        }


    }

}
