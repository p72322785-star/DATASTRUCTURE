import java.util.*;

class p2{

    static void sort(Stack<Integer> stack) {
        if (stack.isEmpty()) return;

        int top = stack.pop();
        sort(stack);
        insert(stack, top);
    }

    static void insert(Stack<Integer> stack, int value) {
        if (stack.isEmpty() || stack.peek() <= value) {
            stack.push(value);
            return;
        }

        int temp = stack.pop();
        insert(stack, value);
        stack.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(3);
        st.push(1);
        st.push(4);
        st.push(2);

        sort(st);

        System.out.println(st); // [1,2,3,4]
    }
}