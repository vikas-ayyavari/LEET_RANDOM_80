// 3010. Divide an Array Into Subarrays With Minimum Cost I

class Solution {
    public int minimumCost(int[] nums) {
        Arrays.sort(nums,1,nums.length);
        return nums[0] + nums[1] + nums[2];
            
        
    }
}
