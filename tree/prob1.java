class TreeNode {
    String data;
    TreeNode left, right;

    TreeNode(String data) {
        this.data = data;
        left = right = null;
    }
}

public class prob1 {
    // Find height
    static int height(TreeNode root) {
        if (root == null) return -1;
        return 1 + Math.max(height(root.left), height(root.right));
    }

    // Find depth of a node
    static int depth(TreeNode root, String target, int level) {
        if (root == null) return -1;
        if (root.data.equals(target)) return level;

        int left = depth(root.left, target, level + 1);
        if (left != -1) return left;

        return depth(root.right, target, level + 1);
    }

    public static void main(String[] args) {
        // Build tree
        TreeNode CEO = new TreeNode("CEO");
        CEO.left = new TreeNode("CTO");
        CEO.right = new TreeNode("CFO");

        CEO.left.left = new TreeNode("Dev Lead");
        CEO.left.right = new TreeNode("HR");

        CEO.left.left.left = new TreeNode("Dev1");
        CEO.left.left.right = new TreeNode("Dev2");

        System.out.println("Height: " + height(CEO));
        System.out.println("Depth of Dev Lead: " + depth(CEO, "Dev Lead", 0));
    }
}