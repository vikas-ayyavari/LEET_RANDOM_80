// 3212. Count Submatrices With Equal Frequency of X and Y

class Solution {
    public int numberOfSubmatrices(char[][] grid) {
        int n = grid.length;
        int m = grid[0].length;

        int cumx[][] = new int[n][m];
        int cumy[][] = new int[n][m];

        int c = 0;

        for(int i = 0;i < n;i++){
            for(int j = 0;j < m;j++){
                cumx[i][j] = (grid[i][j] == 'X') ? 1 : 0;
                cumy[i][j] = (grid[i][j] == 'Y') ? 1 : 0;

                if(i-1 >= 0){
                    cumx[i][j] += cumx[i-1][j];
                    cumy[i][j] += cumy[i-1][j];
                }

                if(j-1 >= 0){
                    cumx[i][j] += cumx[i][j-1];
                    cumy[i][j] += cumy[i][j-1];
                }

                if(i-1 >= 0 && j-1 >= 0){
                    cumx[i][j] -= cumx[i-1][j-1];
                    cumy[i][j] -= cumy[i-1][j-1];
                }

                if(cumx[i][j] == cumy[i][j] && cumx[i][j] > 0) c++;

            }
        }
        return c;
    }
}
