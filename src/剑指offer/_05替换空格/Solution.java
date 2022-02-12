package 剑指offer._05替换空格;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class Solution {
    public String replaceSpace(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        char[] ch = s.toCharArray();
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : ch) {
            if (c != ' ') {
                stringBuilder.append(c);
            } else {
                stringBuilder.append("%20");
            }
        }
        return stringBuilder.toString();
    }
}