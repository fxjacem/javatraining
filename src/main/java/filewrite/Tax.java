package filewrite;

public class Tax{

    private final String taxNumber;

    private final int taxValue;

    public Tax(String taxNumber, int taxValue) {
        this.taxNumber = taxNumber;
        this.taxValue = taxValue;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "taxNumber='" + taxNumber + '\'' +
                ", taxValue=" + taxValue +
                '}' + "\n";
    }

}
