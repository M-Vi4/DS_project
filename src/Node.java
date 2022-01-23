public class Node{
    private Bank bank;
    private BankBranch bankBranch;
    private Node right = null;
    private Node left = null;
    private boolean isBank;

    public Node(boolean isBank) {
        this.isBank = isBank;
    }

    public void setRight(Node right) {
        this.right = right;
    }

    public void setLeft(Node left) {
        this.left = left;
    }

    public Node getRight() {
        return right;
    }

    public Node getLeft() {
        return left;
    }

    public Bank getBank() {
        return bank;
    }

    public void setBank(Bank bank) {
        this.bank = bank;
    }

    public BankBranch getBankBranch() {
        return bankBranch;
    }

    public void setBankBranch(BankBranch bankBranch){
        this.bankBranch = bankBranch;
    }

    public boolean isBank() {
        return isBank;
    }

    public void setIsBank(boolean bank) {
        isBank = bank;
    }
    public double[] getCoordinates(){
        if (isBank)
            return bank.getCoordinates();
        return bankBranch.getCoordinates();
    }

    public void printInfo(){
        if (isBank){
            System.out.println("bank " + "'" + bank.getName() + "'" + " placed in X = " + getCoordinates()[0]
                                + " and Y = " + getCoordinates()[1]);
        }
        else {
            System.out.println("'" + bankBranch.getBrName() + "' branch of'" +
                                bankBranch.getBaName() + "'bank placed in X = "
                                + bankBranch.getCoordinates()[0] + " and Y = " +
                                + bankBranch.getCoordinates()[1]);
        }
    }
}
