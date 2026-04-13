//1848. Minimum Distance to the Target Element
class Solution {
    public int getMinDistance(int[] nums, int target, int start) {
        int x = Integer.MAX_VALUE;
        int y = Integer.MAX_VALUE;
        for(int i = start;i < nums.length;i++){
            if(nums[i] == target) { 
                x= i-start;
                break;
            }
        }
        for(int i = start; i>=0;i--){
            if(nums[i] == target){
                y = start-i;
                break;
            }
        }
        return Math.min(x,y);
    }
}
