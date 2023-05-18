import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Main {

    public static boolean winState = false;

    private static Scanner sc = new Scanner(System.in);

    private static Game game = new Game();


    public static void main(String[] args) throws Exception {
        AreaData.loadAreas();

        System.out.println("Welcome to the world's most exciting text adventure game.");
        String input;
        String output;
        do {
            try {
                System.out.println(winState);
                Game.gameState();
            } catch (Exception e) {
                System.out.println("You're in Davy Jones' locker. Game Over!");
            }
            System.out.print("> ");
            input = sc.nextLine();
            output = game.runCommand(input);
            winState = Game.checkWinState();
        } while ((!"quit".equals(input)) && (winState == false));
        System.out.println("Congratulations, you win!");
    }

}
