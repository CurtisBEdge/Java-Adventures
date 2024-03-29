import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

    public static String winState = "playing";

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) throws Exception {
        System.out.println("Treasure At The End Of The Seas!");
        StarterText.starterText();
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
            System.out.println("Now all you have to do is wait for the inevitable sequel.");
        }
        if (winState.equals("supplies")) {
            System.out.println("You've run out of supplies and your crew has mutinied. You're walking the plank.");
            System.out.println("Game Over");
        }
        if (winState.equals("barrier")) {
            System.out.println("You've run aground on the barrier reef. You have a long time to contemplate your mistake as you starve on the reef.");
            System.out.println("Game Over");
        }
        if (winState.equals("boat sank")) {
            System.out.println("You bit off more than you can chew. Say hi to Davy Jones for me.");
            System.out.println("Game Over");
        }
        if (winState.equals("Kraken")) {
            TimeUnit.SECONDS.sleep(2);
            System.out.println("That was unfortunate. Did you do anything to upset someone?");
            System.out.println("Game Over");
        }

    }

}
