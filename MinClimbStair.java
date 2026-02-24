//746. Min Cost Climbing Stairs

class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int prev = 0;
        int prev1 = 0;
        for(int x : cost){
            int curr = x+ Math.min(prev,prev1);
            prev1 = prev;
            prev= curr;
        }
       return Math.min(prev,prev1);
    }
}
