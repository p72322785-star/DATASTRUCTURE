class BST {
    int data;
    BST left, right;

    BST(int data) {
        this.data = data;
    }
}

public class prob4 {

    static BST insert(BST root, int val) {
        if (root == null) return new BST(val);

        if (val < root.data)
            root.left = insert(root.left, val);
        else
            root.right = insert(root.right, val);

        return root;
    }

    static BST findMin(BST root) {
        while (root.left != null)
            root = root.left;
        return root;
    }

    static BST delete(BST root, int val) {
        if (root == null) return null;

        if (val < root.data)
            root.left = delete(root.left, val);
        else if (val > root.data)
            root.right = delete(root.right, val);
        else {
            // case: 1 child or no child
            if (root.left == null) return root.right;
            if (root.right == null) return root.left;

            // case: 2 children
            BST min = findMin(root.right);
            root.data = min.data;
            root.right = delete(root.right, min.data);
        }
        return root;
    }

    static void inorder(BST root) {
        if (root == null) return;
        inorder(root.left);
        System.out.print(root.data + " ");
        inorder(root.right);
    }

    public static void main(String[] args) {
        int[] arr = {15, 10, 20, 8, 12, 17, 25};

        BST root = null;
        for (int x : arr)
            root = insert(root, x);

        root = delete(root, 10); // delete
        root = insert(root, 14); // insert 14
        root = insert(root, 9);  // insert 9

        inorder(root);
    }
}