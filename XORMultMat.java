// 3653. XOR After Range Multiplication Queries I
class Solution {
    
    int mod = 1_000_000_007;
    public int xorAfterQueries(int[] nums, int[][] queries) {
        
        for(int[] arr:queries){

                int idx = arr[0];
                while(idx <= arr[1]){
                    nums[idx] = (int) ((1L * nums[idx] * arr[3]) % mod);
                    idx += arr[2];
                }
        }

        int res = nums[0];
        for(int i = 1; i < nums.length ; i++ ){
            System.out.println(nums[i]);
            res = res ^ nums[i];
        }
        return res;
    }
}
