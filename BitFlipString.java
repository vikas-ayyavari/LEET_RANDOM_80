//1888. Minimum Number of Flips to Make the Binary String Alternating
class Solution {
    public int minFlips(String s) {
        int n = s.length();
        String t = s + s; // simulate circular rotations

        // Build mismatch counters for two alternating targets:
        // alt1: "0101..." and alt2: "1010..."
        int mismatchesAlt1 = 0; // mismatches against "0101..."
        int mismatchesAlt2 = 0; // mismatches against "1010..."

        int res = Integer.MAX_VALUE;

        for (int r = 0, l = 0; r < t.length(); r++) {
            // Expected chars for alt1 and alt2 at position r
            char expectedAlt1 = (r % 2 == 0) ? '0' : '1';
            char expectedAlt2 = (r % 2 == 0) ? '1' : '0';

            if (t.charAt(r) != expectedAlt1) mismatchesAlt1++;
            if (t.charAt(r) != expectedAlt2) mismatchesAlt2++;

            // Maintain a sliding window of size n
            if (r - l + 1 > n) {
                char leftChar = t.charAt(l);
                char leftExpectedAlt1 = (l % 2 == 0) ? '0' : '1';
                char leftExpectedAlt2 = (l % 2 == 0) ? '1' : '0';
                if (leftChar != leftExpectedAlt1) mismatchesAlt1--;
                if (leftChar != leftExpectedAlt2) mismatchesAlt2--;
                l++;
            }

            if (r - l + 1 == n) {
                res = Math.min(res, Math.min(mismatchesAlt1, mismatchesAlt2));
            }
        }

        return res == Integer.MAX_VALUE ? 0 : res;
    }
}

/**

class Solution {
    public int minFlips(String s) {
        /*
        * Sliding Window Approach
        */
        
        
        int n = s.length();
        
        int mininumFlip = Integer.MAX_VALUE;
        
        int misMatchCount = 0;
        for(int i = 0; i < (2 * n); i++){
            
            int r = i % n;
            
            //add mis watch count in current window
            if((s.charAt(r) - '0') != (i % 2 == 0 ? 1 : 0)) misMatchCount++;
            
            //remove mismatch count which are not relvent for current window
            if(i >= n && (s.charAt(r) - '0') != (r % 2 == 0 ? 1 : 0)) misMatchCount--;
            
            
            //misMatchCount : when valid binary string start from 1
            //n - misMatchCount : when valid binary string start from 0
            if(i >= n - 1) mininumFlip = Math.min(mininumFlip, Math.min(misMatchCount, n - misMatchCount));
        }
        
        return mininumFlip;
    }
}

*/
