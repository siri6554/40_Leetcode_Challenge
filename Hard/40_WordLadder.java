import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> words = new HashSet<>(wordList);
        if (!words.contains(endWord)) return 0;
        Queue<String> q = new ArrayDeque<>();
        Set<String> seen = new HashSet<>();
        q.offer(beginWord); seen.add(beginWord);
        int steps = 1;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; size--) {
                String word = q.poll();
                if (word.equals(endWord)) return steps;
                char[] a = word.toCharArray();
                for (int i = 0; i < a.length; i++) {
                    char old = a[i];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        a[i] = c;
                        String next = new String(a);
                        if (words.contains(next) && seen.add(next)) q.offer(next);
                    }
                    a[i] = old;
                }
            }
            steps++;
        }
        return 0;
    }
}
