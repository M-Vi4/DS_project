public class Bank {
    private final double[] coordinates;
    private final String name;
    private BankBranch[] branches;

    public Bank(double[] coordinates, String name) {
        this.coordinates = coordinates;
        this.name = name;
        branches = new BankBranch[50];
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public BankBranch[] getBranches() {
        return branches;
    }
    public void setBranches(BankBranch[] branches){
        this.branches = branches;
    }
}