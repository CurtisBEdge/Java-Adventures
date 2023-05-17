public class Area {

    public Integer areaId;

    public String areaDescription;

    public String[] directionOptions;

    public boolean hasVisited;

    public boolean currentPosition;

    public Area(Integer areaId, String areaDescription, String[] directionOptions, boolean currentPosition) {
        this.areaId = areaId;
        this.areaDescription = areaDescription;
        this.directionOptions = directionOptions;
    }

    public String getAreaDescription() {
        return areaDescription;
    }
}
