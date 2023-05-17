import java.util.Scanner;

public class Main {

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) {
        AreaData.loadAreas();

        System.out.println("Welcome to the world's most boring text adventure game.");
        String input;
        String output;
        do {
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            System.out.println(output);
        } while (!"quit".equals(input));
    }

}
