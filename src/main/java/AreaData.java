import java.util.ArrayList;

public class AreaData {

    public static ArrayList<Area> loadAreas() {
        ArrayList<Area> areas = new ArrayList<>();

//        Direction order North, East, South then West.

        areas.add(new Area(0, "This is the first area 0", new int[]{-1, 1, 2, -1}, 0, 0));
        areas.add(new Area(1, "This is the second area 1", new int[]{-1, -1, 3, 0}, 0, 1));
        areas.add(new Area(2, "This is the third area 2", new int[]{0, 3, -1, -1}, 1, 0));
        areas.add(new Area(3, "This is the fourth area 3", new int[]{1, -1, -1, 2}, 1, 1));

        return areas;
    }
}