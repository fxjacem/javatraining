package fuelprice.lists;

public class Distances {

    private final String distanceId;
    private final String distanceName;

    public Distances(String distanceId, String distanceName) {
        this.distanceId = distanceId;
        this.distanceName = distanceName;
    }

    public String getDistanceId() {
        return distanceId;
    }

    public String getDistanceName() {
        return distanceName;
    }
}
