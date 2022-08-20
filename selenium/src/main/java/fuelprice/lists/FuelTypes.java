package fuelprice.lists;

public class FuelTypes {

    private String fuelTypeId;
    private String fuelTypeName;

    public FuelTypes(String fuelTypeId, String fuelTypeName) {
        this.fuelTypeId = fuelTypeId;
        this.fuelTypeName = fuelTypeName;
    }

    public String getFuelTypeId() {
        return fuelTypeId;
    }

    public String getFuelTypeName() {
        return fuelTypeName;
    }
}
