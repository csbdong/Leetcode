package leetcode.每日一题._1673找出最具竞争力的子序列;



public class Solution {


    public int[] mostCompetitive(int[] nums, int k) {
        int[] res = new int[k];
        int index = 0;
        int left = 0;
        int right = nums.length - k + index;
        while (index < k) {
            int curMin = nums[left];
            for (int i = left; i <= right; i++) {
                if (curMin > nums[i]) {
                    curMin = nums[i];
                    left = i;
                }
            }
            res[index++] = curMin;
            right = nums.length - k + index;
            left++;
        }
        return res;

    }



    public static void main(String[] args) {
        new Solution().mostCompetitive(new int[]{2,4,3,3,5,4,9,6},4);
    }

}