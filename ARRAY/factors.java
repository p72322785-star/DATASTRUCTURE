import java.util.*;

class factors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int maxSize = 10;
        int[] factors = new int[maxSize];
        int index = 0;

        for (int i = 1; i <= num; i++) {
            if (num % i == 0) {
                if (index == maxSize) {
                    maxSize *= 2;
                    factors = Arrays.copyOf(factors, maxSize);
                }
                factors[index++] = i;
            }
        }

        System.out.println("Factors:");
        for (int i = 0; i < index; i++) {
            System.out.print(factors[i] + " ");
        }
    }
}