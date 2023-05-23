import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class StarterText {

    public static void starterText() {
        List<String> starterText = new ArrayList<>();
        starterText.add("Welcome to the high seas in the Golden Age of Pirates.");
        starterText.add("You're sat quietly drinking in a Tavern on a remote island. There is a ruckus, and a large pirate drops dead in front of you.");
        starterText.add("Being a pirate yourself, the first thing you notice is a treasure map clutched in his dying hand. Before thinking, you grab the map and head back to your ship.");
        starterText.add("The map shows details of a buried treasure on Skull Island, but you don't know where it is. You must sail the seas and find more clues to guide you to the treasure.");
        starterText.add("Off you go on your journey with your capable crew!");
        starterText.add("To move around, just SAIL in a Compass Direction. You can then ATTACK, or TAKE, or TRADE anything you want. You have limited time though, so don't dally.");
        starterText.add("Anytime you can CHECK what you have in your INVENTORY or how many SUPPLIES remain on your ship. If you find a likely location, maybe you can GATHER more");


        starterText.forEach(text ->
                {
                    for (int i = 0; i < text.length(); i++) {
                        System.out.print(text.charAt(i));
                        try {
                            TimeUnit.MILLISECONDS.sleep(25);
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    System.out.println();
                }
        );
    }
}
