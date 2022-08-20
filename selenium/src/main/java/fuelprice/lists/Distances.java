package fuelprice.lists;

public class Distances {

    private String distanceId;
    private String distanceName;

    public Distances(String distanceId, String distanceName) {
        this.distanceId = distanceId;
        this.distanceName = distanceName;
    }

    @Override
    public String toString() {
        return String.format("%3s - %s\n",distanceId, distanceName);
    }

}
