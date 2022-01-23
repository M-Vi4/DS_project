public class Node{
    private final int[] coordinates;
    private Node right = null;
    private Node left = null;

    public Node(int[] coordinates) {
        this.coordinates = coordinates;
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

    public int[] getCoordinates() {
        return coordinates;
    }
}
