class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length; 
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                boolean visited[][] = new boolean[m][n];
                if (exist(m, n, i, j, board, visited, word, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean exist(int m, int n, int i, int j, char[][] board, boolean visited[][], String word, int wi) {
        
        // System.out.println("Visiting cell " + i + j);
        if (board[i][j] == word.charAt(wi)) {
            visited[i][j] = true;
            // System.out.println("Hit" + wi);
            if (wi == word.length() - 1) {
                // System.out.println("Found");
                return true;
            }
            boolean result = false;
            if (i+1 < m && !visited[i+1][j]) {
                result = result || exist(m, n, i + 1, j, board, deepCopy(visited), word, wi+1);
            }
            if (i-1 >= 0 && !visited[i-1][j]) {
                result = result || exist(m, n, i - 1, j, board, deepCopy(visited), word, wi+1);
            }
            if (j+1 < n && !visited[i][j+1]) {
                result = result || exist(m, n, i, j + 1, board, deepCopy(visited), word, wi+1);
            }
            if (j-1 >= 0 && !visited[i][j-1]) {
                result = result || exist(m, n, i, j - 1, board, deepCopy(visited), word, wi+1);
            }
            return result;
        } else {
            // System.out.println("Outright" + i + j);
            visited[i][j] = false;
            return false;
        }
    }

    public static boolean[][] deepCopy(boolean[][] original) {
        if (original == null) {
            return null;
        }

        boolean[][] copy = new boolean[original.length][];
        for (int i = 0; i < original.length; i++) {
            // Guard against null rows in jagged arrays
            copy[i] = (original[i] == null) ? null : original[i].clone();
        }
        return copy;
    }
}
