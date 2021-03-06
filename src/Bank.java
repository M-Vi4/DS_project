public class Bank {
    public static final String PRINT_BLUE = "\u001B[34m";

    private double[] coordinates;
    private final String name;
    private KD_Tree branches = new KD_Tree(2);
    private int branchCtr = 0;

    public Bank(double[] coordinates, String name) {
        this.coordinates = coordinates;
        this.name = name;
    }

    public void delBr(double[] coo){
        branches.deleteNode(coo);
        branchCtr--;
    }

    public int getBranchCtr() {
        return branchCtr;
    }

    public void setBranchCtr(int branchCtr) {
        this.branchCtr = branchCtr;
    }

    public double[] getCoordinates() {
        return coordinates;
    }

    public void setCoordinates(double[] coordinates) {
        this.coordinates = coordinates;
    }

    public String getName() {
        return name;
    }


    public KD_Tree getBranches() {
        return branches;
    }

    public void addBranch(BankBranch branch){
        Node node = new Node(false);
        branchCtr++;
        node.setBankBranch(branch);
        this.branches.insert(node);
    }

    public void printInfo(){
        System.out.println(PRINT_BLUE + "bank " + "'" + this.getName() + "'" + " placed in X = " + getCoordinates()[0]
                + " and Y = " + getCoordinates()[1]);
    }

    public void printBranchesInfo(Node root){
        System.out.println(PRINT_BLUE + "'" + root.getBankBranch().getBrName() + "' branch of'" +
                            root.getBankBranch().getBaName() + "'bank located in X = "
                            +root.getCoordinates()[0] + " and Y = " +
                            +root.getCoordinates()[1]);
        if (root.getLeft() != null)
            printBranchesInfo(root.getLeft());
        if (root.getRight() != null)
            printBranchesInfo(root.getRight());
    }
}