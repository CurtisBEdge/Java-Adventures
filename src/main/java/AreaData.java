import java.util.ArrayList;

public class AreaData {

    public static ArrayList<Area> loadAreas() {
        ArrayList<Area> areas = new ArrayList<>();

//        Direction order North, East, South then West.

        areas.add(new Area(0, "You're on the open sea. You can see an island in the distance to the East.", new int[]{-1, 1, 5, -1}, 0, 0));
        areas.add(new Area(1, "You're on the open sea. An island is directly to your East and another in the distance to the South.", new int[]{-1, 2, 6, 0}, 0, 1));
        areas.add(new Area(2, "You're on Scumm Island", new int[]{-1, 3, 7, 1}, 0, 2));
        areas.add(new Area(3, "You're on the open sea. An island is directly to your West. The water is looking a little choppy to your East.", new int[]{-1, 4, 8, 2}, 0, 3));
        areas.add(new Area(4, "You've hit a storm. The waves throw your ship around as if it's a toy.", new int[]{-1, -1, 9, 3}, 0, 4));
        areas.add(new Area(5, "You're on the open sea. An island is directly to your South East.", new int[]{0, 6, 10, -1}, 1, 0));
        areas.add(new Area(6, "You're on the open sea. An island is directly to your South and another to your North East.", new int[]{1, 7, 11, 5}, 1, 1));
        areas.add(new Area(7, "You're on the open sea. An island is directly to your North and another to your South West.", new int[]{2, 8, 12, 6}, 1, 2));
        areas.add(new Area(8, "You're on the open sea. Islands are directly to your North West and South East.", new int[]{3, 9, 13, 7}, 1, 3));
        areas.add(new Area(9, "You're on the open sea. An island is directly to your South.", new int[]{4, -1, 14, 8}, 1, 4));
        areas.add(new Area(10, "You're on the open sea. An island is directly to your East and another in the distance to the South.", new int[]{5, 11, 15, -1}, 2, 0));
        areas.add(new Area(11, "You're on Golden Acres Island. A retirement island for old pirates", new int[]{6, 12, 16, 10}, 2, 1));
        areas.add(new Area(12, "You're on the open sea. An island is directly to your West others in the distance to the North and East.", new int[]{7, 13, 17, 11}, 2, 2));
        areas.add(new Area(13, "You're on the open sea. An island is directly to your East and another in the distance to the West.", new int[]{8, 14, 18, 12}, 2, 3));
        areas.add(new Area(14, "You're on Monkey Island. No secrets here.", new int[]{9, -1, 19, 13}, 2, 4));
        areas.add(new Area(15, "You're on the open sea. An island is directly to your South another to the North East", new int[]{10, 16, 20, -1}, 3, 0));
        areas.add(new Area(16, "You're on the open sea. Islands are directly to your North and your South West", new int[]{11, 17, 21, 15}, 3, 1));
        areas.add(new Area(17, "You're on the open sea. An island is directly to your North West", new int[]{12, 18, 22, 16}, 3, 2));
        areas.add(new Area(18, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{13, 19, 23, 17}, 3, 3));
        areas.add(new Area(19, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{14, -1, 24, 18}, 3, 4));
        areas.add(new Area(20, "You're on Scabb Island", new int[]{15, 21, -1, -1}, 4, 0));
        areas.add(new Area(21, "You've sailed straight into a whirling maelstrom. You desperately steer the ship away, but you get pulled in. Everything goes black.", new int[]{16, 22, -1, 20}, 4, 1));
        areas.add(new Area(22, "You're on the open sea. An island is in the distance to your East", new int[]{17, 23, -1, 21}, 4, 2));
        areas.add(new Area(23, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{18, 24, -1, 22}, 4, 3));
        areas.add(new Area(24, "You've found Skull Island. Here be buried treasure! Yar!", new int[]{19, -1, -1, 23}, 4, 4));

        return areas;
    }
}