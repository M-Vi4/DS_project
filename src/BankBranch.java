public class BankBranch{
    private int[] coordinates;
    private String brName;
    private String baName;

    public BankBranch(int[] coordinates, String brName, String baName) {
        this.coordinates = coordinates;
        this.brName = brName;
        this.baName = baName;
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(int[] coordinates) {
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