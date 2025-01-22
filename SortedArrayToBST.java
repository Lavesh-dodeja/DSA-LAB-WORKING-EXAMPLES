class TreeNode {
    int value;
    TreeNode left, right;

    TreeNode(int value) {
        this.value = value;
        this.left = null;
        this.right = null;
    }
}

public class SortedArrayToBST {

    public TreeNode sortedArrayToBST(int[] nums) {
        return buildBST(nums, 0, nums.length - 1);
    }

    private TreeNode buildBST(int[] nums, int start, int end) {
        if (start > end) return null;

        int mid = start + (end - start) / 2;

        TreeNode node = new TreeNode(nums[mid]);

        node.left = buildBST(nums, start, mid - 1); 
        node.right = buildBST(nums, mid + 1, end);  

        return node;
    }

    public void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        System.out.print(root.value + " ");
        inOrderTraversal(root.right);
    }

    public static void main(String[] args) {
        SortedArrayToBST tree = new SortedArrayToBST();
        
        int[] sortedArray = {1, 2, 3, 4, 5, 6, 7};
        
        TreeNode root = tree.sortedArrayToBST(sortedArray);
        
        System.out.println("In-order Traversal of the BST:");
        tree.inOrderTraversal(root);
    }
}
