package BTS;

public class BinaryTreeSearch {
    public static boolean search(TreeNode root, int target) {
        if (root == null) {
            return false;
        }

        if (root.val == target) {
            return true;
        } else if (target < root.val) {
            return search(root.left, target);
        } else {
            return search(root.right, target);
        }
    }

    public static void main(String[] args) {
        // Create a binary search tree
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(20);

        // Perform a search
        int target = 7;
        boolean found = search(root, target);
        if (found) {
            System.out.println("Element " + target + " found in the binary tree.");
        } else {
            System.out.println("Element " + target + " not found in the binary tree.");
        }
    }
}

