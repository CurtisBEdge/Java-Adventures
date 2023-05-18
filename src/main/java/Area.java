public class Area {

    public Integer areaId;

    public String areaDescription;

    public int[] directionOptions;

    public boolean hasVisited;

    public boolean currentPosition;

    public Area(Integer areaId, String areaDescription, int[] directionOptions, boolean currentPosition) {
        this.areaId = areaId;
        this.areaDescription = areaDescription;
        this.directionOptions = directionOptions;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public int[] getDirectionOptions() {
        return directionOptions;
    }
}
