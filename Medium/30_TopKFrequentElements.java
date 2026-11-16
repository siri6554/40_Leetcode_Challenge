import java.util.*;

class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap<>();
        for (int x : nums) freq.put(x, freq.getOrDefault(x, 0) + 1);
        PriorityQueue<Integer> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(freq.get(a), freq.get(b)));
        for (int x : freq.keySet()) {
            pq.offer(x);
            if (pq.size() > k) pq.poll();
        }
        int[] ans = new int[k];
        for (int i = k - 1; i >= 0; i--) ans[i] = pq.poll();
        return ans;
    }
}
