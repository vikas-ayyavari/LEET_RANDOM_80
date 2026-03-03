//1536. Minimum Swaps to Arrange a Binary Grid
class Solution {
    public int minSwaps(int[][] grid) {
       
int n = grid.length;
        int[] trailing = new int[n];

        for (int i = 0; i < n; i++) {
            int count = 0;
            for (int j = n - 1; j >= 0; j--) {
                if (grid[i][j] == 0) count++;
                else break;
            }
            trailing[i] = count;
        }

        
int swaps = 0;

        // 2) For each target row i, we need at least (n - 1 - i) trailing zeros
        for (int i = 0; i < n; i++) {
            int need = n - 1 - i;

            // Find the first row j >= i with trailing[j] >= need
            int j = i;
            while (j < n && trailing[j] < need) j++;

            // If none found, impossible
            if (j == n) return -1;

            // 3) Bubble row j up to i (adjacent swaps). Each swap moves it up by 1.
            while (j > i) {
                // swap trailing[j] with trailing[j - 1]
                int temp = trailing[j];
                trailing[j] = trailing[j - 1];
                trailing[j - 1] = temp;

                j--;
                swaps++;
            }
            // After this, trailing[i] satisfies the condition
        }

        return swaps;

    }
}
