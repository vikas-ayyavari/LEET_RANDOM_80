//3418. Maximum Amount of Money Robot Can Earn

class Solution {
    public int maximumAmount(int[][] coins) {
        int m = coins.length, n = coins[0].length;
        int NEG_INF = Integer.MIN_VALUE / 4;

        int[][][] dp = new int[m][n][3];

        // Initialize DP
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                for (int k = 0; k < 3; k++)
                    dp[i][j][k] = NEG_INF;

        // Start cell initialization
        dp[0][0][0] = coins[0][0];
        if (coins[0][0] < 0) {
            dp[0][0][1] = 0; // neutralize starting cell
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < 3; k++) {
                    if (dp[i][j][k] == NEG_INF) continue;

                    // Move Down
                    if (i + 1 < m) {
                        dp[i + 1][j][k] =
                            Math.max(dp[i + 1][j][k],
                                     dp[i][j][k] + coins[i + 1][j]);

                        if (coins[i + 1][j] < 0 && k < 2) {
                            dp[i + 1][j][k + 1] =
                                Math.max(dp[i + 1][j][k + 1],
                                         dp[i][j][k]);
                        }
                    }

                    // Move Right
                    if (j + 1 < n) {
                        dp[i][j + 1][k] =
                            Math.max(dp[i][j + 1][k],
                                     dp[i][j][k] + coins[i][j + 1]);

                        if (coins[i][j + 1] < 0 && k < 2) {
                            dp[i][j + 1][k + 1] =
                                Math.max(dp[i][j + 1][k + 1],
                                         dp[i][j][k]);
                        }
                    }
                }
            }
        }

        return Math.max(
            dp[m - 1][n - 1][0],
            Math.max(dp[m - 1][n - 1][1],
                     dp[m - 1][n - 1][2])
        );
    }
}
