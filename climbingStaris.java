// 70. Climbing Stairs

class Solution {
    public int climbStairs(int n) {
        if(n <= 2) return n;
        int first = 2;
        int second = 1;
        int res = 1;
        while(n >= 3 ){
            res = first + second;
            second = first;
            first = res;
            n--;
        }
         return first;
                
        
    }
}
