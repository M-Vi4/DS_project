public class Bank {
    private final double[] coordinates;
    private final String name;
    private BankBranch[] branches;
    private KD_Tree branch = new KD_Tree(2);
    private int branchCtr = 0;

    public Bank(double[] coordinates, String name) {
        this.coordinates = coordinates;
        this.name = name;
        branches = new BankBranch[50];
    }

    public int getBranchCtr() {
        return branchCtr;
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

    public KD_Tree getBranch() {
        return branch;
    }

    public void addBranch(BankBranch branch){
        Node node = new Node(false);
        branches[branchCtr++] = branch;
        node.setBankBranch(branch);
        this.branch.insert(node);
    }

    public void printInfo(){
        System.out.println("bank " + "'" + this.getName() + "'" + " placed in X = " + getCoordinates()[0]
                + " and Y = " + getCoordinates()[1]);
    }
}