public class Bank {
    private final double[] coordinates;
    private final String name;
    private BankBranch[] branches;
    private int branchCtr = 0;

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
    public void addBranch(BankBranch branch){
        this.branches[branchCtr++] = branch;
    }
    public void printInfo(){
        System.out.println("bank " + "'" + this.getName() + "'" + " placed in X = " + getCoordinates()[0]
                + " and Y = " + getCoordinates()[1]);
    }
}