package leetcode.每日一题._6319奇偶位数;

public class Solution {
    public int[] evenOddBit(int n) {
        int odd = 0;
        int even = 0;
        int index = 1;
        int pow = 1;
        while (n >= pow) {
            if ((n & pow) == pow) {
                if (index % 2 == 0) {
                    even++;
                } else {
                    odd++;
                }
            }
            index++;
            pow *= 2;
        }
        int[] result = new int[2];
        result[1] = even;
        result[0] = odd;
        return result;

    }

    public static void main(String[] args) {
        new Solution().evenOddBit(17);
    }
}
