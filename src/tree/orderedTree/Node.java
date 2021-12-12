package tree.orderedTree;

public class Node {

    public int data;
    public Node left = null;
    public Node right = null;

    public Node(int data) {
        this.data = data;
    }

    public void add(Node node) {
        if (node == null) {
            return;
        }
        if (node.data < this.data) {
            if (this.left == null) {
                this.left = node;
            } else {
                this.left.add(node);
            }
        } else {
            if (this.right == null) {
                this.right = node;
            } else {
                this.right.add(node);
            }
        }
    }


}
