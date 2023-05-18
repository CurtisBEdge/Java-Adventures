public class Sail {

    public static int sailDirection(String args) {
        if (args.equals("north")) {
            return 0;
        }
        if (args.equals("east")) {
            return 1;
        }
        if (args.equals("south")) {
            return 2;
        }
        if (args.equals("west")) {
            return 3;
        } else {
            return -1;
        }
    }
}
