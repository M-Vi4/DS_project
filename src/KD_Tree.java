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
        if (this.root == null) {
            this.root = node;
            return node;
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
}
