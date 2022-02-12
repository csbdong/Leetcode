package 剑指offer._50第一个只出现一次的字符;

import java.util.HashMap;
import java.util.Map;

public class Solution {
    public char firstUniqChar(String s) {
        if (s == null) {
            return ' ';
        }
        Map<Character, Integer> map = new HashMap();
        char[] ch = s.toCharArray();
        for (char c : ch) {
            if (map.get(c) == null) {
                map.put(c, 1);
            } else {
                map.put(c, map.get(c) + 1);
            }
        }
        for (char c : ch) {
            if (map.get(c) == 1) {
                return c;
            }
        }
        return ' ';

    }
}