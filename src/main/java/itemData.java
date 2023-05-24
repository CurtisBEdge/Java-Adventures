import java.util.ArrayList;

public class itemData {

    public static ArrayList<Item> loadIsland2Items() {
        ArrayList<Item> island2Items = new ArrayList<>();
        island2Items.add(new Item("banana"));
        island2Items.add(new Item("coconut"));
        island2Items.add(new Item("skull"));

        return island2Items;
    }

    public static ArrayList<Item> loadIsland11Items() {
        ArrayList<Item> island11Items = new ArrayList<>();
        island11Items.add(new Item("apple"));
        island11Items.add(new Item("blunderbuss"));

        return island11Items;
    }

    public static ArrayList<Item> loadIsland14Items() {
        ArrayList<Item> island14Items = new ArrayList<>();
        island14Items.add(new Item("spoon"));
        island14Items.add(new Item("parrot"));
        island14Items.add(new Item("conch"));

        return island14Items;
    }

    public static ArrayList<Item> loadIsland20Items() {
        ArrayList<Item> island20Items = new ArrayList<>();
        island20Items.add(new Item("rum"));
        island20Items.add(new Item("doubloon"));

        return island20Items;
    }

    public static Item loadFalcon() {
        return new Item("falcon");
    }

    public static Item loadMonkey() {
        return new Item("monkey");
    }

    public static Item loadMap() {return new Item("map");}
}
