public class KD_Tree{
    private Node root = null;
    private final int k;

    public KD_Tree(int k) {
        this.k = k;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    public Node insert(Node root , Node node , int d){
        if (this.root == null)
            return node;
        if (nodeComparison(root , node)){
            System.out.println("can not place a bank here!!");
            return root;
        }
        int r = d % k;
        if (node.getCoordinates()[r] < root.getCoordinates()[r])
            root.setLeft(insert(root.getLeft() , node , d + 1));
        else
            root.setRight(insert(root.getRight() , node , d + 1));
        return root;
    }

    public boolean nodeComparison(Node node1 , Node node2){
        for (int i = 0; i < k; i++) {
            if (node1.getCoordinates()[i] != node2.getCoordinates()[i])
                return false;
        }
        return true;
    }

    public boolean search(Node root , Node node , int d){
        if (root == null)
            return false;
        if (nodeComparison(root , node))
            return true;
        int r = d % k;
        if (node.getCoordinates()[r] < root.getCoordinates()[r])
            return search(root.getLeft() , node , d + 1);
        return search(root.getRight() , node , d + 1);
    }

    private boolean rangeCalc(double[] coordinates1 , double[] coordinates2 , double r){
        double d = Math.sqrt(Math.pow((coordinates1[0] - coordinates2[0]) , 2) + Math.pow((coordinates1[1] - coordinates2[1]) , 2));
        return d <= r;
    }

    public void inRangeBanks(Node root , double[] coordinates , double r){
        if (root == null)
            return;
        if (rangeCalc(root.getCoordinates() , coordinates , r) && root.isBank()){
            root.printInfo();
            inRangeBanks(root.getRight() , coordinates , r);
        }
        inRangeBanks(root.getLeft() , coordinates , r);
    }

}
