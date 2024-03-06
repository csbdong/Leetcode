package leetcode.每日一题._2917找出数组中的Kor的值;

public class Solution {
    public int findKOr(int[] nums, int k) {
        int[] pos = new int[32];
        for (int num : nums) {
            int index = 0;
            while (num > 0) {
                if ((num & 1) == 1) {
                    pos[index]++;
                }
                index++;
                num /= 2;
            }
        }
        int res = 0;
        for (int i = 0; i < 32; i++) {
            if (pos[i] >= k) {
                res += Math.pow(2, i);
            }
        }
        return res;
    }


    public static void main(String[] args) {
        new Solution().findKOr(new int[]{7, 12, 9, 8, 9, 15}, 4);
    }
}
