package leetcode.每日一题._438找到字符串中所有字母异位词;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        /**
         * solution1:暴力比较
        char[] chp = p.toCharArray();
        Arrays.sort(chp);
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i <= s.length() - p.length(); i++) {
            char[] tmp = s.substring(i, i + p.length()).toCharArray();
            Arrays.sort(tmp);
            boolean match = true;
            for (int j = 0; j < p.length(); j++) {
                if (chp[j] != tmp[j]) {
                    match = false;
                    break;
                }
            }
            if (match) {
                result.add(i);
            }

        }
        return result;
    }
    */


    /**
     * solution2:滑动窗口
     */
     if(s.length() <p.length())

    {
        return new ArrayList<>();
    }

    List<Integer> result = new ArrayList<>();
    int[] sCount = new int[26];
    int[] pCount = new int[26];
     for(
    int i = 0; i<p.length();i++)

    {
        ++sCount[s.charAt(i) - 'a'];
        ++pCount[p.charAt(i) - 'a'];
    }
     if(Arrays.equals(sCount,pCount))

    {
        result.add(0);
    }
     for(
    int i = 0; i<s.length()-p.length();i++)

    {
        --sCount[s.charAt(i) - 'a'];
        ++sCount[s.charAt(i + p.length()) - 'a'];
        if (Arrays.equals(sCount, pCount)) {
            result.add(i + 1);
        }
    }
     return result;
}

}