// 1980. Find Unique Binary String
class Solution {
    public String findDifferentBinaryString(String[] nums) {
        StringBuilder res = new StringBuilder();
        for(int i = 0; i < nums[0].length();i++){
            res.append(nums[i].charAt(i) == '0' ? '1' : '0');
        }
        return res.toString();
    }
}
