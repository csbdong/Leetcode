package leetcode.每日一题._49字母异位词分组;

import java.util.*;

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> store = new HashMap<String, List<String>>();
        for (String str : strs) {
            char[] ch = str.toCharArray();
            Arrays.sort(ch);
            List<String> list = store.getOrDefault(String.valueOf(ch), new ArrayList());
            list.add(str);
            store.put(String.valueOf(ch), list);
        }
        List<List<String>> res = new ArrayList();
        Iterator<List<String>> it = store.values().iterator();
        while (it.hasNext()) {
            List<String> list = it.next();
            res.add(list);
        }
        return res;

    }

    public static void main(String[] args) {
        new Solution().groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }
}