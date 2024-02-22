package leetcode.每日一题._150反转字符串中的单词;

public class Solution {
    public String reverseWords(String s) {
        String[] str = s.split(" ");
        String res = new String();
        for (int i = str.length - 1; i >= 0; i--) {
            if (!str[i].contains(" ") && str[i].length() > 0) {
                res += str[i].trim() + " ";
            }
        }
        return res.trim();
    }

    public static void main(String[] args) {
        new Solution().reverseWords("a good   example");
    }
}