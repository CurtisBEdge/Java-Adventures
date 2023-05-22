import java.util.ArrayList;

public class itemData {

    public static ArrayList<Item> loadIsland2Items() {
        ArrayList<Item> island2Items = new ArrayList<>();
        island2Items.add(new Item("Banana"));
        island2Items.add(new Item("Coconut"));
        island2Items.add(new Item("Skull"));

        return island2Items;
    }

    public static ArrayList<Item> loadIsland11Items() {
        ArrayList<Item> island11Items = new ArrayList<>();
        island11Items.add(new Item("Apple"));
        island11Items.add(new Item("Monkey"));
        island11Items.add(new Item("Blunderbuss"));

        return island11Items;
    }

    public static ArrayList<Item> loadIsland14Items() {
        ArrayList<Item> island14Items = new ArrayList<>();
        island14Items.add(new Item("Silver Spoon"));
        island14Items.add(new Item("Parrot"));
        island14Items.add(new Item("Piece of Eight"));

        return island14Items;
    }

    public static ArrayList<Item> loadIsland20Items() {
        ArrayList<Item> island20Items = new ArrayList<>();
        island20Items.add(new Item("Rum"));
        island20Items.add(new Item("Doubloon"));
        island20Items.add(new Item("Treasure Map"));

        return island20Items;
    }

    public static Item loadFalcon() {
        return new Item("Falcon");
    }



}
