package 剑指offer._53_I在排序数组中查找数字I;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 */
public class Solution {
    public int search(int[] nums, int target) {
        int left = bin(nums, target, true);
        int right = bin(nums, target, false) - 1;
        if (left <= right && left >= 0 && right < nums.length && nums[left] == target && nums[right] == target) {
            return right - left + 1;
        }
        return 0;
    }

    private int bin(int[] nums, int target, boolean containEqual) {
        int left = 0;
        int right = nums.length - 1;
        int ans = nums.length;
        while (left <= right) {
            int m = (left + right) / 2;
            if (nums[m] > target || (containEqual && nums[m] >= target)) {
                right = m - 1;
                ans = m;
            } else {
                left = m + 1;
            }

        }
        return ans;
    }
}