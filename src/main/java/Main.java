import java.util.Scanner;

public class Main {

    public static boolean winState = false;

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) throws Exception {
//        Game.loadIslandItems();

        System.out.println("Welcome to the world's most exciting text adventure game.");
        String input;
        String output;
        try {
            Game.loadAreas();
        } catch (Exception e) {
            System.out.println("Fault loading areas");
        }
        Game.loadMap();
        Game.loadIslandItems();
        do {
            Game.printAreaText();
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            winState = Game.checkWinState();
        } while ((!"quit".equals(input)) && (winState == false));
        if (winState == true) {
            System.out.println("Congratulations, you win!");
        }

    }

}
