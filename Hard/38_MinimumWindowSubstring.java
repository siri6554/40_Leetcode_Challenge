class Solution {
    public String minWindow(String s, String t) {
        if (s.length() < t.length()) return "";
        int[] count = new int[128];
        for (char c : t.toCharArray()) count[c]++;
        int left = 0, need = t.length(), bestStart = 0, bestLen = Integer.MAX_VALUE;
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            if (count[c] > 0) need--;
            count[c]--;
            while (need == 0) {
                int len = right - left + 1;
                if (len < bestLen) { bestLen = len; bestStart = left; }
                char drop = s.charAt(left++);
                count[drop]++;
                if (count[drop] > 0) need++;
            }
        }
        return bestLen == Integer.MAX_VALUE ? "" : s.substring(bestStart, bestStart + bestLen);
    }
}
