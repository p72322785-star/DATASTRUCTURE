class p3 {

    static int N = 4;

    static int[] board;
    static boolean[] col;
    static boolean[] diag1;
    static boolean[] diag2;

    static void solve(int row) {
        if (row == N) {
            printSolution();
            return;
        }

        for (int c = 0; c < N; c++) {
            int d1 = row + c;
            int d2 = row - c + (N - 1);

            if (!col[c] && !diag1[d1] && !diag2[d2]) {

                board[row] = c;
                col[c] = diag1[d1] = diag2[d2] = true;

                solve(row + 1);

                col[c] = diag1[d1] = diag2[d2] = false;
            }
        }
    }

    static void printSolution() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i] == j ? "Q " : ". ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static void main(String[] args) {

        // ✅ Initialize here (safe)
        board = new int[N];
        col = new boolean[N];
        diag1 = new boolean[2 * N - 1];
        diag2 = new boolean[2 * N - 1];

        solve(0);
    }
}