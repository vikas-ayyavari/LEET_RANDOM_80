//2906. Construct Product Matrix
class Solution {
    public int[][] constructProductMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int MOD = 12345;

        int size = m * n;
        int[] prefix = new int[size];
        int[] suffix = new int[size];

        // Reduce grid values modulo first ✅
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] %= MOD;
            }
        }

        // Prefix product
        prefix[0] = 1;
        for (int i = 1; i < size; i++) {
            int r = (i - 1) / n;
            int c = (i - 1) % n;
            prefix[i] = (int) ((long) prefix[i - 1] * grid[r][c] % MOD);
        }

        // Suffix product
        suffix[size - 1] = 1;
        for (int i = size - 2; i >= 0; i--) {
            int r = (i + 1) / n;
            int c = (i + 1) % n;
            suffix[i] = (int) ((long) suffix[i + 1] * grid[r][c] % MOD);
        }

        // Build result matrix
        int[][] result = new int[m][n];
        for (int i = 0; i < size; i++) {
            int r = i / n;
            int c = i % n;
            result[r][c] = (int) ((long) prefix[i] * suffix[i] % MOD);
        }

        return result;
    }
}
