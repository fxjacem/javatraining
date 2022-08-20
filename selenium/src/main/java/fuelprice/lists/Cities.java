package fuelprice.lists;

public class Cities {

    private String cityId;
    private String cityName;

    public Cities(String cityId, String cityName) {
        this.cityId = cityId;
        this.cityName = cityName;
    }

    public String getCityId() {
        return cityId;
    }

    public String getCityName() {
        return cityName;
    }
}
