package 剑指offer._58_I翻转单词顺序;

public class Solution {
    public String reverseWords(String s) {
        if (s.length() ==0) {
            return s;
        }
        String[] strs = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (int i = strs.length - 1; i >= 0; i--) {
            if (strs[i].replaceAll(" ", "").length() == 0) {
                continue;
            }
            if (i == 0) {
                sb.append(strs[i].replaceAll(" ", ""));
            } else {
                sb.append(strs[i].replaceAll(" ", "") + " ");
            }
        }
        return sb.toString().trim();
    }

    public static void main(String[] args) {
        String s=(new Solution().reverseWords(" "));
        System.out.println();
    }
}