import java.util.*;
import java.util.stream.Stream;

public class Game {

    public static ArrayList<Area> areas = new ArrayList<>();
    public static int currentLocation = 0;

    public static boolean justArrived = true;

    public static void gameState() throws Exception {
        areas = AreaData.loadAreas();
        if (justArrived) {
            Area foundArea = areas.stream()
                    .filter(area -> currentLocation == area.areaId)
                    .findFirst()
                    .orElseThrow(AreaNotFoundException::new);
            System.out.println(foundArea.getAreaDescription());


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

    public static void parseCommand(List<String> words) {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("sail", "inspect", "take", "drop"));
        List<String> nouns = new ArrayList<>(Arrays.asList("banana", "used-chewing-gum", "gold-coin"));
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
    }

    public String runCommand(String input) {
        List<String> wordList;
        String output = "ok";
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
