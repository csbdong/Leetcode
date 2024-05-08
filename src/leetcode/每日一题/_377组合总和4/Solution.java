package leetcode.每日一题._377组合总和4;

import java.util.*;

public class Solution {
    int res = 0;

    public int combinationSum4(int[] nums, int target) {
        dfs(new ArrayList(), 0, nums, target);
        return res;
    }

    void dfs(List<Integer> list, int curIndex, int[] nums, int target) {
        if (target == 0) {
            // 计算list产生的排列数
            res += calPoss(new ArrayList(list));
            return;
        }
        if (curIndex >= nums.length) {
            return;
        }
        dfs(list, curIndex + 1, nums, target);
        if (nums[curIndex] <= target) {
            list.add(nums[curIndex]);
            dfs(list, curIndex, nums, target - nums[curIndex]);
            list.remove(list.size() - 1);
        }
    }

    int calPoss(List<Integer> list) {
        if (list == null || list.size() == 0) {
            return 0;
        }
        Set<Integer> uniqueArray = new HashSet<>(list);

        int count = 1;
        for (int element : uniqueArray) {
            count *= uniqueArray.size();
        }

        return count / (int)Math.sqrt(uniqueArray.size());
    }

//    public static void main(String[] args) {
//        new Solution().combinationSum4(new int[]{1, 2, 3}, 4);
//    }


  
}