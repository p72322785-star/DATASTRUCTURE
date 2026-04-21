import java.util.*;

class ExpNode {
    String val;
    ExpNode left, right;

    ExpNode(String val) {
        this.val = val;
    }
}

public class prob5{

    static void inorder(ExpNode root) {
        if (root == null) return;
        if (root.left != null) System.out.print("(");
        inorder(root.left);
        System.out.print(root.val);
        inorder(root.right);
        if (root.right != null) System.out.print(")");
    }

    static void preorder(ExpNode root) {
        if (root == null) return;
        System.out.print(root.val + " ");
        preorder(root.left);
        preorder(root.right);
    }

    static void postorder(ExpNode root) {
        if (root == null) return;
        postorder(root.left);
        postorder(root.right);
        System.out.print(root.val + " ");
    }

    // Evaluate postfix using stack
    static int evaluatePostfix(String[] postfix) {
        Stack<Integer> stack = new Stack<>();

        for (String token : postfix) {
            if (Character.isDigit(token.charAt(0))) {
                stack.push(Integer.valueOf(token));
            } else {
                int b = stack.pop();
                int a = stack.pop();

                switch (token) {
                    case "+" -> stack.push(a + b);
                    case "-" -> stack.push(a - b);
                    case "*" -> stack.push(a * b);
                }
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
        // Expression: (3 + 5) * (8 - 2)
        ExpNode root = new ExpNode("*");
        root.left = new ExpNode("+");
        root.right = new ExpNode("-");

        root.left.left = new ExpNode("3");
        root.left.right = new ExpNode("5");
        root.right.left = new ExpNode("8");
        root.right.right = new ExpNode("2");

        System.out.print("Inorder: ");
        inorder(root);

        System.out.print("\nPreorder: ");
        preorder(root);

        System.out.print("\nPostorder: ");
        postorder(root);

        // Evaluate using postfix
        String[] postfix = {"3","5","+","8","2","-","*"};
        System.out.println("\nResult: " + evaluatePostfix(postfix));
    }
}