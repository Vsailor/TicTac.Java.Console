import java.util.Scanner;

public class Main extends Form {
    public static void main(String[] args) {

        Square square = new Square();
        Human human = new Human(MARK_X);
        Computer computer = new Computer(MARK_O);
        square.showMatrix();
        human.go(square);
        square.showMatrix();
        computer.go(square, human);
        square.showMatrix();
        
    }
}