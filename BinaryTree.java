class TreeNode {
    int data;
    TreeNode left, right;

    TreeNode(int data) {
        this.data = data;
        this.left = this.right = null;
    }
}

public class BinaryTree {

    TreeNode root;

    int calculateHeight(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftHeight = calculateHeight(node.left);
        int rightHeight = calculateHeight(node.right);
        if (leftHeight > rightHeight) {
            return 1 + leftHeight;
        } else {
            return 1 + rightHeight;
        }
    }

    boolean isComplete(TreeNode node, int index, int totalNodes) {
        if (node == null) {
            return true;
        }
        if (index >= totalNodes) {
            return false;
        }
        boolean leftComplete = isComplete(node.left, 2 * index + 1, totalNodes);
        boolean rightComplete = isComplete(node.right, 2 * index + 2, totalNodes);
        if (leftComplete && rightComplete) {
            return true;
        } else {
            return false;
        }
    }

    boolean isFull(TreeNode node) {
        if (node == null) {
            return true;
        }
        if ((node.left == null && node.right != null) || (node.left != null && node.right == null)) {
            return false;
        }
        boolean leftFull = isFull(node.left);
        boolean rightFull = isFull(node.right);
        if (leftFull && rightFull) {
            return true;
        } else {
            return false;
        }
    }

    boolean checkChildrenSum(TreeNode node) {
        if (node == null || (node.left == null && node.right == null)) {
            return true;
        }
        int left = 0;
        int right = 0;
        if (node.left != null) {
            left = node.left.data;
        }
        if (node.right != null) {
            right = node.right.data;
        }
        if (node.data == left + right) {
            boolean leftCheck = checkChildrenSum(node.left);
            boolean rightCheck = checkChildrenSum(node.right);
            if (leftCheck && rightCheck) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    int countNodes(TreeNode node) {
        if (node == null) {
            return 0;
        }
        int leftCount = countNodes(node.left);
        int rightCount = countNodes(node.right);
        return 1 + leftCount + rightCount;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();

        tree.root = new TreeNode(10);
        tree.root.left = new TreeNode(8);
        tree.root.right = new TreeNode(2);
        tree.root.left.left = new TreeNode(3);
        tree.root.left.right = new TreeNode(5);
        tree.root.right.right = new TreeNode(2);

        System.out.println("Height of the tree: " + tree.calculateHeight(tree.root));

        int totalNodes = tree.countNodes(tree.root);
        System.out.println("Is complete tree: " + tree.isComplete(tree.root, 0, totalNodes));
        System.out.println("Is full tree: " + tree.isFull(tree.root));
        System.out.println("Children sum property holds: " + tree.checkChildrenSum(tree.root));
    }
}
