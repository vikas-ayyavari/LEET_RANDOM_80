// Leetcode 3629
import java.util.*;

class Solution {

    public int minJumps(int[] nums) {

        int n = nums.length;

        if (n == 1)
            return 0;

        int max = 0;
        for (int x : nums)
            max = Math.max(max, x);

        // Smallest Prime Factor sieve
        int[] spf = new int[max + 1];

        for (int i = 2; i <= max; i++) {
            if (spf[i] == 0) {

                for (int j = i; j <= max; j += i) {
                    if (spf[j] == 0)
                        spf[j] = i;
                }
            }
        }

        // prime -> list of indices divisible by prime
        Map<Integer, List<Integer>> map = new HashMap<>();

        for (int i = 0; i < n; i++) {

            int temp = nums[i];

            Set<Integer> used = new HashSet<>();

            while (temp > 1) {

                int p = spf[temp];

                if (!used.contains(p)) {
                    map.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
                    used.add(p);
                }

                while (temp % p == 0)
                    temp /= p;
            }
        }

        Queue<Integer> q = new LinkedList<>();
        boolean[] visited = new boolean[n];

        q.offer(0);
        visited[0] = true;

        int jumps = 0;

        while (!q.isEmpty()) {

            int size = q.size();

            while (size-- > 0) {

                int idx = q.poll();

                if (idx == n - 1)
                    return jumps;

                // left move
                if (idx - 1 >= 0 && !visited[idx - 1]) {
                    visited[idx - 1] = true;
                    q.offer(idx - 1);
                }

                // right move
                if (idx + 1 < n && !visited[idx + 1]) {
                    visited[idx + 1] = true;
                    q.offer(idx + 1);
                }

                int val = nums[idx];

                // teleport only if current value itself is prime
                if (val >= 2 && spf[val] == val) {

                    List<Integer> next = map.getOrDefault(val, new ArrayList<>());

                    for (int ni : next) {

                        if (!visited[ni]) {
                            visited[ni] = true;
                            q.offer(ni);
                        }
                    }

                    // IMPORTANT optimization
                    // avoid revisiting same teleport list again
                    map.remove(val);
                }
            }

            jumps++;
        }

        return -1;
    }
}
