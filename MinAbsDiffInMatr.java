//3567. Minimum Absolute Difference in Sliding Submatrix
class Solution {
    public int[][] minAbsDiff(int[][] grid, int k) {
        int n = grid.length;
        int m = grid[0].length;
        int res[][] = new int[n-k+1][m-k+1];

        for(int i = 0;i <= n-k ;i++){
            for(int j = 0; j <= m-k ; j++){

                Set<Integer> set = new TreeSet<>();

                for(int x = i; x <= i+k-1 ; x++){
                    for(int y = j; y <= j+k-1 ; y++){
                        set.add(grid[x][y]);
                        System.out.println(grid[x][y]);
                    }
                }

                if(set.size() == 1) res[i][j] = 0;
                else{

                    Iterator<Integer> it = set.iterator();

                    int prev = it.next();
                    int minm = Integer.MAX_VALUE;

                    while(it.hasNext()){
                        int cur = it.next();
                        minm = Math.min(minm,Math.abs(cur-prev));
                        prev = cur;
                    }

                res[i][j] = minm;
                }
            }
        }
        System.gc();
        return res;
    }
}
