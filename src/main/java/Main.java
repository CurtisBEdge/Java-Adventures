import java.util.Scanner;

public class Main {

    public static boolean winState = false;
    public static boolean hasSupplies = true;

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) throws Exception {

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
            Game.checkForEvents();
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            winState = Game.checkWinState();
            hasSupplies = Game.checkSupplies();
        } while ((!"quit".equals(input)) && (winState == false) && (hasSupplies == true));
        if (winState == true) {
            System.out.println("Congratulations, you found the treasure! You're a real pirate now!");
        }
        if (hasSupplies == false) {
            System.out.println("You've run out of supplies and your crew has mutinied. You're walking the plank.");
        }

    }

}
