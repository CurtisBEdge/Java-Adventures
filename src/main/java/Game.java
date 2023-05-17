import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Game {


    public Game() {
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
        List<String> commands = new ArrayList<>(Arrays.asList("inspect", "take", "drop"));
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
