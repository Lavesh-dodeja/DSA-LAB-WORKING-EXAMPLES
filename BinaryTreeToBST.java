import java.util.ArrayList;
import java.util.Collections;

class TreeNode {
    int val;
    TreeNode left, right;

    TreeNode(int val) {
        this.val = val;
        left = right = null;
    }
}

public class BinaryTreeToBST {
    private static ArrayList<Integer> values = new ArrayList<>();

    public static void collectValues(TreeNode root) {
        if (root == null) return;
        collectValues(root.left);
        values.add(root.val);
        collectValues(root.right);
    }

    public static void assignValues(TreeNode root) {
        if (root == null) return;
        assignValues(root.left);
        root.val = values.remove(0);
        assignValues(root.right);
    }

    public static void convertToBST(TreeNode root) {
        if (root == null) return;

        collectValues(root);

        Collections.sort(values);

        assignValues(root);
    }

    public static void inOrderPrint(TreeNode root) {
        if (root == null) return;
        inOrderPrint(root.left);
        System.out.print(root.val + " ");
        inOrderPrint(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(2);
        root.right = new TreeNode(7);
        root.left.left = new TreeNode(8);
        root.left.right = new TreeNode(4);

        System.out.println("Original Tree (In-order Traversal):");
        inOrderPrint(root);
        System.out.println();

        convertToBST(root);

        System.out.println("Converted BST (In-order Traversal):");
        inOrderPrint(root);
    }
}
