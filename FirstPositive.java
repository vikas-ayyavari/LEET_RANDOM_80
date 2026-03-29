//41. First Missing Positive
class Solution {
    public int firstMissingPositive(int[] nums) {
        Arrays.sort(nums);
        int expected = 1;

        for (int i = 0; i < nums.length; i++) {
            // Skip negatives, zeros, and duplicates
            if (nums[i] <= 0 || (i > 0 && nums[i] == nums[i - 1])) {
                continue;
            }
            // If current number matches what we expect, move to next
            if (nums[i] == expected) {
                expected++;
            } else {
                // Gap found
                break;
            }
        }

        return expected;
    }
}
