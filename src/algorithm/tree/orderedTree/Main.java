package tree.orderedTree;

public class Main {
    public static void main(String[] args) {
        int[] nodes = {15, 2, 10, 9, 3, 3, 8, 12, 9, 15, 22, 13, 3, 5};

        Node root = new Node(nodes[0]);

        for (int i = 1; i < nodes.length; i++) {
            root.add(new Node(nodes[i]));
        }

        LDRTraverse(root);
    }

    public static void LDRTraverse(Node node) {
        if (node == null) {
            return;
        }
        //前序
        LDRTraverse(node.left);
        //中序
        System.out.print(node.data + " ");
        LDRTraverse(node.right);
        //后序
    }
}
