import java.util.*;
import java.util.stream.Stream;

public class Game {

    public static ArrayList<Area> areas = new ArrayList<>();
    public static int currentLocation = 0;
    public static boolean justArrived = true;

    public static boolean checkWinState() {
        if (currentLocation == 3) {
            return true;
        } else {
            return false;
        }
    }
    public static Area getGameArea() throws Exception {
        Area foundArea = areas.stream()
                .filter(area -> currentLocation == area.areaId)
                .findFirst()
                .orElseThrow(AreaNotFoundException::new);
        return foundArea;
    }

    public static void gameState() throws Exception {
        areas = AreaData.loadAreas();
        if (justArrived) {
            Area foundArea = getGameArea();
            System.out.println(foundArea.getAreaDescription());
            justArrived = false;


        }

    }

    public static List<String> getWordList(String input) {
        String delims = " \t,.:;?!\"'";
        List<String> words = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, delims);
        while (tokenizer.hasMoreTokens()) {
            words.add(tokenizer.nextToken());
        }
        return words;
    }

    public static void parseCommand(List<String> words) throws Exception {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("sail", "inspect", "take", "drop"));
        List<String> nouns = new ArrayList<>(Arrays.asList("north", "east", "south", "west", "banana", "used-chewing-gum", "gold-coin"));
        if (words.size() > 2) {
            System.out.println("Commands should just be 2 words");
        } else {
            verb = words.get(0);
            if (!commands.contains(verb)) {
                System.out.println(verb + " is not a known verb");
            }
            noun = words.get(1);
            if (!nouns.contains(noun)) {
                System.out.println(noun + " is not a known noun");
            }
        }
        if (words.get(0).equals("sail")) {
            int sailDirection = Sail.sailDirection(words.get(1));
            if (sailDirection == -1) {
                System.out.println("Not a valid direction");
            } else {
                Area foundArea = getGameArea();
                int[] directionOptions = foundArea.getDirectionOptions();
                if (directionOptions[sailDirection] != -1){
                    System.out.println("Aye, Captain!");
                    currentLocation = directionOptions[sailDirection];
                    justArrived = true;
                } else {
                    System.out.println("You can't sail us off the edge of the world, Captain.");
                };
            }
        }
    }

    public String runCommand(String input) throws Exception {
        List<String> wordList;
        String output = "Yes, Captain!";
        String lowerCaseTrimmed = input.trim().toLowerCase();
        if (lowerCaseTrimmed.isBlank()) {
            output = "...Well?";
        } else {
            wordList = getWordList(lowerCaseTrimmed);
            wordList.forEach(System.out::println);
            parseCommand(wordList);
        }

        return output;
    }


}
