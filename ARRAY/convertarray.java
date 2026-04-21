import java.util.*;

class convertarray{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int r = sc.nextInt();
        int c = sc.nextInt();

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }

        int[] arr = new int[r * c];
        int index = 0;

        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[index++] = matrix[i][j];
            }
        }

        System.out.println("1D Array:");
        for (int x : arr) System.out.print(x + " ");
    }
}