public class Bank {
    private final int[] coordinates;
    private final String name;
    private BankBranch[] branches;

    public Bank(int[] coordinates, String name) {
        this.coordinates = coordinates;
        this.name = name;
        branches = new BankBranch[50];
    }

    public int[] getCoordinates() {
        return coordinates;
    }

    public String getName() {
        return name;
    }

    public BankBranch[] getBranches() {
        return branches;
    }

    public void setBranches(BankBranch[] branches) {
        this.branches = branches;
    }
}