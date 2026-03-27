//2946. Matrix Similarity After Cyclic Shifts
class Solution {
    public boolean areSimilar(int[][] mat, int k) {
    int n = mat[0].length;
    if(k%n == 0) return true;
    k = k%n;

    for(int i =0 ;i < mat.length;i++){
        for(int j =0 ; j < n;j++){
            int future = 0;
            if(i%2==0){
                future  = mat[i][(j+k)%n];
            }else{
                future = mat[i][(j-k+n)%n];
            }
            if(mat[i][j] != future) return false;
        }
    }
    return true;
    } 
    
}
