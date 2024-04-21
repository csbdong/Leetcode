package leetcode.每日一题._216组合总和3;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    List<List<Integer>> res = new ArrayList();
    int[] poss = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};

    public List<List<Integer>> combinationSum3(int k, int n) {
        com(new ArrayList(), 0, k, n);
        return res;
    }

    void com(List<Integer> cur, int nextIndex, int lastNum, int total) {
        if (lastNum < 0 || nextIndex > 9) {
            return;
        }
        if (total == 0 && lastNum == 0) {
            res.add(new ArrayList(cur));
            return;
        }
        com(cur, nextIndex + 1, lastNum, total);
        if (nextIndex < 9 && poss[nextIndex] <= total) {
            cur.add(poss[nextIndex]);
            com(cur, nextIndex + 1, lastNum - 1, total - poss[nextIndex]);
            cur.remove(cur.size() - 1);
        }
    }


    public static void main(String[] args) {
        new Solution().combinationSum3(9, 45);
    }
}