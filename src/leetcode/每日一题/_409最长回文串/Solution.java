package leetcode.每日一题._409最长回文串;

public class Solution {
    public int longestPalindrome(String s) {
        int[] nums = new int[128];
        for (int i = 0; i < s.length(); i++) {
            nums[s.charAt(i) - 'A']++;
        }
        boolean single = false;
        int pair = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 0) {
                pair += nums[i];
            } else {
                single = true;
                pair += nums[i] - 1;
            }
        }
        return single ? pair + 1 : pair;
    }
}