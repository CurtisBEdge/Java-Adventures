import java.util.ArrayList;

public class AreaData {

    public static ArrayList<Area> loadAreas() {
        ArrayList<Area> areas = new ArrayList<>();

//        Direction order North, East, South then West.

        areas.add(new Area(0, "You're on the open sea. You can see an island in the distance to the East.", new int[]{-1, 1, 2, -1}, 0, 0));
        areas.add(new Area(1, "You're on the open sea. An island is directly to your East", new int[]{-1, 2, 6, 0}, 0, 1));
        areas.add(new Area(2, "You're on Island 2", new int[]{-1, 3, 7, 1}, 0, 2));
        areas.add(new Area(3, "You're on the open sea. An island is directly to your West", new int[]{-1, 4, 8, 2}, 0, 3));
        areas.add(new Area(4, "You're on the open sea. You can see islands in the distance to the East and the South", new int[]{-1, -1, 9, 3}, 0, 4));
        areas.add(new Area(5, "You're on the open sea. An island is to your South East", new int[]{0, 6, 10, -1}, 1, 0));
        areas.add(new Area(6, "You're on the open sea. An island is directly to your South and another to your North East", new int[]{1, 7, 11, 5}, 1, 1));
        areas.add(new Area(7, "You're on the open sea. An island is directly to your North and another to your South West", new int[]{2, 8, 12, 6}, 1, 2));
        areas.add(new Area(8, "This is the first area 0", new int[]{3, 9, 13, 7}, 1, 3));
        areas.add(new Area(9, "This is the second area 1", new int[]{4, -1, 14, 8}, 1, 4));
        areas.add(new Area(10, "This is the third area 2", new int[]{5, 11, 15, -1}, 2, 0));
        areas.add(new Area(11, "This is the fourth area 3", new int[]{6, 12, 16, 10}, 2, 1));
        areas.add(new Area(12, "This is the first area 0", new int[]{7, 13, 17, 11}, 2, 2));
        areas.add(new Area(13, "This is the second area 1", new int[]{8, 14, 18, 12}, 2, 3));
        areas.add(new Area(14, "You're on Island 14", new int[]{9, -1, 19, 13}, 2, 4));
        areas.add(new Area(15, "This is the fourth area 3", new int[]{10, 16, 20, -1}, 3, 0));
        areas.add(new Area(16, "This is the first area 0", new int[]{11, 17, 21, 15}, 3, 1));
        areas.add(new Area(17, "This is the second area 1", new int[]{12, 18, 22, 16}, 3, 2));
        areas.add(new Area(18, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{13, 19, 23, 17}, 3, 3));
        areas.add(new Area(19, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{14, -1, 24, 18}, 3, 4));
        areas.add(new Area(20, "You're on Island 20", new int[]{15, 21, -1, -1}, 4, 0));
        areas.add(new Area(21, "This is the second area 1", new int[]{16, 22, -1, 20}, 4, 1));
        areas.add(new Area(22, "This is the third area 2", new int[]{17, 23, -1, 21}, 4, 2));
        areas.add(new Area(23, "You're heading through the barrier reef. You'd better know what you're doing", new int[]{18, 24, -1, 22}, 4, 3));
        areas.add(new Area(24, "You've found Skull Island. Here be buried treasure! Yar!", new int[]{19, -1, -1, 23}, 4, 4));

        return areas;
    }
}