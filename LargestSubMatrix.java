//1727. Largest Submatrix With Rearrangements
class Solution {
    public int largestSubmatrix(int[][] matrix) {
        int m = matrix.length, n = matrix[0].length;
        int ans = 0;

        // Step 1: build histogram heights (in-place)
        for (int i = 1; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 1) {
                    matrix[i][j] += matrix[i-1][j];
                }
                // if matrix[i][j] == 0, height resets to 0 (already 0)
            }
        }

        // Step 2: for each row, sort heights and compute max rectangle
        for (int i = 0; i < m; i++) {
            int[] row = matrix[i].clone();
            Arrays.sort(row);  // ascending

            for (int j = n - 1; j >= 0; j--) {
                if (row[j] == 0) break; // no point continuing
                int width = n - j;      // number of columns used
                ans = Math.max(ans, row[j] * width);
            }
        }

        return ans;
    }
}
