package leetcode.每日一题._1576替换所有的问号;

public class Solution {
    /** 思路一致 写法不优雅
        public String modifyString(String s) {
            int left = -1;
            int right = 1;
            int index = 0;
            char[] ch = s.toCharArray();
            while (index < ch.length) {
                char curChar = 'a';
                char cur = ch[index];
                if (cur != '?') {
                } else {
                    if (left >= 0 && right < ch.length) {
                        while (curChar == ch[left] || curChar == ch[right]) {
                            curChar = (char) ((curChar + 1) % 97 + 'a');
                        }

                    } else if (left >= 0) {
                        while (curChar == ch[left]) {
                            curChar = (char) ((curChar + 1) % 97 + 'a');
                        }
                    } else if (right < ch.length) {
                        while (curChar == ch[right]) {
                            curChar = (char) ((curChar + 1) % 97 + 'a');
                        }
                    }
                    ch[index] = curChar;


                }
                left++;
                right++;
                index++;
            }
            return String.valueOf(ch);
        }
     */

    public String modifyString(String s) {
        char[] ch = s.toCharArray();
        char[] replace = new char[]{'a', 'b', 'c'};
        for (int i = 0; i < ch.length; i++) {
            if (ch[i] == '?') {
                for (int j = 0; j < replace.length; j++) {
                    if (i > 0 && ch[i - 1] == replace[j] || i < ch.length - 1 && replace[j] == ch[i + 1]) {

                    } else {
                        ch[i] = replace[j];
                        break;
                    }
                }
            }
        }
        return String.valueOf(ch);
    }



    public static void main(String[] args) {
        new Solution().modifyString("j?qg??b");
    }
}