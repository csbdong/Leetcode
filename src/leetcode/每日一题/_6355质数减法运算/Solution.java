package leetcode.每日一题._6355质数减法运算;

public class Solution {
    public boolean primeSubOperation(int[] nums) {
        for (int i = nums.length - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                continue;
            }
            if (!findZs(nums, i)) {
                return false;
            }
        }
        return true;
    }


    private boolean findZs(int[] nums, int index) {
        int upper = nums[index + 1];//上限
        int curNum = findMinMinus(2);
        int now = nums[index];
        while (curNum < now) {
            if (now - curNum <= upper) {
                nums[index] = now - curNum;
                return true;
            } else {
                curNum = findMinMinus(curNum + 1);
            }
        }
        return false;
    }


    private int findMinMinus(int num) {
        int now = num;
        while (true) {

            boolean find = true;
            for (int i = 2; i <= Math.sqrt(now); i++) {
                if (now % i == 0) {
                    find = false;
                    break;
                }
            }
            if (find) {
                return now;
            } else {
                now++;
            }
        }
    }

    public static void main(String[] args) {
        new Solution().primeSubOperation(new int[]{5, 8, 3});
    }
}