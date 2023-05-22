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

    public static boolean area1ShipAttacked = false;
    public static boolean island2FalconTraded = false;
    public static boolean barrierReefRoute = false;



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

    public static void toCheck(List<String> words) {
        if (words.get(1).equals("supplies")) {
            System.out.println("You have " + supplies + " supplies left. Better find the treasure soon!");
        } else if (words.get(1).equals("inventory")) {
            playerInventory.forEach(item -> System.out.println(item.getItemName()) );
        } else {
            System.out.println("I'm not sure what you're trying to accomplish");
        }
    }

    public static void toAttack(List<String> words) {
        if (currentLocation == 1) {
            if (words.get(1).equals("ship")) {
                if (area1ShipAttacked == false) {
                    System.out.println("You mercilessly attack the defenseless trading vessel. There's no riches about, just a few supplies and a statue of a Falcon");
                    supplies = supplies + 2;
                    playerInventory.add(itemData.loadFalcon());
                    area1ShipAttacked = true;
                } else {
                    System.out.println("There are no ships in this area");
                }
            } else {
                System.out.println("You attempt to attack the " + words.get(1) + ", but just end up looking silly. I hope no one was watching");
            }

        }
    }

    public static void toTrade(List<String> words) {
        if ((!playerInventory.stream().anyMatch(item -> item.getItemName().equals(words.get(1))))) {
            System.out.println("You can't trade an item you don't have. You must have dropped it somewhere");
        } else {
            if (currentLocation == 2) {
                if (words.get(1).equals("falcon")) {
                    if (island2FalconTraded == false) {
                        System.out.println("Ah, that's a lovely bird you've got there. I had one just like it years ago.");
                        System.out.println("The pirate you need is on an island to the South East. I doubt he'll help you though, as his monkey recently died in a musket duel.");
                        playerInventory.removeIf(item -> item.getItemName().equals("falcon"));
                        island2FalconTraded = true;
                        System.out.println(island2FalconTraded);
                    }
                } else {
                    System.out.println("The old pirate gives you a funny look and says");
                    System.out.println("'Why would I want that from you!?'");
                }
            }
        }
    }


    public static void parseCommand(List<String> words) throws Exception {
        String verb;
        String noun;
        List<String> commands = new ArrayList<>(Arrays.asList("sail", "take", "check", "attack", "trade"));
        List<String> nouns = new ArrayList<>(Arrays.asList("north", "east", "south", "west", "banana", "used-chewing-gum", "gold-coin", "skull", "supplies", "inventory", "coconut", "falcon", "ship"));
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
        if (words.get(0).equals("check")) {
            toCheck(words);
        }
        if (words.get(0).equals("attack")) {
            toAttack(words);
        }
        if (words.get(0).equals("trade")) {
            toTrade(words);
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
            parseCommand(wordList);
        }

        return output;
    }


    public static void checkForEvents() {
        if (currentLocation == 1) {
            if (area1ShipAttacked == false) {
                System.out.println("There is a very vulnerable looking trading ship nearby, that looks full of potential riches.");
            }
        }
        if (currentLocation == 4) {
            System.out.println("Eventually the storm dies down and you assess the damage. You've lost 5 supplies. You can see islands in the distance to the East and the South");
            supplies = supplies - 5;
        }
        if (currentLocation == 21) {
            System.out.println("When you come to, you're miles away from where you hit the maelstrom. Be more careful in future.");
            System.out.println("An island is directly to your West. The water is looking a little choppy to your East");
            boardWindow.getBoard().setCell(4, 1, CellType.VISITED);
            boardWindow.getBoard().setCell(0, 3, CellType.CURRENT_ROOM);
            supplies = supplies - 2;
            currentLocation = 3;
        }
        if (currentLocation == 2) {
            if (island2FalconTraded == false) {
                System.out.println("A grizzled old pirate subtly gestures for you to come over. He has old scars on his shoulder where it looks like a bird has spent years of perching, but there's no signs of it today.");
                System.out.println("'I hear you're looking for the treasure on Skull Island. I know a pirate you need to speak to, and I'll let you know who if you make it worth my while. ");
            }
        }
        if (currentLocation == 24) {
            if (barrierReefRoute == false) {

            }

        }
    }

}
