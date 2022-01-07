package leetcode.每日一题.括号的最大嵌套深度1614;

public class Solution {
    public int maxDepth(String s) {
        int curMax = 0;
        int result = 0;
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (c == '(') {
                curMax++;
                result = Math.max(curMax, result);
            } else if (c == ')') {
                curMax--;
            }
        }
        result = Math.max(curMax, result);
        return result;

    }
}
