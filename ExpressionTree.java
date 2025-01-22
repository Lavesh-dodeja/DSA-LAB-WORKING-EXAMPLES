class Node {
    String value; 
    Node left, right; 

    Node(String value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}
public class ExpressionTree {
    private Node root;

    public void buildTree() {
        Node n5 = new Node("5");
        Node n2a = new Node("2");
        Node n2b = new Node("2");
        Node n1 = new Node("1");
        Node n9 = new Node("9");

        Node plus1 = new Node("+");
        plus1.left = n5;
        plus1.right = n2a;

        Node minus1 = new Node("-");
        minus1.left = n2b;
        minus1.right = n1;

        Node times = new Node("*");
        times.left = plus1;
        times.right = minus1;

        Node plus2 = new Node("+");
        plus2.left = new Node("2");
        plus2.right = n9;

        Node divide = new Node("/");
        divide.left = times;
        divide.right = plus2;

        this.root = divide;
    }

    public void inOrder(Node node) {
        if (node == null) return;
        System.out.print("(");
        inOrder(node.left);
        System.out.print(" " + node.value + " ");
        inOrder(node.right);
        System.out.print(")");
    }

    public void preOrder(Node node) {
        if (node == null) return;
        System.out.print(node.value + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public void postOrder(Node node) {
        if (node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.value + " ");
    }

    public static void main(String[] args) {
        ExpressionTree tree = new ExpressionTree();
        tree.buildTree();

        System.out.println("In-order Traversal:");
        tree.inOrder(tree.root); 
        System.out.println("\n");

        System.out.println("Pre-order Traversal:");
        tree.preOrder(tree.root); 
        System.out.println("\n");

        System.out.println("Post-order Traversal:");
        tree.postOrder(tree.root);
        System.out.println();
    }
}
