import java.util.*;

public class Game {

    public static ArrayList<Area> areas;
    public static int supplies = 20;
    public static boolean checkSupplies() {
        return (supplies > 0);
    }

    public static ArrayList<Item> playerInventory = new ArrayList<>();
    public static ArrayList<Item> island2Inventory;
    public static ArrayList<Item> island11Inventory;
    public static ArrayList<Item> island14Inventory;
    public static ArrayList<Item> island20Inventory;



    public static int currentLocation = 0;
    public static boolean justArrived = true;

    public static Board board1 = new Board(5,5);

    public static BoardWindow boardWindow = new BoardWindow(board1, "My Example Board", 100);

    public static boolean checkWinState() {
        return currentLocation == 24;
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

    public static void loadIslandItems() {
        island2Inventory = itemData.loadIsland2Items();
        island11Inventory = itemData.loadIsland11Items();
        island14Inventory = itemData.loadIsland14Items();
        island20Inventory = itemData.loadIsland20Items();
    }

    public static void printAreaText() throws Exception {
        if (justArrived) {
            Area foundArea = getGameArea();
            System.out.println(foundArea.getAreaDescription());
            listInventory();
            justArrived = false;
        }
    }

    public static void listInventory() {
        if (currentLocation == 2) {
            System.out.println("You can see...");
            island2Inventory.forEach((item) -> System.out.println(item.getItemName()) );
        } else if (currentLocation == 11) {
            System.out.println("You can see...");
            island11Inventory.forEach((item) -> System.out.println(item.getItemName()) );
        } else if (currentLocation == 14) {
            System.out.println("You can see...");
            island14Inventory.forEach((item) -> System.out.println(item.getItemName()) );
        } else if (currentLocation == 20) {
            System.out.println("You can see...");
            island20Inventory.forEach((item) -> System.out.println(item.getItemName()) );
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

    public static void toSail(List<String> words ) throws Exception {
        int sailDirection = Sail.sailDirection(words.get(1));
        if (sailDirection == -1) {
            System.out.println("Not a valid direction");
        } else {
            Area foundArea = getGameArea();
            int[] directionOptions = foundArea.getDirectionOptions();
            if (directionOptions[sailDirection] != -1){
                System.out.println("Aye, Captain!");
                justArrived = true;
                supplies--;
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

    public static void toTake(List<String> words) {
        ArrayList<Item> currentLocationInventory;
        if (currentLocation == 2) {
            currentLocationInventory = island2Inventory;
        } else if (currentLocation == 11) {
            currentLocationInventory = island11Inventory;
        } else if (currentLocation == 14) {
            currentLocationInventory = island14Inventory;
        } else if (currentLocation == 20) {
            currentLocationInventory = island20Inventory;
        } else {
            currentLocationInventory = new ArrayList<>();
        }
        System.out.println(words.get(1));

        currentLocationInventory.forEach((item) -> System.out.println(item.getItemName())  );


        try {
            Item takenItem = currentLocationInventory.stream()
                    .filter(item -> words.get(1).equals(item.getItemName().toLowerCase()))
                    .findFirst()
                    .orElseThrow(()-> new ItemNotFoundException());
            playerInventory.add(takenItem);
            currentLocationInventory.remove(takenItem);
        } catch (ItemNotFoundException e) {
            System.out.println("There is no " + words.get(1) + " here.");
        }
    }


    public static void parseCommand(List<String> words) throws Exception {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("sail", "inspect", "take", "drop"));
        List<String> nouns = new ArrayList<>(Arrays.asList("north", "east", "south", "west", "banana", "used-chewing-gum", "gold-coin", "skull"));
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
            toSail(words);
        }
        if (words.get(0).equals("take")) {
            toTake(words);
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
