//
class Solution {
    public int totalFruit(int[] fruits) {
        // HashMap to store fruit type and its count in current window
        Map<Integer, Integer> fruitCount = new HashMap<>();
      
        // Variable to store the maximum number of fruits collected
        int maxFruits = 0;
      
        // Sliding window approach with two pointers
        int left = 0;  // Left pointer of the window
      
        for (int right = 0; right < fruits.length; right++) {
            // Add current fruit to the window
            int currentFruit = fruits[right];
            fruitCount.merge(currentFruit, 1, Integer::sum);
          
            // Shrink window from left if we have more than 2 types of fruits
            while (fruitCount.size() > 2) {
                int leftFruit = fruits[left];
                left++;
              
                // Decrease count of the fruit being removed from window
                // If count becomes 0, remove the fruit type from map
                if (fruitCount.merge(leftFruit, -1, Integer::sum) == 0) {
                    fruitCount.remove(leftFruit);
                }
            }
          
            // Update maximum fruits collected (window size)
            maxFruits = Math.max(maxFruits, right - left + 1);
        }
      
        return maxFruits;
    }
}
