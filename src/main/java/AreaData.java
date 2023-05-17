import java.util.ArrayList;

public class AreaData {

    public static ArrayList<Area> loadAreas() {
        ArrayList<Area> areas = new ArrayList<>();

        areas.add(new Area(1, "This is the first area a1", new String[]{"North", "East", "South"}, false));
        areas.add(new Area(2, "This is the first area a2", new String[]{"North", "East", "South"}, false));
        areas.add(new Area(3, "This is the first area a3", new String[]{"North", "East", "South"}, false));

        return areas;
    }
}