class BSTNode {
    int data;
    BSTNode left, right;

    BSTNode(int data) {
        this.data = data;
    }
}

public class prob3 {

    static BSTNode insert(BSTNode root, int val) {
        if (root == null) return new BSTNode(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static boolean search(BSTNode root, int key) {
        if (root == null) return false;
        if (root.data == key) return true;

        if (key < root.data)
            return search(root.left, key);
        else
            return search(root.right, key);
    }

    static void inorder(BSTNode root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] values = {50, 30, 70, 20, 40, 60, 80, 10, 25};

        BSTNode root = null;
        for (int v : values)
            root = insert(root, v);

        System.out.print("Inorder: ");
        inorder(root);

        System.out.println("\nSearch 25: " + search(root, 25));
    }
}