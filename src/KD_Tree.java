public class KD_Tree {
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

    public Node insert(Node root, Node node, int d) {
        if (this.root == null) {
            this.root = node;
            return node;
        }
        if (root == null) {
            return node;
        }
        if (nodeComparison(root, node)) {
            System.out.println("already there is a bank here!!");
            return root;
        }
        int r = d % k;
        if (node.getCoordinates()[r] < root.getCoordinates()[r])
            root.setLeft(insert(root.getLeft(), node, d + 1));
        else
            root.setRight(insert(root.getRight(), node, d + 1));
        return root;
    }

    public boolean nodeComparison(Node node1, Node node2) {
        for (int i = 0; i < k; i++) {
            if (node1.getCoordinates()[i] != node2.getCoordinates()[i])
                return false;
        }
        return true;
    }

    public boolean search(Node root, Node node, int d) {
        if (root == null)
            return false;
        if (nodeComparison(root, node))
            return true;
        int r = d % k;
        if (node.getCoordinates()[r] < root.getCoordinates()[r])
            return search(root.getLeft(), node, d + 1);
        return search(root.getRight(), node, d + 1);
    }

    private boolean rangeCalc(double[] coordinates1, double[] coordinates2, double r) {
        double d = Math.sqrt(Math.pow((coordinates1[0] - coordinates2[0]), 2) + Math.pow((coordinates1[1] - coordinates2[1]), 2));
        return d <= r;
    }

    public void inRangeBanks(Node root, double[] coordinates, double r) {
        if (root == null)
            return;
        if (rangeCalc(root.getCoordinates(), coordinates, r) && root.isBank()) {
            root.printInfo();
            inRangeBanks(root.getRight(), coordinates, r);
        }
        inRangeBanks(root.getLeft(), coordinates, r);
    }

    private double distance(double[] coo1, double[] coo2) {
        return (Math.pow((coo1[0] - coo2[0]), 2) + Math.pow((coo1[1] - coo2[2]), 2));
    }

    public Node nearestBank(Node root, double[] coordinate, int d) {
        if (root == null)
            return null;
        Node next = null;
        Node other = null;
        int r = d % k;
        if (coordinate[r] < root.getCoordinates()[r]){
            next = root.getLeft();
            other = root.getRight();
        }
        else {
            next = root.getRight();
            other = root.getLeft();
        }
        Node temp = nearestBank(next , coordinate , d + 1);
        Node best = closest(temp , root , coordinate);
        double rs = distance(coordinate , best.getCoordinates());
        double dist = coordinate[r] - root.getCoordinates()[r];
        if (rs >= dist * dist){
            temp = nearestBank(other , coordinate , d + 1);
            best = closest(temp , best , coordinate);
        }
    }

    private Node closest(Node n0 , Node n1 , double[] coordinate){
        if (n0 == null)
            return n1;
        if (n1 == null)
            return n0;
        double d1 = distance(n0.getCoordinates(), coordinate);
        double d2 = distance(n1.getCoordinates() , coordinate);
        if (d1 < d2)
            return n0;
        return n1;
    }
}
