package binarytree;

public class Node {

    public Node left;
    public Node right;
    public Node nextRight;
    public int data;

    public Node(int data) {
        this.data = data;
        left = null;
        right = null;
        nextRight = null;
    }
}
