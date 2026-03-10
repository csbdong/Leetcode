package leetcode.hot100._76最小覆盖子串;

public class Solution {
    public String minWindow(String s, String t) {
        int[] tnum = new int[122];
        char[] chs = t.toCharArray();
        for (int i = 0; i < chs.length; i++) {
            tnum[chs[i] - 'A']++;
        }
        String res = "";
        for (int i = t.length() - 1; i < s.length(); i++) {
            for (int j = 0; j <= i - t.length() + 1; j++) {
                String str = s.substring(j, i + 1);
                int[] snum = new int[122];
                char[] shs = str.toCharArray();
                for (int h = 0; h < shs.length; h++) {
                    snum[shs[h] - 'A']++;
                }
                if (isMatch(snum, tnum) && (res == "" || (res.length() > str.length()))) {
                    res = str;
                }
            }
        }
        return res;
    }

    public boolean isMatch(int[] shs, int[] ths) {
        for (int i = 0; i < 122; i++) {
            if (shs[i] < ths[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String s1 = "gehzduwqkzuyotckqcusdiqubeqglkvuocttzrllqfjhzorpqnjwxbqyfiesscmigicfzn";
        String s2 = "qsvczwsslkhwg";
       new Solution().minWindow(s1, s2);

    }
}