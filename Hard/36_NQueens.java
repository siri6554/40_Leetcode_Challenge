import java.util.*;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) Arrays.fill(row, '.');
        backtrack(0, board, new boolean[n], new boolean[2*n-1],
                  new boolean[2*n-1], ans);
        return ans;
    }
    private void backtrack(int r, char[][] b, boolean[] col, boolean[] d1,
                           boolean[] d2, List<List<String>> ans) {
        int n = b.length;
        if (r == n) {
            List<String> solution = new ArrayList<>();
            for (char[] row : b) solution.add(new String(row));
            ans.add(solution);
            return;
        }
        for (int c = 0; c < n; c++) {
            int x = r - c + n - 1, y = r + c;
            if (col[c] || d1[x] || d2[y]) continue;
            b[r][c] = 'Q'; col[c] = d1[x] = d2[y] = true;
            backtrack(r + 1, b, col, d1, d2, ans);
            b[r][c] = '.'; col[c] = d1[x] = d2[y] = false;
        }
    }
}
