import java.util.*;

class p3 {

    // Implementation A
    static boolean checkNested(int[] completed, int[] prereq) {

        for (int i = 0; i < prereq.length; i++) {
            boolean found = false;

            for (int j = 0; j < completed.length; j++) {
                if (prereq[i] == completed[j]) {
                    found = true;
                    break;
                }
            }

            if (!found) return false;
        }

        return true;
    }

    // Implementation B
    static boolean checkHash(int[] completed, int[] prereq) {

        HashSet<Integer> set = new HashSet<>();

        for (int x : completed) set.add(x);

        for (int x : prereq) {
            if (!set.contains(x)) return false;
        }

        return true;
    }

    public static void main(String[] args) {

        int[] completed = {101, 102, 103, 104};
        int[] prereq = {101, 103};

        System.out.println("Nested: " + checkNested(completed, prereq));
        System.out.println("HashSet: " + checkHash(completed, prereq));
    }
}