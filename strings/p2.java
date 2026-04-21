import java.util.HashSet;

class p2 {
    public static void main(String[] args) {
        String str = "programming";

        StringBuilder result = new StringBuilder();
        HashSet<Character> set = new HashSet<>();

        for (char c : str.toCharArray()) {
            if (!set.contains(c)) {
                result.append(c);
                set.add(c);
            }
        }

        System.out.println("Without duplicates: " + result.toString());
    }
}