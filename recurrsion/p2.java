class p2 {

    static int[] dx = {-1,-1,-1,0,0,1,1,1};
    static int[] dy = {-1,0,1,-1,1,-1,0,1};

    static boolean dfs(char[][] grid, String word, int i, int j, int index, boolean[][] visited) {

        if (index == word.length()) return true;

        if (i < 0 || j < 0 || i >= 4 || j >= 4 ||
            visited[i][j] || grid[i][j] != word.charAt(index))
            return false;

        visited[i][j] = true;

        for (int d = 0; d < 8; d++) {
            if (dfs(grid, word, i + dx[d], j + dy[d], index + 1, visited))
                return true;
        }

        visited[i][j] = false; // backtrack
        return false;
    }

    public static void main(String[] args) {
        char[][] grid = {
            {'C','A','T','S'},
            {'O','R','E','A'},
            {'D','E','A','M'},
            {'E','L','L','S'}
        };

        String word = "DREAM";
        boolean found = false;

        boolean[][] visited = new boolean[4][4];

        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                if (dfs(grid, word, i, j, 0, visited)) {
                    found = true;
                    break;
                }
            }
        }

        System.out.println("Word Found: " + found);
    }
}