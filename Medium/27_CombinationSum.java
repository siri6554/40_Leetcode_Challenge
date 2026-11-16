import java.util.*;

class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), ans);
        return ans;
    }
    private void backtrack(int[] a, int remain, int start, List<Integer> path,
                           List<List<Integer>> ans) {
        if (remain == 0) { ans.add(new ArrayList<>(path)); return; }
        for (int i = start; i < a.length; i++) {
            if (a[i] > remain) continue;
            path.add(a[i]);
            backtrack(a, remain - a[i], i, path, ans);
            path.remove(path.size() - 1);
        }
    }
}
