class Solution {
    public int[] searchRange(int[] nums, int target) {
        int first = bound(nums, target, true);
        if (first == nums.length || nums[first] != target) return new int[]{-1, -1};
        int after = bound(nums, target, false);
        return new int[]{first, after - 1};
    }
    private int bound(int[] a, int x, boolean lower) {
        int l = 0, r = a.length;
        while (l < r) {
            int m = l + (r - l) / 2;
            if (a[m] > x || (lower && a[m] == x)) r = m;
            else l = m + 1;
        }
        return l;
    }
}
