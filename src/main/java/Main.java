import java.util.ArrayList;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;
import java.util.List;

public class Main {

    public static String winState = "playing";
//    public static boolean hasSupplies = true;
//
//    public static boolean barrierPass = false;

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) throws Exception {
//        StarterText.starterText();
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
            Game.checkForEvents();
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            winState = Game.checkWinState();
        } while ((!"quit".equals(input)) && (winState.equals("playing")));
        if (winState.equals("win")) {
            System.out.println("Congratulations, you found the treasure! You're a real pirate now!");
        }
        if (winState.equals("supplies")) {
            System.out.println("You've run out of supplies and your crew has mutinied. You're walking the plank.");
            System.out.println("Game Over");
        }
        if (winState.equals("barrier")) {
            System.out.println("You've run aground on the barrier reef. You have a long time to contemplate your mistake as you starve on the reef.");
            System.out.println("Game Over");
        }

    }

}
