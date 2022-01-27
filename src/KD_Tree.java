public class KD_Tree {
    private Node root = null;
    private final int k;
    boolean isSame = false;

    public KD_Tree(int k) {
        this.k = k;
    }

    public void setRoot(Node root) {
        this.root = root;
    }

    public Node getRoot() {
        return root;
    }

    private Node insert(Node root, Node node, int d) {
        if (root == null) {
            return node;
        }
        if (nodeComparison(node , root)) {
            System.out.println("There is already a bank here!!");
            isSame = true;
            return root;
        }
        int r = d % k;
        if (node.getCoordinates()[r] < root.getCoordinates()[r])
            root.setLeft(insert(root.getLeft(), node, d + 1));
        else
            root.setRight(insert(root.getRight(), node, d + 1));
        return root;
    }

    public void insert(Node node){
        root = insert(root , node , 0);
    }

    public boolean nodeComparison(Node node1, Node node2) {
        for (int i = 0; i < k; i++) {
            if (node1.getCoordinates()[i] != node2.getCoordinates()[i])
                return false;
        }
        return true;
    }

    public boolean cooCompare(double[] coo1 , double[] coo2){
        return (coo1[0] == coo2[0] && coo1[1] == coo2[1]);
    }

    private Node minNode(Node x , Node y , Node z , int d){
        Node res = x;
        if (y != null && y.getCoordinates()[d] < res.getCoordinates()[d])
            res = y;
        if (z != null && z.getCoordinates()[d] < res.getCoordinates()[d])
            res = z;
        return res;
    }

    private Node findMin(Node root , int d , int depth){
        if (root == null)
            return null;
        int r = depth % k;
        if (r == d){
            if (root.getLeft() == null)
                return root;
            return findMin(root.getLeft() , d , depth + 1);
        }
        return minNode(root , findMin(root.getLeft() , d , depth + 1) , findMin(root.getRight() , d , depth + 1) , d);
    }

    public Node findMin(Node root , int d){
        return findMin(root , d, 0);
    }

    private Node deleteNode(Node root , double[] coo , int depth){
        if (root == null)
            return null;
        int r = depth % k;
        if (cooCompare(root.getCoordinates() , coo)){
            if (root.getRight() != null){
                Node min = findMin(root.getRight() , r);
                root.setBankBranch(min.getBankBranch());
                root.setRight(deleteNode(root.getRight() , min.getCoordinates() ,depth + 1 ));
            }
            else if (root.getLeft() != null){
                Node min = findMin(root.getLeft() , r);
                root.setBankBranch(min.getBankBranch());
                root.setRight(deleteNode(root.getLeft() , min.getCoordinates() , depth + 1));
            }
            else {
                return  null;
            }
            return root;
        }
        if (coo[r] < root.getCoordinates()[r])
            root.setLeft(deleteNode(root.getLeft() , coo , depth + 1));
        else
            root.setRight(deleteNode(root.getRight() , coo , depth + 1));
        return root;
    }

    public void deleteNode(double[] coo){
        deleteNode(root , coo , 0);
    }

    public Node search(Node root, double[]coo, int d) {
        if (root == null)
            return null;
        if (root.getCoordinates()[0] == coo[0] && root.getCoordinates()[1] == coo[1])
            return root;
        int r = d % k;
        if (coo[r] < root.getCoordinates()[r])
            return search(root.getLeft(), coo, d + 1);
        return search(root.getRight(), coo, d + 1);
    }

    public void inRangeBanks(Node root, double[] coordinates, double r) {
        if (root == null)
            return;
        double d = Math.sqrt(Math.pow((root.getCoordinates()[0] - coordinates[0]), 2) + Math.pow((root.getCoordinates()[1] - coordinates[1]), 2));
        if (d < r) {
            root.printInfo();
            inRangeBanks(root.getRight(), coordinates, r);
        }
        inRangeBanks(root.getLeft(), coordinates, r);
    }

    private double distance(double[] coo1, double[] coo2) {
        return (Math.pow((coo1[0] - coo2[0]), 2) + Math.pow((coo1[1] - coo2[1]), 2));
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
        return best;
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

    public void rangeSearch(Node root , Neighborhood neighborhood, int d){
        if (root == null)
            return;
        double[] rootC = root.getCoordinates();
        int r = d % k;
        if (rootC[0] > neighborhood.getMin_X() && rootC[0] < neighborhood.getMax_X() &&
            rootC[1] > neighborhood.getMin_Y() && rootC[1] < neighborhood.getMax_Y())
            root.printInfo();
        if (r == 0){
            if (rootC[r] > neighborhood.getMin_X())
                rangeSearch(root.getLeft() , neighborhood , d + 1);
            if (rootC[r] < neighborhood.getMax_X())
                rangeSearch(root.getRight() , neighborhood , d + 1);
        }
        else if (r == 1){
            if (rootC[r] > neighborhood.getMin_Y())
                rangeSearch(root.getLeft() , neighborhood , d + 1);
            if (rootC[r] < neighborhood.getMax_Y())
                rangeSearch(root.getRight() , neighborhood , d + 1);
        }
    }
}
