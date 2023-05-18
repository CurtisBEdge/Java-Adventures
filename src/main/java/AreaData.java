import java.util.ArrayList;

public class AreaData {

    public static ArrayList<Area> loadAreas() {
        ArrayList<Area> areas = new ArrayList<>();

//        Direction order North, East, South then West.

        areas.add(new Area(0, "This is the first area a0", new int[]{-1, 1, -1, 2}, false));
        areas.add(new Area(1, "This is the first area a1", new int[]{-1, -1, 3, 0}, false));
        areas.add(new Area(2, "This is the first area a2", new int[]{0, 3, -1, -1}, false));
        areas.add(new Area(3, "This is the first area a3", new int[]{1, -1, -1, 2}, false));

        return areas;
    }
}