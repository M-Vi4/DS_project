public class BankBranch{
    private double[] coordinates;
    private String brName;
    private String baName;

    public BankBranch(double[] coordinates, String brName, String baName) {
        this.coordinates = coordinates;
        this.brName = brName;
        this.baName = baName;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getBrName() {
        return brName;
    }

    public void setBrName(String brName) {
        this.brName = brName;
    }

    public String getBaName() {
        return baName;
    }

    public void setBaName(String baName) {
        this.baName = baName;
    }
}