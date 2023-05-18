public class Area {

    public Integer areaId;

    public String areaDescription;

    public int[] directionOptions;

    public boolean hasVisited;

    public int rowPosition;

    public int columnPosition;


    public Area(Integer areaId, String areaDescription, int[] directionOptions, int rowPosition, int columnPosition) {
        this.areaId = areaId;
        this.areaDescription = areaDescription;
        this.directionOptions = directionOptions;
        this.rowPosition = rowPosition;
        this.columnPosition = columnPosition;
        this.hasVisited = false;
    }

    public String getAreaDescription() {
        return areaDescription;
    }

    public int getAreaId() {
        return areaId;
    }

    public int[] getDirectionOptions() {
        return directionOptions;
    }

    public void setHasVisited() {
        this.hasVisited = true;
    }

    public int getRowPosition() {
        return rowPosition;
    }

    public int getColumnPosition() {
        return columnPosition;
    }
}
