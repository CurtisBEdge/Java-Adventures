import java.util.*;

public class Game {

    public static ArrayList<Area> areas = new ArrayList<>();
    public static int currentLocation = 0;
    public static boolean justArrived = true;

    public static Board board1 = new Board(2,2);

    public static BoardWindow boardWindow = new BoardWindow(board1, "My Example Board", 100);

    public static boolean checkWinState() {
        return currentLocation == 6;
    }

    public static Area getGameArea() throws Exception {
        Area foundArea = areas.stream()
                .filter(area -> currentLocation == area.areaId)
                .findFirst()
                .orElseThrow(AreaNotFoundException::new);
        foundArea.setHasVisited();
        return foundArea;
    }

    public static void loadMap() {
        boardWindow.getBoard().setCell(0, 0, CellType.START);
    }

    public static void loadAreas() {
        areas = AreaData.loadAreas();
    }

    public static void printAreaText() throws Exception {
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
        if (words.size() != 2) {
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
                    justArrived = true;
                    boardWindow.getBoard().setCell(foundArea.getRowPosition(), foundArea.getColumnPosition(), CellType.VISITED);
                    currentLocation = directionOptions[sailDirection];
                    Area newArea = getGameArea();
                    boardWindow.getBoard().setCell(newArea.getRowPosition(), newArea.getColumnPosition(), CellType.CURRENT_ROOM);
                    boardWindow.repaint();
                } else {
                    System.out.println("You can't sail us off the edge of the world, Captain.");
                }
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
//            wordList.forEach(System.out::println);
            parseCommand(wordList);
        }

        return output;
    }


}
